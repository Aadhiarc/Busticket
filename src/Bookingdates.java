import org.json.simple.JSONArray;

public class Bookingdates {

    String date;
    String status;
    String available_seats;
    JSONArray bookingDate;
    String bus_type;
    String starting_time;
    Bookingdates(String date, String status, JSONArray bookingDate, String availableseats, String bustype, String startingtime, String reachingtime, String price){
        this.date=date;
        this.status=status;
        this.bookingDate = bookingDate;
        this.available_seats=availableseats;
        this.bus_type=bustype;
        this.starting_time=startingtime;
        this.reaching_time=reachingtime;
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
