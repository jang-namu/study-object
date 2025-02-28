package com.namu.object._05_movie;

import com.namu.object._02_movie.Money;

public class AmountDiscountPolicy extends DiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    Money getDiscountAmount(Movie movie) {
        return discountAmount;
    }

}
