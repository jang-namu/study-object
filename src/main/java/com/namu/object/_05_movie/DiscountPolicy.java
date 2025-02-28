package com.namu.object._05_movie;

import com.namu.object._02_movie.Money;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {
    private List<DiscountCondition> discountConditions;

    public DiscountPolicy(DiscountCondition... discountConditions) {
        this.discountConditions = Arrays.asList(discountConditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        if (isDiscountable(screening)) {
            return getDiscountAmount(screening.getMovie());
        }
        return Money.ZERO;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    abstract protected Money getDiscountAmount(Movie movie);
}
