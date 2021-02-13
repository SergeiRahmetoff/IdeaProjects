package project;

public class AppGlobalState {

    private static AppGlobalState instanse;

    private String cityKey;

    public String getCityKey() {
        return cityKey;
    }

    public void setCityKey(String cityKey) {
        this.cityKey = cityKey;
    }

    public String getApiKey() {
        return "elUN9sJesNSKHDNdT3w5GaPjRYLRlQF6";
    }

    private AppGlobalState(){}

    public static AppGlobalState getInstance() {
        if (instanse == null) {
            instanse = new AppGlobalState();
        }
        return instanse;
    }

    private String cityTitle;
    public String getCityTitle() {
        return cityTitle;
    }
    public void setCityTitle(String cityTitle) { this.cityTitle = cityTitle;  }

    private String weather;
    public String getWeather() { return weather; }
    public void setWeather(String weather) {this.weather = weather;    }
}
