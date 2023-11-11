package bo.edu.ucb.mabrequest.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient("mab-file-uploader")
public interface FileUploaderService {
    @GetMapping(value = "/api/v1/files")
    public String getFile(@RequestParam String bucket, @RequestParam String fileName, @RequestHeader("Authorization") String token);
}
