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
     static JSONArray ar;
    static ArrayList<Bus> bookingDetails = new ArrayList<Bus>();
    static ArrayList<Bookingdates> bookingDates = new ArrayList<Bookingdates>();

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
                int location = s.nextInt()-1;
                  for(int x=0;x<bookingDetails.size();x++) {
                      System.out.println(((((JSONObject) ar.get(x)).get("from"))));
                      System.out.println(((((JSONObject) ar.get(x)).get("to"))));
                      System.out.println("The available dates of the bus");
                      for (int k = 1; k <= bookingDates.size() / 3; k++) {
                              System.out.println("available dates" + ">>>>>>>" + " " + k + "." + ((JSONObject) ((JSONArray) ((JSONObject) ar.get(x)).get("bookingDate")).get(k-1)).get("date"));
                      }
                      System.out.println("Select the date of the departure");
                      int dDate = s.nextInt()-1;
                      System.out.println("The available bus on that date is one");
                      System.out.println("The available seats are" + " " + ">>>>>>" + ((JSONObject)((JSONArray)((JSONObject)ar.get(dDate)).get("bookingDate")).get(dDate)).get("available_seats"));
                      System.out.println("The bus type is" + " " + ">>>>>>" + ((JSONObject)((JSONArray)((JSONObject)ar.get(dDate)).get("bookingDate")).get(dDate)).get("bus_type"));
                      System.out.println("Bus Departure time is" + " " + ">>>>>>" +((JSONObject)((JSONArray)((JSONObject)ar.get(dDate)).get("bookingDate")).get(dDate)).get("starting_time"));
                      System.out.println("Bus Reaching the destination at" + " " + ">>>>>>" + ((JSONObject)((JSONArray)((JSONObject)ar.get(dDate)).get("bookingDate")).get(dDate)).get("reaching_time"));
                      System.out.println("Ticket price" + " " + ">>>>>>" + ((JSONObject)((JSONArray)((JSONObject)ar.get(dDate)).get("bookingDate")).get(dDate)).get("price"));
                      System.out.println("How many tickets do you want to book");
                      Scanner t = new Scanner(System.in);
                      int seat;
                      boolean b = false;
                      do {
                          seat = t.nextInt();
                          if (seat <= Integer.parseInt((String) ((JSONObject) ((JSONArray) ((JSONObject) ar.get(dDate)).get("bookingDate")).get(dDate)).get("available_seats"))) {
                              System.out.println("your ticket have been booked  successfully !!!");
                          } else {
                              System.out.println("we have only " + " " + ((JSONObject)((JSONArray)((JSONObject)ar.get(dDate)).get("bookingDate")).get(dDate)).get("available_seats") + " " + "available seats");
                          }
                      } while (seat > Integer.parseInt((String) ((JSONObject) ((JSONArray) ((JSONObject) ar.get(dDate)).get("bookingDate")).get(dDate)).get("available_seats")));
                      System.out.println("from"+" "+((((JSONObject) ar.get(x)).get("from")))+"----->"+" "+"to"+" "+((((JSONObject) ar.get(x)).get("to"))));
                      System.out.println("The bus type is" + " " + ">>>>>>" + ((JSONObject)((JSONArray)((JSONObject)ar.get(dDate)).get("bookingDate")).get(dDate)).get("bus_type"));
                      System.out.println("Bus Departure time is" + " " + ">>>>>>" +((JSONObject)((JSONArray)((JSONObject)ar.get(dDate)).get("bookingDate")).get(dDate)).get("starting_time"));
                      System.out.println("Bus Reaching the destination at" + " " + ">>>>>>" + ((JSONObject)((JSONArray)((JSONObject)ar.get(dDate)).get("bookingDate")).get(dDate)).get("reaching_time"));
                      System.out.println("Total Ticket price" + " " + ">>>>>>" +((JSONObject)((JSONArray)((JSONObject)ar.get(dDate)).get("bookingDate")).get(dDate)).get("price"));
                      System.out.println("Do you want book ticket for the next day");
                      System.out.println("Thank you for using our application to book ticket");
                      System.exit(0);

                  }


                }
            }
        }

    void jsonDetails() throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader("C:\\Users\\SwiftAnt\\IdeaProjects\\busTicket\\src\\busDetails.json"));
        ar = (JSONArray) obj;
        String date = null;
        JSONArray bookingDate = null;
        String from = null;
        String to = null;
        String status;
        String availableSeats;
        String busType;
        String startingTime;
        String reachingTime;
        String price;

        for (Object details : ar) {
            from = (String) (((JSONObject) details).get("from"));
            to = (String) (((JSONObject) details).get("to"));
            bookingDate = ((JSONArray) ((JSONObject) details).get("bookingDate"));
            bookingDetails.add(new Bus(from, to, bookingDate));
            for (Object arrayDetails : bookingDate) {
                date = (String) ((JSONObject) arrayDetails).get("date");
                status = (String) ((JSONObject) arrayDetails).get("status");
                availableSeats = (String) ((JSONObject) arrayDetails).get("available_seats");
                busType = (String) ((JSONObject) arrayDetails).get("bus_type");
                startingTime = (String) ((JSONObject) arrayDetails).get("starting_time");
                reachingTime = (String) ((JSONObject) arrayDetails).get("reaching_time");
                price = (String) ((JSONObject) arrayDetails).get("price");
                bookingDates.add(new Bookingdates(date, status, bookingDate, availableSeats, busType, startingTime, reachingTime, price));
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
            System.out.println("Enter your phone Number");
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





