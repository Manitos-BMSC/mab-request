package bo.edu.ucb.mabrequest.Dto;

import java.util.Date;

public class PatientDto {
    private Integer patientId;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private Date birthDate;
    private Boolean isMale;
    private String address;

    private String username;

    private String documentNumber;
    private Boolean isPassport;
    private Integer cityId;
    private String emergencyPhone;

    public PatientDto() {
    }

    public PatientDto(Integer patientId, String name, String lastName, String email, String phone, Date birthDate, Boolean isMale, String address, String username, String documentNumber, Boolean isPassport, Integer cityId, String emergencyPhone) {
        this.patientId = patientId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.isMale = isMale;
        this.address = address;
        this.username = username;
        this.documentNumber = documentNumber;
        this.isPassport = isPassport;
        this.cityId = cityId;
        this.emergencyPhone = emergencyPhone;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getMale() {
        return isMale;
    }

    public void setMale(Boolean male) {
        isMale = male;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Boolean getPassport() {
        return isPassport;
    }

    public void setPassport(Boolean passport) {
        isPassport = passport;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }
}
