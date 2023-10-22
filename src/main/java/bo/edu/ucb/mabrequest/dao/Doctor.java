package bo.edu.ucb.mabrequest.dao;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "MAB_doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "MAB_person_id_keycloack")
    private Person person;

    @Column(name = "s3_object_id")
    private Long s3ObjectId;

    @Column(name = "license_code")
    private String licenseCode;

    @Column(name = "license_due_date")
    private Date licenseDueDate;

    @Column(name = "license_status")
    private String licenseStatus;

    @Column(name = "medical_speciality")
    private String medicalSpeciality;

    @Column(name = "status")
    private boolean status;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<HospitalDoctor> hospitalDoctors;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UnavailableSchedule> unavailableSchedules;



    public Doctor() {
    }

    public Doctor(int id, Person person, Long s3ObjectId, String licenseCode, Date licenseDueDate, String licenseStatus, String medicalSpeciality, boolean status, List<HospitalDoctor> hospitalDoctors, List<UnavailableSchedule> unavailableSchedules) {
        this.id = id;
        this.person = person;
        this.s3ObjectId = s3ObjectId;
        this.licenseCode = licenseCode;
        this.licenseDueDate = licenseDueDate;
        this.licenseStatus = licenseStatus;
        this.medicalSpeciality = medicalSpeciality;
        this.status = status;
        this.hospitalDoctors = hospitalDoctors;
        this.unavailableSchedules = unavailableSchedules;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getS3ObjectId() {
        return s3ObjectId;
    }

    public void setS3ObjectId(Long s3ObjectId) {
        this.s3ObjectId = s3ObjectId;
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
    }

    public Date getLicenseDueDate() {
        return licenseDueDate;
    }

    public void setLicenseDueDate(Date licenseDueDate) {
        this.licenseDueDate = licenseDueDate;
    }

    public String getLicenseStatus() {
        return licenseStatus;
    }

    public void setLicenseStatus(String licenseStatus) {
        this.licenseStatus = licenseStatus;
    }

    public String getMedicalSpeciality() {
        return medicalSpeciality;
    }

    public void setMedicalSpeciality(String medicalSpeciality) {
        this.medicalSpeciality = medicalSpeciality;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<HospitalDoctor> getHospitalDoctors() {
        return hospitalDoctors;
    }

    public void setHospitalDoctors(List<HospitalDoctor> hospitalDoctors) {
        this.hospitalDoctors = hospitalDoctors;
    }

    public List<UnavailableSchedule> getUnavailableSchedules() {
        return unavailableSchedules;
    }

    public void setUnavailableSchedules(List<UnavailableSchedule> unavailableSchedules) {
        this.unavailableSchedules = unavailableSchedules;
    }
}
