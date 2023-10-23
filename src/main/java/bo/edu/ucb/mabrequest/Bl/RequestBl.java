package bo.edu.ucb.mabrequest.Bl;

import bo.edu.ucb.mabrequest.Dto.RequestDto;
import bo.edu.ucb.mabrequest.Dto.ResponseDto;
import bo.edu.ucb.mabrequest.dao.Request;
import bo.edu.ucb.mabrequest.dao.repository.RequestRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.weaver.ast.Call;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


@Service
public class RequestBl {

    @Autowired
    private RequestRepository requestRepository;

    private Logger logger = LoggerFactory.getLogger(RequestBl.class);

    public List<RequestDto> getAllRequests() {
        HttpClient client = HttpClient.newHttpClient();
        String service = "http://localhost:9010/api/v1/request";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(service))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
            }
            ObjectMapper objectMapper = new ObjectMapper();
            List<RequestDto> requestDtos = objectMapper.readValue(response.body(), new TypeReference<List<RequestDto>>() {});
            return requestDtos;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<RequestDto> getRequestsForActualCycle(Long cycleId){
        List<Request> requests = requestRepository.findAllByCycleId(cycleId.intValue());
        if(requests.isEmpty()){
            logger.info("No requests for this cycle");
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        logger.info("requests: " + requests);
        List<RequestDto> requestDtos = objectMapper.convertValue(requests, new TypeReference<List<RequestDto>>() {});
        return requestDtos;
    }

    public RequestDto assignDoctor(Long requestId, int doctorId){
        Request request = requestRepository.findOneById(requestId);
        if(request == null){
            logger.info("request not found");
            return null;
        }
        request.setDoctorId(doctorId);
        request.setRequestState("Aceptado");
        requestRepository.save(request);
        //convert request to requestDto
        ObjectMapper objectMapper = new ObjectMapper();
        RequestDto requestDto = objectMapper.convertValue(request, RequestDto.class);
        return requestDto;
    }

    public RequestDto rejectRequest(Long requestId){
        Request request = requestRepository.findOneById(requestId);
        if(request == null){
            logger.info("request not found");
            return null;
        }
        request.setRequestState("Rechazado");
        requestRepository.save(request);
        //convert request to requestDto
        ObjectMapper objectMapper = new ObjectMapper();
        RequestDto requestDto = objectMapper.convertValue(request, RequestDto.class);
        return requestDto;
    }
}