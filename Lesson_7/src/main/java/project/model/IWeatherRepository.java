package project.model;

import project.model.entity.Weather;

import java.util.List;

public interface IWeatherRepository {

    List<Weather> getAllData();

    List<Weather> get5Days();

    void saveWeatherObject(Weather weather);
}
