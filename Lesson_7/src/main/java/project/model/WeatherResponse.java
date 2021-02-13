package project.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.ResponseBody;
import project.AppGlobalState;

import java.io.IOException;

public class WeatherResponse {

    ObjectMapper objectMapper = new ObjectMapper();

    public void showCurrentWeather(String weather) throws IOException {

        String[] weatherResponseDate = objectMapper.readTree(weather).get(0).at("/LocalObservationDateTime").asText().split("T");
        String weatherResponseText = objectMapper.readTree(weather).get(0).at("/WeatherText").asText();
        String weatherResponseTemperature = objectMapper.readTree(weather).get(0).at("/Temperature/Metric/Value").asText();


        System.out.printf("В городе %s на дату %s ожидается %s, температура - %sС.\n", AppGlobalState.getInstance().getCityTitle(), weatherResponseDate[0], weatherResponseText, weatherResponseTemperature);
    }

    public void show5DaysWeather(String weather) throws IOException {

        System.out.printf("В городе " + AppGlobalState.getInstance().getCityTitle() + "\n");

        JsonNode dailyForecast = objectMapper.readTree(weather).path("DailyForecasts");

        for (JsonNode day : dailyForecast) {
            String[] weatherResponseDate = day.path("Date").asText().split("T");
            String weatherResponseText = day.path("Day").path("IconPhrase").asText();
            String minWeatherResponseTemperature = day.path("Temperature").path("Minimum").path("Value").asText();
            String maxWeatherResponseTemperature = day.path("Temperature").path("Maximum").path("Value").asText();

            System.out.printf("на дату %s ожидается %s, температура %s - %sС\n", weatherResponseDate[0], weatherResponseText, minWeatherResponseTemperature, maxWeatherResponseTemperature);
        }

    }
}

