package bo.edu.ucb.mabrequest.Service;

import bo.edu.ucb.mabrequest.Dto.PatientDto;
import bo.edu.ucb.mabrequest.Dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
@FeignClient("mab-user-registry")
public interface UserRegistryService {

    @PostMapping("/api/v1/registry/patient")
    public ResponseEntity<ResponseDto<PatientDto>> registerPatient(@RequestParam("data") String patientDtoJson,
                                                                   @RequestParam("image") MultipartFile image,
                                                                   @RequestParam("clinicHistory") MultipartFile clinicHistory,
                                                                   @RequestParam("participationVideo") MultipartFile participationVideo,
                                                                   @RequestParam("personalDocument") MultipartFile personalDocument);
}
