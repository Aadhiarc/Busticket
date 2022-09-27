import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

class Bus {
       String from;
       String to;
       JSONArray bookingDate;

       Bus(String from,String to, JSONArray bookingDate){
             this.from=from;
             this.to=to;
             this.bookingDate=bookingDate;

       }



    public String getFrom() {
         return from;
     }

     public String getTo() {
         return to;
     }

    public JSONArray getBookingDate() {
        return bookingDate;
    }
 }
