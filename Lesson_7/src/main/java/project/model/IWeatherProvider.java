package project.model;

import project.model.entity.Weather;

import java.io.IOException;

public interface IWeatherProvider {

    Weather getCurrentWeather(String cityKey) throws IOException;

    void get5DaysWeather(String cityKey) throws IOException;

}
