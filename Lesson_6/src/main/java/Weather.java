
import okhttp3.*;

import java.io.IOException;


public class Weather {

    public static void main(String[] args) throws IOException{

        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .build();

        Request request = new Request.Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=MLFZTGkEICrcv6mzRgJvoAyGEoE6w5vP")
                .build();

        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());

    }
}
