package com.bridgelabz;
import java.sql.SQLOutput;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HotelReservation {
    private static final List<Hotel> hotels = Arrays.asList(new Hotel("lakewood",3,110,80,90,80),
     new Hotel("bridgewood", 4, 110, 160, 60, 50),
     new Hotel("ridgewood", 5, 220, 100, 150, 60)
    );


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hotel Reservation");
//        Hotel hotelOne = new Hotel("lakewood", 3, 110, 80, 90, 80);
//
//        Hotel hotelTwo = new Hotel("bridgewood", 4, 110, 160, 60, 50);
//        Hotel hotelThree = new Hotel("ridgewood", 5, 220, 100, 150, 60);

        System.out.println("Enter the startdate  dd-MM-yyyy: ");
        LocalDate startDate = LocalDate.parse(sc.nextLine(),DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("Enter the enddate dd-MM-yyyy: ");
        LocalDate endDate = LocalDate.parse(sc.nextLine(),DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("Enter the customerTypes: ");
        String type= sc.next();
        type=type.toUpperCase();
        CustomerTypes customerTypes= CustomerTypes.valueOf(type);
        Hotel cheapestHotel = hotels.stream().min(Comparator.comparingInt(hotel -> hotel.getRate(startDate,endDate,customerTypes))).orElse(null);
        System.out.println(cheapestHotel);

    }
    }

