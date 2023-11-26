package bo.edu.ucb.mabrequest.Api;

import bo.edu.ucb.mabrequest.Bl.CycleBl;
import bo.edu.ucb.mabrequest.Bl.RequestBl;
import bo.edu.ucb.mabrequest.Dto.*;
import bo.edu.ucb.mabrequest.Service.CycleService;
import bo.edu.ucb.mabrequest.Service.KeycloakTokenService;
import bo.edu.ucb.mabrequest.Service.UserRegistryService;
import bo.edu.ucb.mabrequest.dao.Request;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class RequestApi {

    @Autowired
    private RequestBl requestBl;

    @Autowired
    private CycleBl cycleBl;

    private final UserRegistryService userRegistryService;

    private final KeycloakTokenService keycloakTokenService;


    private final Logger logger = LoggerFactory.getLogger(RequestApi.class);

    public RequestApi(UserRegistryService userRegistryService, KeycloakTokenService keycloakTokenService) {
        this.userRegistryService = userRegistryService;
        this.keycloakTokenService = keycloakTokenService;
    }

    @GetMapping("/request")
    public ResponseDto<List<RequestDto>> getRequests() {
        logger.info("getting acual cycle");
        Map<String, ?> token = keycloakTokenService.getToken(
                "client_credentials",
                "mab_backend",
                "mzhqeGKq8LiwBb9tQ6q1z4HONF6to3tr"
        );
        String accessToken = "Bearer " + token.get("access_token");
        CycleDto actualCycle = cycleBl.getCurrentCycle();
        logger.info("actualCycle: " + actualCycle);
        List<RequestDto> requests = requestBl.getRequestsForActualCycle(actualCycle.getCycleId(), accessToken);
        int code = 200;
        String message = "OK";
        Boolean success = true;
        ResponseDto<List<RequestDto>> response = new ResponseDto<>(success, message, code, requests);
        return response;
    }

    @PostMapping("/registry/patient")
    public ResponseDto<PatientDto> createPatient(
            @RequestParam("data") String patientDtoJson,
            @RequestParam("image") MultipartFile image,
            @RequestParam("clinicHistory") MultipartFile clinicHistory,
            @RequestParam("participationVideo") MultipartFile participationVideo,
            @RequestParam("personalDocument") MultipartFile personalDocument
    ) throws JsonProcessingException {
        System.out.println("patientDtoJson: " + patientDtoJson);
        //get token
        logger.info("Getting token");
        Map<String, ?> token = keycloakTokenService.getToken(
                "client_credentials",
                "mab_backend",
                "mzhqeGKq8LiwBb9tQ6q1z4HONF6to3tr"
        );

        String accessToken = "Bearer " + token.get("access_token");
        logger.info("token: " + accessToken);


        logger.info("Registering new patient");
        ResponseDto<PatientDto> newPacient = userRegistryService.registerPatient(patientDtoJson, image, clinicHistory, participationVideo, personalDocument, accessToken);
        logger.info("New patient registered");

        logger.info("Getting current cycle");
        CycleDto actualCycle = cycleBl.getCurrentCycle();

        logger.info("Request created");
        requestBl.createRequest(newPacient.getData(), actualCycle);

        return newPacient;
        /*ObjectMapper objectMapper = new ObjectMapper();
        PatientDto patientDto = objectMapper.readValue(patientDtoJson, PatientDto.class);
        System.out.println("patientDto: " + patientDto);

        PatientDto patientResponse = registryBl.createPatient(patientDto);
        int code = 200;
        String message = "OK";
        Boolean success = true;
        ResponseDto<PatientDto> response = new ResponseDto<>(success, message, code, patientResponse);
        System.out.println("response: " + response);
        return ResponseEntity.status(HttpStatus.OK).body(response);*/
    }

    @PutMapping("/doctor/assign/{requestId}")
    public ResponseDto<Request> updateRequest(
            @PathVariable("requestId") Long requestId,
            @RequestBody AsignDoctorDto asignDoctorDto
    ) throws JsonProcessingException {
        Map<String, ?> token = keycloakTokenService.getToken(
                "client_credentials",
                "mab_backend",
                "mzhqeGKq8LiwBb9tQ6q1z4HONF6to3tr"
        );
        String accessToken = "Bearer " + token.get("access_token");

        Request requestResponse = null;
        if (asignDoctorDto.getRequestState().equals("Aceptado")) {
            logger.info("assignDoctor");
            requestResponse = requestBl.assignDoctor(requestId, asignDoctorDto.getDoctorId(), asignDoctorDto.getChiefDoctorId(), accessToken);
        } else if (asignDoctorDto.getRequestState().equals("Rechazado")) {
            logger.info("rejectRequest");
            requestResponse = requestBl.rejectRequest(requestId, accessToken);
        }
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode(200);
        responseDto.setMessage("OK");
        responseDto.setSuccess(true);
        responseDto.setData(requestResponse);

        return responseDto;
    }

    @GetMapping("/doctor/{doctorId}/requests")
    public ResponseDto<List<RequestPatientDto>> getRequestsForDoctor(
            @PathVariable("doctorId") Long doctorId
    ) {
        Map<String, ?> token = keycloakTokenService.getToken(
                "client_credentials",
                "mab_backend",
                "mzhqeGKq8LiwBb9tQ6q1z4HONF6to3tr"
        );
        String accessToken = "Bearer " + token.get("access_token");
        logger.info("getRequestsForDoctor");
        List<RequestPatientDto> requests = requestBl.getRequestForDoctor(doctorId, accessToken);
        ResponseDto<List<RequestPatientDto>> responseDto = new ResponseDto<>();
        responseDto.setCode(200);
        responseDto.setMessage("OK");
        responseDto.setSuccess(true);
        responseDto.setData(requests);
        return responseDto;
    }

    @GetMapping("/request/patient/{patientId}")
    public ResponseDto<RequestDto> getRequestForPatient(
            @PathVariable("patientId") Long patientId
    ) {
        Map<String, ?> token = keycloakTokenService.getToken(
                "client_credentials",
                "mab_backend",
                "mzhqeGKq8LiwBb9tQ6q1z4HONF6to3tr"
        );
        String accessToken = "Bearer " + token.get("access_token");
        logger.info("getRequestForPatient");
        RequestDto request = requestBl.getRequestForPatient(patientId, accessToken);
        ResponseDto<RequestDto> responseDto = new ResponseDto<>();
        responseDto.setCode(200);
        responseDto.setMessage("OK");
        responseDto.setSuccess(true);
        responseDto.setData(request);
        return responseDto;
    }

}
