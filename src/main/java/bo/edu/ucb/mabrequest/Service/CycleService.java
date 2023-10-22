package bo.edu.ucb.mabrequest.Service;

import bo.edu.ucb.mabrequest.Dto.CycleDto;
import bo.edu.ucb.mabrequest.Dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient("mab-cycle")
public interface CycleService {

    @GetMapping(value = "/api/v1/cycle")
    public ResponseEntity<ResponseDto<CycleDto>> getCurrentCycle();

}
