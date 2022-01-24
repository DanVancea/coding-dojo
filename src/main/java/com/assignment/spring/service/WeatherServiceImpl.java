package com.assignment.spring.service;

import com.assignment.spring.entity.WeatherEntity;
import com.assignment.spring.entity.WeatherRepository;
import com.assignment.spring.model.WeatherResponse;
import com.assignment.spring.model.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeatherRepository weatherRepository;

    @Override
    public WeatherService addWeather(HttpServletRequest request) {
        String city = request.getParameter("city");
        String url = Constants.WEATHER_API_URL.replace("{city}", city).replace("{appid}", Constants.APP_ID);
        ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(url, WeatherResponse.class);
        return (WeatherService)mapper(response.getBody());
    }


    /**
     * maps the weather response
     *
     * @param weatherResponse
     *
     * @return weatherEntity
     */
    private WeatherEntity mapper(WeatherResponse weatherResponse) {
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setCity(weatherResponse.getName());
        weatherEntity.setCountry(weatherResponse.getSys().getCountry());
        weatherEntity.setTemperature(weatherResponse.getWeatherMeasurements().getTemp());
        return weatherRepository.save(weatherEntity);
    }

}
