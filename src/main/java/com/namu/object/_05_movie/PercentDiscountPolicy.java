package com.namu.object._05_movie;

import com.namu.object._02_movie.Money;

public class PercentDiscountPolicy extends DiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent) {
        this.percent = percent;
    }

    @Override
    Money getDiscountAmount(Movie movie) {
        return movie.getFee().times(percent);
    }
}
