package bo.edu.ucb.mabrequest.Api;

import bo.edu.ucb.mabrequest.Bl.RequestBl;
import bo.edu.ucb.mabrequest.Dto.PatientDto;
import bo.edu.ucb.mabrequest.Dto.RequestDto;
import bo.edu.ucb.mabrequest.Dto.ResponseDto;
import bo.edu.ucb.mabrequest.Service.UserRegistryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RequestApi {

    private UserRegistryService userRegistryService;

    public RequestApi(UserRegistryService userRegistryService) {
        this.userRegistryService = userRegistryService;
    }

    @GetMapping("/request")
    public ResponseDto<List<RequestDto>> getRequests() {
        ResponseDto<List<RequestDto>> responseDto = new ResponseDto<>();
        RequestBl requestBl = new RequestBl();
        requestBl.getAllRequests();
        responseDto.setMessage("All requests");
        responseDto.setData(requestBl.getAllRequests());
        responseDto.setCode(200);
        return responseDto;
    }

    @PostMapping("/patient")
    public ResponseEntity<ResponseDto<PatientDto>> createPatient(
            @RequestParam("data") String patientDtoJson,
            @RequestParam("image") MultipartFile image,
            @RequestParam("clinicHistory") MultipartFile clinicHistory,
            @RequestParam("participationVideo") MultipartFile participationVideo,
            @RequestParam("personalDocument") MultipartFile personalDocument
    ) throws JsonProcessingException {
        return userRegistryService.registerPatient( patientDtoJson, image, clinicHistory, participationVideo, personalDocument);
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



}
