package myproject.flightapp.model.retrofitDto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponseDto {


    @SerializedName("search_id")
    public String search_id;
    @SerializedName("currency")
    public String currency;
    List<Data> data;

    public SearchResponseDto(String search_id, String currency,List<Data> data) {
        this.search_id = search_id;
        this.currency = currency;
        this.data = data;
    }

    public String getSearch_id() {
        return search_id;
    }

    public String getCurrency() {
        return currency;
    }

    // public Data getData() {return data;}

    public List<Data> getData() {
        return data;
    }
}
