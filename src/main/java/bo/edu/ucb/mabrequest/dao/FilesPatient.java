package bo.edu.ucb.mabrequest.dao;

import bo.edu.ucb.mabrequest.dao.repository.S3ObjectRepository;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Entity
@Table(name = "Files_pacient")
public class FilesPatient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_date")
    private Date fileDate;

    @Column(name = "status")
    private Boolean status;

    @OneToOne
    @JoinColumn(name = "s3_object_id", referencedColumnName = "s3_object_id")
    private S3Object s3Object;

    @ManyToOne // Many FilesPacient can belong to one Pacient
    @JoinColumn(name = "pacient_id") // Assuming the name of the foreign key column
    private Patient pacient;

    public FilesPatient(Long id, Date fileDate, Boolean status, S3Object s3Object, Patient pacient) {
        this.id = id;
        this.fileDate = fileDate;
        this.status = status;
        this.s3Object = s3Object;
        this.pacient = pacient;
    }

    public FilesPatient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFileDate() {
        return fileDate;
    }

    public void setFileDate(Date fileDate) {
        this.fileDate = fileDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public S3Object getS3Object() {
        return s3Object;
    }

    public void setS3Object(S3Object s3Object) {
        this.s3Object = s3Object;
    }

    public Patient getPacient() {
        return pacient;
    }

    public void setPacient(Patient pacient) {
        this.pacient = pacient;
    }
}
