package bo.edu.ucb.mabrequest.Dto;

import java.util.List;

public class RequestDto {
    private int requestId;
    private String requestState;
    private String pacientCity;
    private String pacientName;
    private String pacientLastName;
    private String pacientAddress;
    private String pacientPhone;
    private String pacientEmail;
    private String clinicHistory;
    private String participationVideo;
    private List<String> images;

    public RequestDto() {
    }

    public RequestDto(int requestId, String requestState, String pacientCity, String pacientName, String pacientLastName, String pacientAddress, String pacientPhone, String pacientEmail, String clinicHistory, String participationVideo, List<String> images) {
        this.requestId = requestId;
        this.requestState = requestState;
        this.pacientCity = pacientCity;
        this.pacientName = pacientName;
        this.pacientLastName = pacientLastName;
        this.pacientAddress = pacientAddress;
        this.pacientPhone = pacientPhone;
        this.pacientEmail = pacientEmail;
        this.clinicHistory = clinicHistory;
        this.participationVideo = participationVideo;
        this.images = images;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getRequestState() {
        return requestState;
    }

    public void setRequestState(String requestState) {
        this.requestState = requestState;
    }

    public String getPacientCity() {
        return pacientCity;
    }

    public void setPacientCity(String pacientCity) {
        this.pacientCity = pacientCity;
    }

    public String getPacientName() {
        return pacientName;
    }

    public void setPacientName(String pacientName) {
        this.pacientName = pacientName;
    }

    public String getPacientLastName() {
        return pacientLastName;
    }

    public void setPacientLastName(String pacientLastName) {
        this.pacientLastName = pacientLastName;
    }

    public String getPacientAddress() {
        return pacientAddress;
    }

    public void setPacientAddress(String pacientAddress) {
        this.pacientAddress = pacientAddress;
    }

    public String getPacientPhone() {
        return pacientPhone;
    }

    public void setPacientPhone(String pacientPhone) {
        this.pacientPhone = pacientPhone;
    }

    public String getPacientEmail() {
        return pacientEmail;
    }

    public void setPacientEmail(String pacientEmail) {
        this.pacientEmail = pacientEmail;
    }

    public String getClinicHistory() {
        return clinicHistory;
    }

    public void setClinicHistory(String clinicHistory) {
        this.clinicHistory = clinicHistory;
    }

    public String getParticipationVideo() {
        return participationVideo;
    }

    public void setParticipationVideo(String participationVideo) {
        this.participationVideo = participationVideo;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
