package bo.edu.ucb.mabrequest.Dto;

import java.util.ArrayList;
import java.util.List;

public class CountryCityDto {

    private CountryDto country;
    private List<CityDto> cities;

    public CountryCityDto() {
        this.cities = new ArrayList<>();
    }

    public CountryCityDto(CountryDto country, List<CityDto> cities) {
        this.country = country;
        this.cities = cities;
    }

    public CountryDto getCountry() {
        return country;
    }

    public void setCountry(CountryDto country) {
        this.country = country;
    }

    public List<CityDto> getCities() {
        return cities;
    }

    public void setCities(List<CityDto> cities) {
        this.cities = cities;
    }

    public void addCity(CityDto city){
        this.cities.add(city);
    }
}
