package bo.edu.ucb.mabrequest.Dto;

public class PatientDto extends PersonDto{
    private String emergencyPhone;
    private int countryId;

    public PatientDto() {
    }

    public PatientDto(String name, String lastName, String email, String phone, String birthDate, Boolean isMan, String address, int cityId, Boolean isPassport, String documentNumber, String emergencyPhone, int countryId) {
        super(name, lastName, email, phone, birthDate, isMan, address, cityId, isPassport, documentNumber);
        this.emergencyPhone = emergencyPhone;
        this.countryId = countryId;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "PatientDto{" +
                "emergencyPhone='" + emergencyPhone + '\'' +
                ", countryId=" + countryId +
                '}';
    }
}
