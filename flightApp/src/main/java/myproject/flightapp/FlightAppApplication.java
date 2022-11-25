package myproject.flightapp;

import myproject.flightapp.service.retrofit.SearchRetrofit;
import myproject.flightapp.service.retrofit.WhatsUpRetrofit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class FlightAppApplication {

	private static final SearchRetrofit searchRetrofit = new SearchRetrofit();
	public static WhatsUpRetrofit whatsUpRetrofit = new WhatsUpRetrofit();
	public static final String apikey = "#";
	public static final Integer max_stopovers = 0;    // direct flight only = 0
	public static final String sort = "price";
	public static final Integer asc = 1;
	public static final Integer limit = 5;
	public static final String phoneNumber = "#";
	public static final String fly_from = "VIE";
	public static final String fly_to = "AUH";
	public static final String date_from = "#";
	public static final String date_to = "#";

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(FlightAppApplication.class, args);

		/*do{
			SearchRequestDto requestDto = new SearchRequestDto(apikey,fly_from,fly_to,date_from,date_to,max_stopovers,sort,asc,limit);
			SearchResponseDto responseDto = searchRetrofit.searchFlight(requestDto);
			List<Data> data = responseDto.getData();
			Integer flightPrice = data.get(0).getPrice();
			String message = "";
			if(flightPrice > 470){
				message = "Quite expensive";
			} else {
				message = "price: " + String.valueOf(data.get(0).getPrice()) +
						", departure: " + String.valueOf(data.get(0).getDeparture());
			}
			//WhatsUpRequestDto whatsUpRequestDto = new WhatsUpRequestDto(String.valueOf(responseDto),phoneNumber);
			WhatsUpRequestDto whatsUpRequestDto = new WhatsUpRequestDto(message,phoneNumber);
			whatsUpRetrofit.sendMsg(whatsUpRequestDto);
			//return  responseDto;
			Thread.sleep(120000);
		}
		while (true);*/

	}

}
