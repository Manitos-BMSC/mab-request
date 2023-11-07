package bo.edu.ucb.mabrequest.dao;

import jakarta.persistence.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Entity
@Table(name = "MAB_pacient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "emergency_phone", length = 30, nullable = false)
    private String emergencyPhone;

    @Column(name = "pacient_status", length = 30, nullable = false)
    private String pacientStatus;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @OneToOne
    @JoinColumn(name = "MAB_person_id_keycloack", referencedColumnName = "id_keycloack")
    private Person person;

    @OneToMany(mappedBy = "pacient") // One-to-many relationship with Files_pacient
    private List<FilesPatient> files;


    public Patient() {
    }

    public Patient(Integer id, String emergencyPhone, String pacientStatus, Boolean status, Person person, List<FilesPatient> files) {
        this.id = id;
        this.emergencyPhone = emergencyPhone;
        this.pacientStatus = pacientStatus;
        this.status = status;
        this.person = person;
        this.files = files;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public String getPacientStatus() {
        return pacientStatus;
    }

    public void setPacientStatus(String pacientStatus) {
        this.pacientStatus = pacientStatus;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<FilesPatient> getFiles() {
        return files;
    }

    public void setFiles(List<FilesPatient> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", emergencyPhone='" + emergencyPhone + '\'' +
                ", pacientStatus='" + pacientStatus + '\'' +
                ", status=" + status +
                ", person=" + person +
                ", files=" + files +
                '}';
    }
}