package bo.edu.ucb.mabrequest.Dto;

public class CountryDto {

    private int id;
    private String name;

    public CountryDto() {
    }

    public CountryDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public CountryDto setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CountryDto setName(String name) {
        this.name = name;
        return this;
    }

}
