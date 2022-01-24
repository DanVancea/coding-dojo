package com.assignment.spring;

import com.assignment.spring.model.WeatherResponse;
import com.assignment.spring.service.WeatherService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherServiceImplTest {

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private WeatherResponse weatherResponse;

    @Mock
    private WeatherService weatherService;

    @Before
    public void setUp(){
        when(weatherResponse.getName()).thenReturn("city");
        when(weatherResponse.getSys().getCountry()).thenReturn("Country");
        when(weatherResponse.getWeatherMeasurements().getTemp()).thenReturn(25.0);
    }

    @Test
    public void testAddWeather() throws Exception {

        weatherService.addWeather(httpServletRequest);
        assertNotNull(weatherResponse);

    }
}
