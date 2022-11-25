package myproject.flightapp.service.retrofit;


import myproject.flightapp.model.retrofitDto.SearchResponseDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface SearchRetroInterface {

    /*@GET("/v2/search")
    Call<List<SearchResponseDto>> getMyFlight(@Header("apikey") String apikey,
                                              @Query("fly_from") String fly_from,
                                              @Query("fly_to") String fly_to,
                                              @Query("date_from") String date_from,
                                              @Query("date_to") String date_to);*/

   @GET("/v2/search")
   Call<SearchResponseDto> getMyFlight(@Header("apikey") String apikey,
                                       @Query("fly_from") String fly_from,
                                       @Query("fly_to") String fly_to,
                                       @Query("date_from") String date_from,
                                       @Query("date_to") String date_to,
                                       @Query("max_stopovers") Integer max_stopovers,
                                       @Query("sort") String sort,
                                       @Query("asc") Integer asc,
                                       @Query("limit") Integer limit);

    @GET("/v2/search")
        //@GET("/search")
    Call<SearchResponseDto> getCheapFlight(@Header("apikey") String apikey,
                                        @Query("fly_from") String fly_from,
                                        @Query("date_from") String date_from,
                                        @Query("date_to") String date_to,
                                        @Query("max_stopovers") Integer max_stopovers,
                                        @Query("sort") String sort,
                                        @Query("asc") Integer asc,
                                        @Query("limit") Integer limit);
}
