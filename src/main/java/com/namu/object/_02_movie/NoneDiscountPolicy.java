package com.namu.object._02_movie;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
