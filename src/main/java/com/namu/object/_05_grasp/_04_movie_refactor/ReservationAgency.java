package com.namu.object._05_grasp._04_movie_refactor;

import com.namu.object._02_movie.Money;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Money fee = screening.calculateMovieFee(audienceCount);
        return createReservation(screening, customer, audienceCount, fee);
    }

    private Reservation createReservation(Screening screening, Customer customer, int audienceCount, Money fee) {
        return new Reservation(customer, screening, fee, audienceCount);
    }
}