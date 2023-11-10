package bo.edu.ucb.mabrequest.Bl;

import bo.edu.ucb.mabrequest.dao.City;
import bo.edu.ucb.mabrequest.dao.Country;
import bo.edu.ucb.mabrequest.dao.repository.CityRepository;
import bo.edu.ucb.mabrequest.dao.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bo.edu.ucb.mabrequest.Dto.CountryCityDto;
import bo.edu.ucb.mabrequest.Dto.CountryDto;
import bo.edu.ucb.mabrequest.Dto.CityDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryCitiesBl {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CityRepository cityRepository;

    private final Logger logger = LoggerFactory.getLogger(CountryCitiesBl.class);

    public List<CountryCityDto> getAllCountriesCities(){
        logger.info("Starting repository call to get all countries");
        List<Country> countries = countryRepository.findAll();
        if(countries == null){
            logger.info("getAllCountriesCities: countries is null");
            return null;
        }

        List<CountryCityDto> countryCitieslist = new ArrayList<>();

        for (Country country: countries) {
            CountryCityDto countryCities = new CountryCityDto();
            CountryDto countryDto = new CountryDto();
            countryDto.setId(country.getId());
            countryDto.setName(country.getName());
            countryCities.setCountry(countryDto);
            List<City> cities = cityRepository.findAllByCountryId((long) country.getId());
            if(cities == null){
                logger.info("getAllCountriesCities: cities is null");
                return null;
            }
            for (City city: cities) {
                CityDto cityDto = new CityDto();
                cityDto.setId(city.getId());
                cityDto.setName(city.getName());
                countryCities.addCity(cityDto);
            }
            countryCitieslist.add(countryCities);
        }
        return countryCitieslist;
    }

}
