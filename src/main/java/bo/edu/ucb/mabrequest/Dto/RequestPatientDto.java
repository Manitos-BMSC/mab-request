package bo.edu.ucb.mabrequest.Dto;

import java.util.Date;

public class RequestPatientDto {

    private Integer patientId;
    private Long requestId;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private Date birthDate;
    private Boolean isMale;
    private String address;
    private String documentNumber;
    private Boolean isPassport;
    private String city;
    private String emergencyPhone;

    private String image;
    private String documentation;
    private String video;
    private String informedConsent;
    private Date requestDate;

    public RequestPatientDto() {
    }

    public RequestPatientDto(Integer patientId, Long requestId, String name, String lastName, String email, String phone, Date birthDate, Boolean isMale, String address, String documentNumber, Boolean isPassport, String city, String emergencyPhone, String image, String documentation, String video, String informedConsent, Date requestDate) {
        this.patientId = patientId;
        this.requestId = requestId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.isMale = isMale;
        this.address = address;
        this.documentNumber = documentNumber;
        this.isPassport = isPassport;
        this.city = city;
        this.emergencyPhone = emergencyPhone;
        this.image = image;
        this.documentation = documentation;
        this.video = video;
        this.informedConsent = informedConsent;
        this.requestDate = requestDate;
    }


    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getInformedConsent() {
        return informedConsent;
    }

    public void setInformedConsent(String informedConsent) {
        this.informedConsent = informedConsent;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }
}
