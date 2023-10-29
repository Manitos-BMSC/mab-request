package bo.edu.ucb.mabrequest.Api;

import bo.edu.ucb.mabrequest.Bl.CycleBl;
import bo.edu.ucb.mabrequest.Bl.RequestBl;
import bo.edu.ucb.mabrequest.Dto.CycleDto;
import bo.edu.ucb.mabrequest.Dto.PatientDto;
import bo.edu.ucb.mabrequest.Dto.RequestDto;
import bo.edu.ucb.mabrequest.Dto.ResponseDto;
import bo.edu.ucb.mabrequest.Service.CycleService;
import bo.edu.ucb.mabrequest.Service.KeycloakTokenService;
import bo.edu.ucb.mabrequest.Service.UserRegistryService;
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

    public RequestApi(UserRegistryService userRegistryService, KeycloakTokenService keycloakTokenServic) {
        this.userRegistryService = userRegistryService;
        this.keycloakTokenService = keycloakTokenServic;
    }


    /*@GetMapping("/request")
    public ResponseDto<List<RequestDto>> getRequests() {
        ResponseDto<List<RequestDto>> responseDto = new ResponseDto<>();
        RequestBl requestBl = new RequestBl();
        requestBl.getAllRequests();
        responseDto.setMessage("All requests");
        responseDto.setData(requestBl.getAllRequests());
        responseDto.setCode(200);
        return responseDto;
    }*/

    @GetMapping("/request")
    public ResponseEntity<ResponseDto<List<RequestDto>>> getRequests() {
        logger.info("getting acual cycle");
        CycleDto actualCycle = cycleBl.getCurrentCycle();
        logger.info("actualCycle: " + actualCycle);
        List<RequestDto> requests = requestBl.getRequestsForActualCycle(actualCycle.getCycleId());
        int code = 200;
        String message = "OK";
        Boolean success = true;
        ResponseDto<List<RequestDto>> response = new ResponseDto<>(success, message, code, requests);
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping("/patient")
    public ResponseEntity<ResponseDto<PatientDto>> createPatient(
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

        return ResponseEntity.status(HttpStatus.OK).body(newPacient);
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

    @PutMapping("/doctor/assign/{requestId}/{doctorId}/{state}")
    public ResponseEntity<ResponseDto<RequestDto>> updateRequest(
            @PathVariable("requestId") Long requestId,
            @PathVariable("doctorId") int doctorId,
            @PathVariable("state") String state
    ) throws JsonProcessingException {
        RequestDto requestResponse = null;
        if (state.equals("Aceptado")) {
            logger.info("assignDoctor");
            requestResponse = requestBl.assignDoctor(requestId, doctorId);
        } else if (state.equals("Rechazado")) {
            logger.info("rejectRequest");
            requestResponse = requestBl.rejectRequest(requestId);
        }

        int code = 200;
        String message = "OK";
        Boolean success = true;
        ResponseDto<RequestDto> response = new ResponseDto<>(success, message, code, requestResponse);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
