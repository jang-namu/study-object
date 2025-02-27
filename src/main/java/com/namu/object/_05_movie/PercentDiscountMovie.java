package com.namu.object._05_movie;

import com.namu.object._02_movie.Money;

public class PercentDiscountMovie extends Movie{
    private double percent;

    public PercentDiscountMovie(String title, Duration duration, Money fee, double percent,
                                DiscountCondition... discountConditions) {
        super(title, duration, fee, discountConditions);
        this.percent = percent;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return getFee().times(percent);
    }
}
