package com.namu.object._05_grasp._04_movie_refactor;

import com.namu.object._02_movie.Money;
import com.namu.object._02_movie.Screening;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        boolean discountable = checkDiscountable(screening);
        Money fee = calculateMovieFee(screening, audienceCount, discountable);
        return createReservation(screening, customer, audienceCount, fee);
    }

    private boolean checkDiscountable(Screening screening) {
        return screening.getMovie().getDiscountConditions()
                .anyMatch(condition -> condition.isDiscountable(screening));
    }

    private Money calculateMovieFee(Screening screening, int audienceCount, boolean discountable) {
        if (discountable) {
            return screening.getMovie().getFee()
                    .minus(calculateDiscountAmount(screening.getMovie()))
                    .times(audienceCount);
        }
        return screening.getMovie().getFee().times(audienceCount);
    }

    private Money calculateDiscountAmount(Movie movie) {
        switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountAmount(movie);
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountAmount(movie);
            case NONE_DISCOUNT:
                return calculateNoneDiscountAmount(movie);
        }
        throw new IllegalStateException();
    }

    private Money calculateAmountDiscountAmount(Movie movie) {
        return movie.getDiscountAmount();
    }

    private Money calculatePercentDiscountAmount(Movie movie) {
        return movie.getFee().times(movie.getDiscountPercent());
    }

    private Money calculateNoneDiscountAmount(Movie movie) {
        return Money.ZERO;
    }

    private Reservation createReservation(Screening screening, Customer customer, int audienceCount, Money fee) {
        return new Reservation(customer, screening, fee, audienceCount);
    }
}