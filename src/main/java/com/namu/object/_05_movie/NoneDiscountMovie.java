package com.namu.object._05_movie;

import com.namu.object._02_movie.Money;

public class NoneDiscountMovie extends Movie {
    public NoneDiscountMovie(String title, Duration duration, Money fee) {
        super(title, duration, fee);
    }

    @Override
    public Money calculateDiscountAmount() {
        return Money.ZERO;
    }
}
