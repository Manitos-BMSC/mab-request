package bo.edu.ucb.mabrequest.dao;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MAB_request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "doctor_id")
    private Integer doctorId;

    @Column(name = "chief_doctor_id")
    private Integer chiefDoctorId;

    @Column(name = "pacient_id")
    private Integer pacientId;

    @Column(name = "cycle_id")
    private Integer cycleId;

    @Column(name = "request_state")
    private String requestState;

    @Column(name = "request_date")
    private Date requestDate;

    @Column(name = "consent_informed")
    private String consentInformed;

    @Column(name = "request_response")
    private String requestResponse;

    @Column(name = "status")
    private boolean status;

    public Request() {
    }

    public Request(Long id, Integer doctorId, Integer chiefDoctorId, Integer pacientId, Integer cycleId, String requestState, Date requestDate, String consentInformed, String requestResponse, boolean status) {
        this.id = id;
        this.doctorId = doctorId;
        this.chiefDoctorId = chiefDoctorId;
        this.pacientId = pacientId;
        this.cycleId = cycleId;
        this.requestState = requestState;
        this.requestDate = requestDate;
        this.consentInformed = consentInformed;
        this.requestResponse = requestResponse;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getChiefDoctorId() {
        return chiefDoctorId;
    }

    public void setChiefDoctorId(Integer chiefDoctorId) {
        this.chiefDoctorId = chiefDoctorId;
    }

    public Integer getPacientId() {
        return pacientId;
    }

    public void setPacientId(Integer pacientId) {
        this.pacientId = pacientId;
    }

    public Integer getCycleId() {
        return cycleId;
    }

    public void setCycleId(Integer cycleId) {
        this.cycleId = cycleId;
    }

    public String getRequestState() {
        return requestState;
    }

    public void setRequestState(String requestState) {
        this.requestState = requestState;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getConsentInformed() {
        return consentInformed;
    }

    public void setConsentInformed(String consentInformed) {
        this.consentInformed = consentInformed;
    }

    public String getRequestResponse() {
        return requestResponse;
    }

    public void setRequestResponse(String requestResponse) {
        this.requestResponse = requestResponse;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
