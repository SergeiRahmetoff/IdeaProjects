package project.model.entity;

public class Weather {

    private String city;
    private String localDate;
    private String weatherText;
    private Double temperature;

    public Weather() {
    }

    public Weather(String city, String localDate, String weatherText, Double temperature) {
        this.city = city;
        this.localDate = localDate;
        this.weatherText = weatherText;
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public String getLocalDate() {
        return localDate;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public Double getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", localDate='" + localDate + '\'' +
                ", weatherText='" + weatherText + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
