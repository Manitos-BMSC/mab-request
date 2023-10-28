package bo.edu.ucb.mabrequest.Bl;

import bo.edu.ucb.mabrequest.Dto.CycleDto;
import bo.edu.ucb.mabrequest.Dto.PatientDto;
import bo.edu.ucb.mabrequest.Dto.RequestDto;
import bo.edu.ucb.mabrequest.Dto.ResponseDto;
import bo.edu.ucb.mabrequest.dao.Request;
import bo.edu.ucb.mabrequest.dao.repository.RequestRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.weaver.ast.Call;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.List;


@Service
public class RequestBl {

    @Autowired
    private RequestRepository requestRepository;

    private Logger logger = LoggerFactory.getLogger(RequestBl.class);

    public List<RequestDto> getRequestsForActualCycle(Long cycleId){
        List<Request> requests = requestRepository.findAllByCycleId(cycleId.intValue());
        if(requests.isEmpty()){
            logger.info("No requests for this cycle");
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        logger.info("requests: " + requests);
        List<RequestDto> requestDtos = objectMapper.convertValue(requests, new TypeReference<List<RequestDto>>() {});
        return requestDtos;
    }

    public RequestDto assignDoctor(Long requestId, int doctorId){
        Request request = requestRepository.findOneById(requestId);
        if(request == null){
            logger.info("request not found");
            return null;
        }
        request.setDoctorId(doctorId);
        request.setRequestState("Aceptado");
        //TODO revisar si deberia ser un update o un save
        requestRepository.save(request);
        //convert request to requestDto
        ObjectMapper objectMapper = new ObjectMapper();
        RequestDto requestDto = objectMapper.convertValue(request, RequestDto.class);
        return requestDto;
    }

    public RequestDto rejectRequest(Long requestId){
        Request request = requestRepository.findOneById(requestId);
        if(request == null){
            logger.info("request not found");
            return null;
        }
        request.setRequestState("Rechazado");
        requestRepository.save(request);
        //convert request to requestDto
        ObjectMapper objectMapper = new ObjectMapper();
        RequestDto requestDto = objectMapper.convertValue(request, RequestDto.class);
        return requestDto;
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