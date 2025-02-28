package com.namu.object._05_grasp._05_movie;

import com.namu.object._02_movie.Money;

public class PercentDiscountPolicy extends DiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... discountConditions) {
        super(discountConditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Movie movie) {
        return movie.getFee().times(percent);
    }
}
