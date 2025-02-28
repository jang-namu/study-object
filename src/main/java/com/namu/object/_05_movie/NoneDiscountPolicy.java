package com.namu.object._05_movie;

import com.namu.object._02_movie.DefaultDiscountPolicy;
import com.namu.object._02_movie.Money;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Movie movie) {
        return Money.ZERO;
    }
}
