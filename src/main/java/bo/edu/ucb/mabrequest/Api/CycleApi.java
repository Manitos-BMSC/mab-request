package bo.edu.ucb.mabrequest.Api;

import bo.edu.ucb.mabrequest.Bl.CycleBl;
import bo.edu.ucb.mabrequest.Dto.CycleDto;
import bo.edu.ucb.mabrequest.Dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cycle")
public class CycleApi {

    @Autowired
    private CycleBl cycleBl;

    private final Logger logger = LoggerFactory.getLogger(CycleApi.class);

    @GetMapping()
    public ResponseDto<CycleDto> getCurrentCycle(){
        logger.info("getCurrentCycle");
        CycleDto currentCycle =  cycleBl.getCurrentCycle();
        int code = 200;
        String message = "OK";
        Boolean success = true;
        ResponseDto<CycleDto> response = new ResponseDto<>(success, message, code, currentCycle);
        System.out.println("response: " + response);
        return response;
    }

    @PostMapping()
    public ResponseDto<CycleDto> createCycle(
            @RequestBody CycleDto cycleDto
    ){
        logger.info("createCycle");
        CycleDto currentCycle =  cycleBl.createCycle(cycleDto);
        int code = 200;
        String message = "OK";
        Boolean success = true;
        ResponseDto<CycleDto> response = new ResponseDto<>(success, message, code, currentCycle);
        System.out.println("response: " + response);
        return response;
    }

}
