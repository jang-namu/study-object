package com.namu.object._05_movie;

import com.namu.object._02_movie.Money;

public abstract class DiscountPolicy {

    public Money calculateDiscountAmount(Movie movie) {
        return getDiscountAmount(movie);
    }

    abstract Money getDiscountAmount(Movie movie);
}
