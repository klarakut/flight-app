package myproject.flightapp.model.retrofitDto;

public class SearchRequestDto {
    public String apikey;

    public String fly_from;
    public String fly_to;
    public String date_from;
    public String date_to;
    public Integer max_stopovers;

    public String sort;
    public Integer asc;
    public Integer limit;

    public SearchRequestDto(String apikey, String fly_from,
                            String fly_to, String date_from,
                            String date_to, Integer max_stopovers,
                            String sort, Integer asc, Integer limit) {
        this.apikey = apikey;
        this.fly_from = fly_from;
        this.fly_to = fly_to;
        this.date_from = date_from;
        this.date_to = date_to;
        this.max_stopovers = max_stopovers;
        this.sort = sort;
        this.asc = asc;
        this.limit = limit;
    }

    public SearchRequestDto(String apikey, String fly_from, String date_from,
                            String date_to, Integer max_stopovers,
                            String sort, Integer asc, Integer limit) {
        this.apikey = apikey;
        this.fly_from = fly_from;
        this.date_from = date_from;
        this.date_to = date_to;
        this.max_stopovers = max_stopovers;
        this.sort = sort;
        this.asc = asc;
        this.limit = limit;
    }

    public String getApikey() {
        return apikey;
    }

    public String getFly_from() {
        return fly_from;
    }

    public String getFly_to() {
        return fly_to;
    }

    public String getDate_from() {
        return date_from;
    }

    public String getDate_to() {
        return date_to;
    }
}
