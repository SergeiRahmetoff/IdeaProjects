package project.model;

import java.io.IOException;

public interface IWeatherProvider {

    void getCurrentWeather(String cityKey) throws IOException;

    void get5DaysWeather(String cityKey) throws IOException;

}
