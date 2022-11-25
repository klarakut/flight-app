package myproject.flightapp.service.retrofit;

import myproject.flightapp.model.retrofitDto.SearchRequestDto;
import myproject.flightapp.model.retrofitDto.SearchResponseDto;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Service
public class SearchRetrofit {

    public static final String apiKey = "#";
    public static final String nameOfApiUrl = "#";

    public SearchResponseDto searchFlight (SearchRequestDto requestDto) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(nameOfApiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SearchRetroInterface searchRetroInterface = retrofit.create(SearchRetroInterface.class);
        // TO DO
        Call<SearchResponseDto> call = searchRetroInterface.getMyFlight(
                requestDto.getApikey(),requestDto.getFly_from(),
                requestDto.fly_to,requestDto.date_from,
                requestDto.date_to,
                requestDto.max_stopovers,
                requestDto.sort,
                requestDto.asc,
                requestDto.limit);
        SearchResponseDto responseDto = (SearchResponseDto) call.execute().body();
        return responseDto;
    }

    public SearchResponseDto searchCheapFlight (SearchRequestDto requestDto) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(nameOfApiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SearchRetroInterface searchRetroInterface = retrofit.create(SearchRetroInterface.class);
        // TO DO
        Call<SearchResponseDto> call = searchRetroInterface.getCheapFlight(
                requestDto.getApikey(),requestDto.getFly_from(),
                requestDto.date_from,
                requestDto.date_to,
                requestDto.max_stopovers,
                requestDto.sort,
                requestDto.asc,
                requestDto.limit);
        SearchResponseDto responseDto = (SearchResponseDto) call.execute().body();
        return responseDto;
    }
}
