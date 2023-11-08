package bo.edu.ucb.mabrequest.Dto;

public class CityDto {

    private int id;
    private int countryId;
    private String name;

    public CityDto() {
    }

    public CityDto(int id, int countryId, String name) {
        this.id = id;
        this.countryId = countryId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
