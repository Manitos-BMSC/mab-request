package bo.edu.ucb.mabrequest.Dto;

public class AsignDoctorDto {
    private Integer chiefDoctorId;
    private Integer doctorId;
    private String requestState;


    public AsignDoctorDto() {
    }

    public AsignDoctorDto(Integer chiefDoctorId, Integer doctorId, String requestState) {
        this.chiefDoctorId = chiefDoctorId;
        this.doctorId = doctorId;
        this.requestState = requestState;
    }

    public Integer getChiefDoctorId() {
        return chiefDoctorId;
    }

    public void setChiefDoctorId(Integer chiefDoctorId) {
        this.chiefDoctorId = chiefDoctorId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getRequestState() {
        return requestState;
    }

    public void setRequestState(String requestState) {
        this.requestState = requestState;
    }

    @Override
    public String toString() {
        return "AsignDoctorDto{" +
                "chiefDoctorId=" + chiefDoctorId +
                ", doctorId=" + doctorId +
                ", requestState='" + requestState + '\'' +
                '}';
    }
}
