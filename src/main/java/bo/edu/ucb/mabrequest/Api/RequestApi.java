package bo.edu.ucb.mabrequest.Api;

import bo.edu.ucb.mabrequest.Bl.RequestBl;
import bo.edu.ucb.mabrequest.Dto.RequestDto;
import bo.edu.ucb.mabrequest.Dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/request")
public class RequestApi {

    @GetMapping()
    public ResponseDto<List<RequestDto>> getRequests() {
        ResponseDto<List<RequestDto>> responseDto = new ResponseDto<>();
        RequestBl requestBl = new RequestBl();
        requestBl.getAllRequests();
        responseDto.setMessage("All requests");
        responseDto.setData(requestBl.getAllRequests());
        responseDto.setCode(200);
        return responseDto;
    }



}
