package myproject.flightapp.service.retrofit;

import myproject.flightapp.model.retrofitDto.WhatsUpRequestDto;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

@Service
public class WhatsUpRetrofit {

    public final String apiKey = "#";
    public final String whats_Url = "https://api.callmebot.com";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(whats_Url)
            .build();

    public void sendMsg(WhatsUpRequestDto whatsUpRequestDto) throws IOException {
        WhatsUpInterface whatsUpInterface = retrofit.create(WhatsUpInterface.class);
        Call<Void> call = whatsUpInterface.getMsg(whatsUpRequestDto.getPhoneNumber(), whatsUpRequestDto.getMessage(),apiKey);
        call.execute().body();
    }
}
