package com.koeftespiess.classes;

import javax.persistence.*;

@Entity
public class ReservatedSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Presentation presentation;
    @ManyToOne
    private Customer customer;
    private int seatNumber;

    public ReservatedSeat(Presentation presentation, Customer customer, int seatNumber) {
        this.presentation = presentation;
        this.customer = customer;
        this.seatNumber = seatNumber;
    }

    public ReservatedSeat() {
    }

    @Override
    public String toString() {
        return "ReservatedSeat{" +
                "id=" + id +
                ", presentation=" + presentation +
                ", customer=" + customer +
                ", seatNumber=" + seatNumber +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
