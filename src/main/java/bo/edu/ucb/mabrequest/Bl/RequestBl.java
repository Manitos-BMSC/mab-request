package bo.edu.ucb.mabrequest.Bl;

import bo.edu.ucb.mabrequest.Dto.RequestDto;
import bo.edu.ucb.mabrequest.Dto.ResponseDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.weaver.ast.Call;
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
}