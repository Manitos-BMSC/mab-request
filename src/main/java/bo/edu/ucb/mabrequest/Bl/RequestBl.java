package bo.edu.ucb.mabrequest.Bl;

import bo.edu.ucb.mabrequest.Dto.CycleDto;
import bo.edu.ucb.mabrequest.Dto.PatientDto;
import bo.edu.ucb.mabrequest.Dto.RequestDto;
import bo.edu.ucb.mabrequest.Service.FileUploaderService;
import bo.edu.ucb.mabrequest.dao.FilesPatient;
import bo.edu.ucb.mabrequest.dao.Patient;
import bo.edu.ucb.mabrequest.dao.Request;
import bo.edu.ucb.mabrequest.dao.repository.FilesPatientRepository;
import bo.edu.ucb.mabrequest.dao.repository.PatientRepository;
import bo.edu.ucb.mabrequest.dao.repository.RequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class RequestBl {
    @Autowired
    private FileUploaderService fileUploaderService;

    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private FilesPatientRepository filesPatientRepository;



    private Logger logger = LoggerFactory.getLogger(RequestBl.class);

    public List<RequestDto> getRequestsForActualCycle(Long cycleId){
        logger.info("Access from database");
        List<Request> requests = requestRepository.findAllByCycleIdAndRequestState(cycleId.intValue(), "Pendiente");
        if(requests.isEmpty()){
            logger.info("No requests for this cycle");
            return null;
        }
        List<RequestDto> requestDtoList = new ArrayList<>();
        for ( Request request: requests) {
            RequestDto requestDto = new RequestDto();
            requestDtoList.add(transformRequest(request));
        }
        return requestDtoList;
    }

    public Request assignDoctor(Long requestId, int doctorId, int chiefDoctorId){
        Request request = requestRepository.findOneById(requestId);
        if(request == null){
            logger.info("request not found");
            return null;
        }
        request.setChiefDoctorId(chiefDoctorId);
        request.setDoctorId(doctorId);
        request.setRequestState("Aceptado");
        requestRepository.save(request);
        return request;
    }

    public Request rejectRequest(Long requestId){
        Request request = requestRepository.findOneById(requestId);
        if(request == null){
            logger.info("request not found");
            return null;
        }
        request.setRequestState("Rechazado");
        requestRepository.save(request);
        return request;
    }

    public void createRequest (PatientDto patientDto, CycleDto actualCycle){
        Request request = new Request();
        request.setPacientId(patientDto.getPatientId());
        request.setCycleId(actualCycle.getCycleId().intValue());
        request.setRequestState("Pendiente");
        request.setRequestDate(new Date());
        request.setConsentInformed("Pendiente");
        request.setRequestResponse("");
        request.setStatus(true);
        requestRepository.save(request);
    }

    public RequestDto transformRequest(Request request){
        logger.info("Entering transformRequest");
        RequestDto requestDto = new RequestDto();
        requestDto.setRequestId(request.getId());
        logger.info("request id: " + request.getId());
        logger.info("request patient id: " + request.getPacientId());
        Patient patient = patientRepository.findOneById(request.getPacientId());
        logger.info("patient: " + patient.toString());
        requestDto.setName(patient.getPerson().getName());
        requestDto.setLastName(patient.getPerson().getLastname());
        requestDto.setEmail(patient.getPerson().getUserMail());
        requestDto.setPhone(patient.getPerson().getPhoneNumber());
        requestDto.setBirthDate(patient.getPerson().getBirthDate());
        requestDto.setMale(patient.getPerson().isGender());
        requestDto.setAddress(patient.getPerson().getAddress());
        requestDto.setDocumentNumber(patient.getPerson().getDocumentNumber());
        requestDto.setPassport(patient.getPerson().isDocumentType());
        requestDto.setCity(patient.getPerson().getCity().getName());
        requestDto.setEmergencyPhone(patient.getEmergencyPhone());
        logger.info("Getting patient files");
        List<FilesPatient> filesFromPatient = filesPatientRepository.findAllByPacientId(patient.getId());
        for (FilesPatient file : filesFromPatient ){
            switch (file.getS3Object().getBucket()) {
                case "mab-patient-images" ->
                        requestDto.setImage(fileUploaderService.getFile(file.getS3Object().getBucket(), file.getS3Object().getFileName()));
                case "mab-patient-videos" ->
                        requestDto.setVideo(fileUploaderService.getFile(file.getS3Object().getBucket(), file.getS3Object().getFileName()));
                case "mab-patient-documents" ->
                        requestDto.setDocumentation(fileUploaderService.getFile(file.getS3Object().getBucket(), file.getS3Object().getFileName()));
                default ->
                        requestDto.setInformedConsent(fileUploaderService.getFile(file.getS3Object().getBucket(), file.getS3Object().getFileName()));
            }
        }
        logger.info("Getting patient files FINISHED");
//        requestDto.setRequestDate(request.getRequestDate());
//        requestDto.setConsentInformed(request.getConsentInformed());
//        requestDto.setRequestResponse(request.getRequestResponse());
//        requestDto.setStatus(request.getStatus());
        return requestDto;
    }


//    public RequestDto createRequest(RequestDto requestDto){
//        Request request = new Request();
//        request.setPatientId(requestDto.getPatientId());
//        request.setCycleId(requestDto.getCycleId());
//        request.setRequestState("Pendiente");
//        requestRepository.save(request);
//        //convert request to requestDto
//        ObjectMapper objectMapper = new ObjectMapper();
//        RequestDto requestDtoResponse = objectMapper.convertValue(request, RequestDto.class);
//        return requestDtoResponse;
//    }


}