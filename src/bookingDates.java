import org.json.simple.JSONArray;

public class bookingDates {

    String date;
    String status;
    String available_seats;
    JSONArray bookingDate;
    String bus_type;
    String starting_time;
    bookingDates(String date, String status, JSONArray bookingDate, String availableSeats, String busType, String staringTime, String reachingTime, String price){
        this.date=date;
        this.status=status;
        this.bookingDate = bookingDate;
        this.available_seats=availableSeats;
        this.bus_type=busType;
        this.starting_time=staringTime;
        this.reaching_time=reachingTime;
        this.price=price;
    }
    public JSONArray getBookingDate() {
        return bookingDate;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getAvailable_seats() {
        return available_seats;
    }

    public String getBus_type() {
        return bus_type;
    }

    public String getStarting_time() {
        return starting_time;
    }

    public String getReaching_time() {
        return reaching_time;
    }

    public String getPrice() {
        return price;
    }

    String reaching_time;
    String price;

}
