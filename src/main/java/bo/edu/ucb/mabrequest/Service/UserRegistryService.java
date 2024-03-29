package bo.edu.ucb.mabrequest.Service;

import bo.edu.ucb.mabrequest.Dto.PatientDto;
import bo.edu.ucb.mabrequest.Dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Service
@FeignClient("mab-user-registry")
public interface UserRegistryService {

    @PostMapping(value = "/api/v1/registry/patient", consumes = {"multipart/form-data"})
    public ResponseDto<PatientDto> registerPatient(@RequestParam("data") String patientDtoJson,
                                                                   @RequestPart("image") MultipartFile image,
                                                                   @RequestPart("clinicHistory") MultipartFile clinicHistory,
                                                                   @RequestPart("participationVideo") MultipartFile participationVideo,
                                                                   @RequestPart("personalDocument") MultipartFile personalDocument,
                                                   @RequestHeader("Authorization") String token
    );

}
