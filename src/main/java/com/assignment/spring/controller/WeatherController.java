package com.assignment.spring.controller;

import com.assignment.spring.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;



    @RequestMapping(value ="/weather",method = RequestMethod.GET)
    public WeatherService addWeather(HttpServletRequest request) {
      return weatherService.addWeather(request);
    }



}
