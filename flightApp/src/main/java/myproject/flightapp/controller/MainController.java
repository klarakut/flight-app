package myproject.flightapp.controller;

import myproject.flightapp.model.retrofitDto.Data;
import myproject.flightapp.model.retrofitDto.SearchRequestDto;
import myproject.flightapp.model.retrofitDto.SearchResponseDto;
import myproject.flightapp.model.retrofitDto.WhatsUpRequestDto;
import myproject.flightapp.service.retrofit.SearchRetrofit;
import myproject.flightapp.service.retrofit.WhatsUpRetrofit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    public static final String apikey = "#";
    //@SerializedName("max_stopover")
    public static final Integer max_stopovers = 0;    // direct flight only = 0
    public static final String sort = "price";
    public static final Integer asc = 1;
    public static final Integer limit = 30;
    public static final String phoneNumber = "#";
    private static final Integer priceUnder = 10;
    private final SearchRetrofit searchRetrofit;
    private final WhatsUpRetrofit whatsUpRetrofit;

    @Autowired
    public MainController(SearchRetrofit searchRetrofit, WhatsUpRetrofit whatsUpRetrofit) {
        this.searchRetrofit = searchRetrofit;
        this.whatsUpRetrofit = whatsUpRetrofit;
    }

    @GetMapping("/searchFlight")
    public SearchResponseDto showMeFlight(
            @RequestParam(value = "fly_from") String fly_from,
            @RequestParam(value = "fly_to") String fly_to,
            @RequestParam(value = "date_from") String date_from,
            @RequestParam(value = "date_to") String date_to) throws IOException {

        SearchRequestDto requestDto = new SearchRequestDto(apikey,fly_from,fly_to,date_from,date_to,max_stopovers,sort,asc,limit);
        SearchResponseDto responseDto = searchRetrofit.searchFlight(requestDto);
        List<Data> data = responseDto.getData();
        Integer flightPrice = data.get(0).getPrice();
        String message = "";
        if(flightPrice > 470){
            message = "Quite expensive";
        } else {
            message = "city: " +  data.get(0).getCityTo() +
                    ", price: " + String.valueOf(data.get(0).getPrice()) +
                    ", departure: " + String.valueOf(data.get(0).getDeparture());
        }
        WhatsUpRequestDto whatsUpRequestDto = new WhatsUpRequestDto(message,phoneNumber);
        whatsUpRetrofit.sendMsg(whatsUpRequestDto);
        return  responseDto;
    }

    @GetMapping("/searchCheapFlight")
    public SearchResponseDto showMeCheapFlight(
            @RequestParam(value = "fly_from") String fly_from,
            @RequestParam(value = "date_from") String date_from,
            @RequestParam(value = "date_to") String date_to) throws IOException {

        SearchRequestDto requestDto = new SearchRequestDto(apikey,fly_from,date_from,date_to,max_stopovers,sort,asc,limit);
        SearchResponseDto responseDto = searchRetrofit.searchFlight(requestDto);
        List<Data> data = responseDto.getData();
        Integer flightPrice = data.get(0).getPrice();
        String message = "";

        if(flightPrice > 470){
            message = "Quite expensive";
        } else {
            message = "city: " +  data.get(0).getCityTo() +
                    ", price: " + String.valueOf(data.get(0).getPrice()) +
                    ", departure: " + String.valueOf(data.get(0).getDeparture());
            WhatsUpRequestDto whatsUpRequestDto = new WhatsUpRequestDto(message,phoneNumber);
            whatsUpRetrofit.sendMsg(whatsUpRequestDto);
        }

        //WhatsUpRequestDto whatsUpRequestDto = new WhatsUpRequestDto(String.valueOf(responseDto),phoneNumber);
        // WhatsUpRequestDto whatsUpRequestDto = new WhatsUpRequestDto(message,phoneNumber);
        //whatsUpRetrofit.sendMsg(whatsUpRequestDto);

        if(data.size() > 1){
            message = "city: " +  data.get(1).getCityTo() +
                    ", price: " + String.valueOf(data.get(1).getPrice()) +
                    ", departure: " + String.valueOf(data.get(1).getDeparture());
            WhatsUpRequestDto whatsUpRequestDto = new WhatsUpRequestDto(message,phoneNumber);
            whatsUpRetrofit.sendMsg(whatsUpRequestDto);
        }
        return  responseDto;
    }

    @GetMapping("/searchCheapFlightUnder")
    public SearchResponseDto showMeCheapFlightUnder(
            @RequestParam(value = "fly_from") String fly_from,
            @RequestParam(value = "date_from") String date_from,
            @RequestParam(value = "date_to") String date_to) throws IOException {

        SearchRequestDto requestDto = new SearchRequestDto(apikey,fly_from,date_from,date_to,max_stopovers,sort,asc,limit);
        SearchResponseDto responseDto = searchRetrofit.searchFlight(requestDto);
        List<Data> responseData = responseDto.getData();
        List<Data> data = new ArrayList<>();
        for (Data d : responseData){
            if (d.getPrice() <= priceUnder){
                data.add(d);
            }
        }

        int size = data.size();
        String message = "";
        if(size > 1){
            int num = 0;
            while (size > num){
                message = "city: " +  data.get(num).getCityTo() +
                        ", price: " + String.valueOf(data.get(num).getPrice()) +
                        ", departure: " + String.valueOf(data.get(num).getDeparture());
                WhatsUpRequestDto whatsUpRequestDto = new WhatsUpRequestDto(message,phoneNumber);
                whatsUpRetrofit.sendMsg(whatsUpRequestDto);
                num++;
            }
        } else {
            message = "No flights under " + priceUnder + "EUR , the cheapest flight is: city: " +  responseData.get(0).getCityTo() +
                    ", price: " + responseData.get(0).getPrice() +
                    ", departure: " + responseData.get(0).getDeparture();
        }
        WhatsUpRequestDto whatsUpRequestDto = new WhatsUpRequestDto(message,phoneNumber);
        whatsUpRetrofit.sendMsg(whatsUpRequestDto);
        return  responseDto;
    }
}
