package com.bridgelabz;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Hotel {
    private String name;
    private int rating;
    private int ratesForWeekdaysForRegularCustomer;
    private int ratesForWeekdaysForRewardCustomer;
    private int ratesForWeekendForRegularCustomer;
    private int ratesForWeekendForRewardCustomer;

    public int getRate(LocalDate startDate, LocalDate endDate, CustomerTypes customerTypes) {
        int weekDays = getWeekdayInRange(startDate, endDate);
        int weekends = getWeekendDaysInRange(startDate, endDate);

        if (customerTypes.equals("REGULAR")) {
            int regularRate = weekDays * ratesForWeekdaysForRegularCustomer * weekends * ratesForWeekendForRegularCustomer;
            return regularRate;
        } else {
            int rewardRate = weekDays * ratesForWeekdaysForRewardCustomer * weekends * ratesForWeekendForRewardCustomer;
            return rewardRate;

        }
    }
    private int getWeekendDaysInRange(LocalDate startDate, LocalDate endDate) {
        return (int) startDate.datesUntil(endDate.plusDays(1)).filter(date->date.getDayOfWeek().equals(DayOfWeek.SATURDAY) ||date.getDayOfWeek().equals(DayOfWeek.SATURDAY)).count();
    }

    private int getWeekdayInRange(LocalDate startDate, LocalDate endDate) {
        return (int) startDate.datesUntil(endDate.plusDays(1)).filter(date->!date.getDayOfWeek().equals(DayOfWeek.SATURDAY) && !date.getDayOfWeek().equals(DayOfWeek.SATURDAY)).count();
    }


    public Hotel(String name, int rating, int ratesForWeekdaysForRegularCustomer, int ratesForWeekdaysForRewardCustomer, int ratesForWeekendForRegularCustomer, int ratesForWeekendForRewardCustomer) {
        this.name = name;
        this.rating = rating;
        this.ratesForWeekdaysForRegularCustomer = ratesForWeekdaysForRegularCustomer;
        this.ratesForWeekdaysForRewardCustomer = ratesForWeekdaysForRewardCustomer;
        this.ratesForWeekendForRegularCustomer = ratesForWeekendForRegularCustomer;
        this.ratesForWeekendForRewardCustomer = ratesForWeekendForRewardCustomer;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", ratesForWeekdaysForRegularCustomer=" + ratesForWeekdaysForRegularCustomer +
                ", ratesForWeekdaysForRewardCustomer=" + ratesForWeekdaysForRewardCustomer +
                ", ratesForWeekendForRegularCustomer=" + ratesForWeekendForRegularCustomer +
                ", ratesForWeekendForRewardCustomer=" + ratesForWeekendForRewardCustomer +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRatesForWeekdaysForRegularCustomer() {
        return ratesForWeekdaysForRegularCustomer;
    }

    public void setRatesForWeekdaysForRegularCustomer(int ratesForWeekdaysForRegularCustomer) {
        this.ratesForWeekdaysForRegularCustomer = ratesForWeekdaysForRegularCustomer;
    }

    public int getRatesForWeekdaysForRewardCustomer() {
        return ratesForWeekdaysForRewardCustomer;
    }

    public void setRatesForWeekdaysForRewardCustomer(int ratesForWeekdaysForRewardCustomer) {
        this.ratesForWeekdaysForRewardCustomer = ratesForWeekdaysForRewardCustomer;
    }

    public int getRatesForWeekendForRegularCustomer() {
        return ratesForWeekendForRegularCustomer;
    }

    public void setRatesForWeekendForRegularCustomer(int ratesForWeekendForRegularCustomer) {
        this.ratesForWeekendForRegularCustomer = ratesForWeekendForRegularCustomer;
    }

    public int getRatesForWeekendForRewardCustomer() {
        return ratesForWeekendForRewardCustomer;
    }

    public void setRatesForWeekendForRewardCustomer(int ratesForWeekendForRewardCustomer) {
        this.ratesForWeekendForRewardCustomer = ratesForWeekendForRewardCustomer;
    }
}
    enum CustomerTypes{
        REGULAR, REWARD;
    }



