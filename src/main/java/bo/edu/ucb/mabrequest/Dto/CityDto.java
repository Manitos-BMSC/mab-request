package bo.edu.ucb.mabrequest.Dto;

public class CityDto {

    private int id;
    private String name;

    public CityDto() {
    }

    public CityDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
