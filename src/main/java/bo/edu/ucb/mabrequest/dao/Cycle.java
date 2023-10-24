package bo.edu.ucb.mabrequest.dao;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MAB_cycle")
public class Cycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cycle_id")
    private Long cycleId;

    @Column(name = "cycle_year", nullable = false)
    private int cycleYear;

    @Column(name = "max_pacients", nullable = false)
    private int maxPatients;

    @Column(name = "max_doctors", nullable = false)
    private int maxDoctors;

    @Column(name = "date_end_registry", nullable = false)
    private Date dateEndRegistry;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "status", nullable = false)
    private int status;

    public Cycle() {
    }
    public Cycle(Long cycleId, int cycleYear, int maxPatients, int maxDoctors, Date dateEndRegistry, String state, int status) {
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
