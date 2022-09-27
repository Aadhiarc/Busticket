import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static ArrayList<Bus> bookingDetails = new ArrayList<Bus>();
    static ArrayList<Bookingdates> bookingdates = new ArrayList<Bookingdates>();

    public static void main(String[] args) throws IOException, ParseException {
        ArrayList<Booking> bookings = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Main m = new Main();
        m.jsonDetails();
        Scanner s = new Scanner(System.in);
        System.out.println("welcome to book buses !!!!!!");
        m.validation();
        int userOpt = 1;
        while (userOpt == 1) {
            System.out.println("enter 1. to bookTicket and 2.exit ");
            userOpt = sc.nextInt();
            if (userOpt == 1) {
                System.out.println("The available buses are");
                System.out.println("1.hosur to chennai\n2.chennai to coimbatore\n3.coimbatore to erode");
                System.out.println("Select the options to check the available dates");
                int opt = s.nextInt();
                switch (opt) {
                    case 1:
                        for (int k = 1; k <= bookingdates.size() / 3; k++) {
                            System.out.println("available dates" + ">>>>>>>" + " " + k + "." + bookingdates.get(k).date);
                        }
                        System.out.println("Select the date of depature date");
                        int dDate = s.nextInt();
                        switch (dDate) {
                            case 1:
                                System.out.println("The available seats are" + " " +">>>>>>"+ bookingdates.get(0).available_seats);
                                System.out.println("The bus type is"+" "+">>>>>>"+bookingdates.get(0).bus_type);
                                System.out.println("Bus Departure time is"+" "+">>>>>>"+bookingdates.get(0).starting_time);
                                System.out.println("Bus Reaching the destination at"+" "+">>>>>>"+bookingdates.get(0).reaching_time);
                                System.out.println("Ticket price"+" "+">>>>>>"+bookingdates.get(0).price+" "+"inr");
                                System.out.println("How many tickets do you want to book");
                                Scanner t = new Scanner(System.in);
                                

                        }
                }
            }
        }

    }

    void jsonDetails() throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader("C:\\Users\\SwiftAnt\\IdeaProjects\\Busticket\\src\\Busdetails.json"));
        JSONArray ar = (JSONArray) obj;
        String date = null;
        JSONArray bookingDate = null;
        String from = null;
        String to = null;
        String status;
        String availableseats;
        String bustype;
        String startingtime;
        String reachingtime;
        String price;

        for (Object details : ar) {
            from = (String) (((JSONObject) details).get("from"));
            to = (String) (((JSONObject) details).get("to"));
            bookingDate = ((JSONArray) ((JSONObject) details).get("bookingDate"));
            bookingDetails.add(new Bus(from, to, bookingDate));
            for (Object detailsarray : bookingDate) {
                date = (String) ((JSONObject) detailsarray).get("date");
                status = (String) ((JSONObject) detailsarray).get("status");
                availableseats = (String) ((JSONObject) detailsarray).get("available_seats");
                bustype = (String) ((JSONObject) detailsarray).get("bus_type");
                startingtime = (String) ((JSONObject) detailsarray).get("starting_time");
                reachingtime = (String) ((JSONObject) detailsarray).get("reaching_time");
                price = (String) ((JSONObject) detailsarray).get("price");
                bookingdates.add(new Bookingdates(date, status, bookingDate, availableseats, bustype, startingtime, reachingtime, price));
            }
        }

    }

    void validation() {
        Scanner s = new Scanner(System.in);
        //Username Validation
        System.out.println("Enter your username");
        String username = s.nextLine();
        Pattern pattern1 = Pattern.compile("  ^((?=.[a-z])(?=.[A-Z])^[a-z][\\w]{8,30})$");
        Matcher matcher1 = pattern1.matcher(username);
        boolean boo1 = matcher1.matches();

        //email Validation
        String email;
        boolean boo;
        do {
            System.out.println("Enter your email id");
            email = s.nextLine();
            Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
            Matcher matcher = pattern.matcher(email);
            boo = matcher.matches();
            if(boo==true){

            }else
            {
                System.out.println("The email id format is wrong");
                System.out.println("Try again");
                email = s.nextLine();
            }
        }while(boo==false);
        //Password Validation
        boolean boo2;
        String pass;
        do {
            System.out.println("Enter your password");
             pass = s.nextLine();
            Pattern pattern2 = Pattern.compile("^([a-zA-Z0-9\\@*#\\$&]{8,15})$");
            Matcher matcher2 = pattern2.matcher(pass);
            boo2 = matcher2.matches();
            if(boo2==true){
                System.out.println("email Verification was successful");
            }
            else{
                System.out.println("THE GIVEN email id or password is  invalid");
                System.out.println("try again");
                pass =s.nextLine();
            }
        }while(boo2==false);
        //phone number validation
        boolean boo3;
        String phone;
        do {
            System.out.println("Enter your phonenumber");
            phone = s.nextLine();
            Pattern pattern3 = Pattern.compile("^([^0][0-9]*)$");
            Matcher matcher3 = pattern3.matcher(phone);
             boo3 = matcher3.matches();
            if (boo3 == true) {
                System.out.println("login successful !!!");
            } else {
                System.out.println("THE given phoneNumber is  invalid");
                System.out.println("try again");

            }
        }while(boo3==false);
    }

    }





