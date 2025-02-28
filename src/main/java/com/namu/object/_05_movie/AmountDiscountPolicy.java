package com.namu.object._05_movie;

import com.namu.object._02_movie.DefaultDiscountPolicy;
import com.namu.object._02_movie.Money;

public class AmountDiscountPolicy extends DiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... discountConditions) {
        super(discountConditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Movie movie) {
        return discountAmount;
    }

}
