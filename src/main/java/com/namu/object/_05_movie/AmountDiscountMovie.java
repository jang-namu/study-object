package com.namu.object._05_movie;

import com.namu.object._02_movie.Money;

public class AmountDiscountMovie extends Movie {
    private Money discountAmount;

    public AmountDiscountMovie(String title, Duration duration, Money fee, Money discountAmount,
                               DiscountCondition... discountConditions) {
        super(title, duration, fee, discountConditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return discountAmount;
    }
}
