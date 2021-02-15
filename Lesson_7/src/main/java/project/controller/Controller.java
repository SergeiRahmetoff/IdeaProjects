package project.controller;

import project.AppGlobalState;
import project.model.*;
import project.model.entity.Weather;

import java.io.IOException;
import java.util.List;

public class Controller implements IController {

    ICityCodeProvider codeProvider = new AccuWeatherCityCodeProvider();
    IWeatherProvider weatherProvider = new AccuWeatherProvider();
    IWeatherRepository weatherRepository = new SQLiteWeatherRepository();

    @Override
    public void onCityInput(String city) throws IOException {
        if (city.length() == 1) {
            throw new IOException("Недопустимо короткое название города");
        }

        codeProvider.getCodeByCityName(city);
    }

    @Override
    public void onCommandChosen(int selectedCommand) throws IOException {
        try {
            switch (selectedCommand) {
                case 1: {
                    Weather currentWeather = weatherProvider.getCurrentWeather(AppGlobalState.getInstance().getCityKey());
                    System.out.printf("В городе %s на дату %s ожидается %s, температура - %sС.\n", currentWeather.getCity(),
                            currentWeather.getLocalDate(), currentWeather.getWeatherText(), currentWeather.getTemperature());
                    break;
                }
                case 2: {
                    weatherProvider.get5DaysWeather(AppGlobalState.getInstance().getCityKey());
                    List<Weather> allData = weatherRepository.getAllData();
                    for (int i = allData.size()-5; i < allData.size(); i++) {
                        System.out.printf("В городе %s на дату %s ожидается %s, температура - %sС.\n", allData.get(i).getCity(),
                                allData.get(i).getLocalDate(), allData.get(i).getWeatherText(), allData.get(i).getTemperature());

                    }
                    break;
                }
                default: {
                    System.out.println("Неверный ввод\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Неверный ввод\n");
            e.printStackTrace();
        }
    }
}
