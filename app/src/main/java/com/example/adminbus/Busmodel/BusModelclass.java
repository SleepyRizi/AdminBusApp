package com.example.adminbus.Busmodel;

public class BusModelclass {
    String busid;
    String fromlocation;
    String arrivelocation;
    String starttiming;
    String arrivetiming;
    String price;
    String busCondition;
    String reservedseats;

    public BusModelclass(){

    }

    public BusModelclass(String busid, String fromlocation, String arrivelocation, String starttiming, String arrivetiming, String price, String busCondition, String reservedseats) {
        this.busid = busid;
        this.fromlocation = fromlocation;
        this.arrivelocation = arrivelocation;
        this.starttiming = starttiming;
        this.arrivetiming = arrivetiming;
        this.price = price;
        this.busCondition = busCondition;
        this.reservedseats = reservedseats;
    }

    public String getBusid() {
        return busid;
    }

    public void setBusid(String busid) {
        this.busid = busid;
    }

    public String getFromlocation() {
        return fromlocation;
    }

    public void setFromlocation(String fromlocation) {
        this.fromlocation = fromlocation;
    }

    public String getArrivelocation() {
        return arrivelocation;
    }

    public void setArrivelocation(String arrivelocation) {
        this.arrivelocation = arrivelocation;
    }

    public String getStarttiming() {
        return starttiming;
    }

    public void setStarttiming(String starttiming) {
        this.starttiming = starttiming;
    }

    public String getArrivetiming() {
        return arrivetiming;
    }

    public void setArrivetiming(String arrivetiming) {
        this.arrivetiming = arrivetiming;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBusCondition() {
        return busCondition;
    }

    public void setBusCondition(String busCondition) {
        this.busCondition = busCondition;
    }

    public String getReservedseats() {
        return reservedseats;
    }

    public void setReservedseats(String reservedseats) {
        this.reservedseats = reservedseats;
    }

    @Override
    public String toString() {
        return "BusModelclass{" +
                "busid='" + busid + '\'' +
                ", fromlocation='" + fromlocation + '\'' +
                ", arrivelocation='" + arrivelocation + '\'' +
                ", starttiming='" + starttiming + '\'' +
                ", arrivetiming='" + arrivetiming + '\'' +
                ", price='" + price + '\'' +
                ", busCondition='" + busCondition + '\'' +
                ", reservedseats='" + reservedseats + '\'' +
                '}';
    }
}
