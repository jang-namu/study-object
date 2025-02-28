package com.namu.object._05_movie;

import com.namu.object._02_movie.Money;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private String title;
    private Duration duration;
    private Money fee;
    private List<DiscountCondition> discountConditions;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration duration, Money fee, DiscountPolicy discountPolicy,
                 DiscountCondition... discountConditions) {
        this.title = title;
        this.duration = duration;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountConditions);
        this.discountPolicy = discountPolicy;
    }

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(discountPolicy.calculateDiscountAmount(this));
        }
        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    protected Money getFee() {
        return fee;
    }

}

