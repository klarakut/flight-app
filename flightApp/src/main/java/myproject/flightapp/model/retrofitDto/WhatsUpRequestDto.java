package myproject.flightapp.model.retrofitDto;

public class WhatsUpRequestDto {

    private String message;
    private String phoneNumber;


    public WhatsUpRequestDto(String message, String phoneNumber) {
        this.message = message;
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
