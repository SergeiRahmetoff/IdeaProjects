package project.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import project.AppGlobalState;
import project.model.entity.Weather;

import java.io.IOException;

public class AccuWeatherProvider implements IWeatherProvider {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String CONDITIONS_PATH = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String API_KEY = AppGlobalState.getInstance().getApiKey();

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    IWeatherRepository weatherRepository = new SQLiteWeatherRepository();

    @Override
    public Weather getCurrentWeather(String cityKey) throws IOException {

        HttpUrl getWeatherUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(CONDITIONS_PATH)
                .addPathSegment(API_VERSION)
                .addPathSegment(cityKey)
                .addQueryParameter("apikey", API_KEY)
                .build();

        Request getWeatherRequest = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(getWeatherUrl)
                .build();

        Response response = client.newCall(getWeatherRequest).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Ошибка сети\n");

        }
        String weather = response.body().string();

        Double temperature = objectMapper.readTree(weather).get(0).at("/Temperature/Metric/Value").asDouble();
        String[] date = objectMapper.readTree(weather).get(0).at("/LocalObservationDateTime").asText().split("T");
        String text = objectMapper.readTree(weather).get(0).at("/WeatherText").asText();

        Weather result = new Weather(AppGlobalState.getInstance().getCityTitle(), date[0], text, temperature);
        weatherRepository.saveWeatherObject(result);
        return result;
    }

    @Override
    public void get5DaysWeather(String cityKey) throws IOException {

        HttpUrl getWeatherUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment("forecasts")
                .addPathSegment(API_VERSION)
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityKey)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("metric", "true")
                .build();

        Request getWeatherRequest = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(getWeatherUrl)
                .build();

        Response response = client.newCall(getWeatherRequest).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Ошибка сети\n");
        }

        JsonNode dailyForecast = objectMapper.readTree(response.body().string()).path("DailyForecasts");

        for (JsonNode day : dailyForecast) {
            String responseDate = day.path("Date").asText();
            String[] date = responseDate.split("T");
            String text = day.path("Day").path("IconPhrase").asText();
            Double temperature = day.path("Temperature").path("Minimum").path("Value").asDouble();

            Weather result = new Weather(AppGlobalState.getInstance().getCityTitle(), date[0], text, temperature);
            weatherRepository.saveWeatherObject(result);
        }
    }
}
