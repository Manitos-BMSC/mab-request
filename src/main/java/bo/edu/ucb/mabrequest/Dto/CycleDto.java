package bo.edu.ucb.mabrequest.Dto;

import java.util.Date;

public class CycleDto {

    private Long cycleId;
    private int cycleYear;
    private int maxPatients;
    private int maxDoctors;
    private Date dateEndRegistry;
    private String state;
    private int status;

    public CycleDto() {
    }

    public CycleDto(Long cycleId, int cycleYear, int maxPatients, int maxDoctors, Date dateEndRegistry, String state, int status) {
        this.cycleId = cycleId;
        this.cycleYear = cycleYear;
        this.maxPatients = maxPatients;
        this.maxDoctors = maxDoctors;
        this.dateEndRegistry = dateEndRegistry;
        this.state = state;
        this.status = status;
    }

    // Getters and setters


    public Long getCycleId() {
        return cycleId;
    }

    public void setCycleId(Long cycleId) {
        this.cycleId = cycleId;
    }

    public int getCycleYear() {
        return cycleYear;
    }

    public void setCycleYear(int cycleYear) {
        this.cycleYear = cycleYear;
    }

    public int getMaxPatients() {
        return maxPatients;
    }

    public void setMaxPatients(int maxPatients) {
        this.maxPatients = maxPatients;
    }

    public int getMaxDoctors() {
        return maxDoctors;
    }

    public void setMaxDoctors(int maxDoctors) {
        this.maxDoctors = maxDoctors;
    }

    public Date getDateEndRegistry() {
        return dateEndRegistry;
    }

    public void setDateEndRegistry(Date dateEndRegistry) {
        this.dateEndRegistry = dateEndRegistry;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
