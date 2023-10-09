package bo.edu.ucb.mabrequest.Dto;

public class PersonDto {

    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String birthDate;
    private Boolean isMale;
    private String address;

    private String documentNumber;
    private Boolean isPassport;
    private int cityId;

    public PersonDto() {
    }

    public PersonDto(String name, String lastName, String email, String phone, String birthDate, Boolean isMale, String address, int cityId, Boolean isPassport, String documentNumber) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.isMale = isMale;
        this.address = address;
        this.cityId = cityId;
        this.isPassport = isPassport;
        this.documentNumber = documentNumber;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
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

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public Boolean getPassport() {
        return isPassport;
    }

    public void setPassport(Boolean passport) {
        isPassport = passport;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

}
