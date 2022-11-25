package myproject.flightapp.model.retrofitDto;


import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Data {

    public String flyFrom;
    public String cityFrom;
    public String flyTo;
    public String cityTo;
    List<String> airlines;
    public Integer price;
    Availability availability;
    @SerializedName("local_departure")
    public Date departure;
    @SerializedName("local_arrival")
    public Date arrival;

    public Data(String flyFrom, String cityFrom, String flyTo, String cityTo,
                List<String> airlines, Integer price, Availability availability,
                Date departure,Date arrival) {
        this.flyFrom = flyFrom;
        this.cityFrom = cityFrom;
        this.flyTo = flyTo;
        this.cityTo = cityTo;
        this.airlines = airlines;
        this.price = price;
        this.availability = availability;
        this.departure = departure;
        this.arrival = arrival;
    }

    public String getFlyFrom() {
        return flyFrom;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public String getFlyTo() {
        return flyTo;
    }

    public String getCityTo() {
        return cityTo;
    }

    public List<String> getAirlines() {
        return airlines;
    }

    public Integer getPrice() {
        return price;
    }

    public Availability getAvailability() {
        return availability;
    }

    public Date getDeparture() {
        return departure;
    }

    public Date getArrival() {
        return arrival;
    }
}
