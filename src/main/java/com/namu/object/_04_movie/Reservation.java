package com.namu.object._04_movie;

import com.namu.object._02_movie.Customer;
import com.namu.object._02_movie.Money;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reservation {
    private Customer customer;
    private Screening screening;
    private Money fee;
    private int audienceCount;

    public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }
}
