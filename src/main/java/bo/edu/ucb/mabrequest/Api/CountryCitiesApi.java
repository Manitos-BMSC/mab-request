package bo.edu.ucb.mabrequest.Api;

import bo.edu.ucb.mabrequest.Bl.CountryCitiesBl;
import bo.edu.ucb.mabrequest.Dto.CountryCityDto;
import bo.edu.ucb.mabrequest.Dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/country-cities")
public class CountryCitiesApi {

    @Autowired
    private CountryCitiesBl countryCitiesBl;

    private final Logger logger = LoggerFactory.getLogger(CountryCitiesApi.class);

    @GetMapping()
    public ResponseDto<List<CountryCityDto>> getAllCountriesCities(){
        logger.info("getAllCountriesCities");
        List<CountryCityDto> countryCities =  countryCitiesBl.getAllCountriesCities();
        int code = 200;
        String message = "OK";
        Boolean success = true;
        ResponseDto<List<CountryCityDto>> response = new ResponseDto<>(success, message, code, countryCities);
        System.out.println("response: " + response);
        return response;
    }

}
