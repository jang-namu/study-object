package com.namu.object._05_movie;

import com.namu.object._02_movie.DiscountCondition;
import com.namu.object._02_movie.Money;
import com.namu.object._05_movie.MovieType;
import java.util.List;

public class Movie {
    private String title;
    private Duration duration;
    private Money fee;
    private List<PeriodDiscountCondition> periodDiscountConditions;
    private List<SequenceDiscountCondition> sequenceDiscountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }
        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return checkPeriodDiscountConditions(screening) || checkSequenceDiscountConditions(screening);
    }

    private boolean checkPeriodDiscountConditions(Screening screening) {
        return periodDiscountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    private boolean checkSequenceDiscountConditions(Screening screening) {
        return sequenceDiscountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    private Money calculateDiscountAmount() {
        switch (movieType) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountAmount();
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountAmount();
            case NONE_DISCOUNT:
                return calculateNoneDiscountAmount();
        }
        throw new IllegalStateException();
    }

    private Money calculateNoneDiscountAmount() {
        return Money.ZERO;
    }

    private Money calculatePercentDiscountAmount() {
        return fee.times(discountPercent);
    }

    private Money calculateAmountDiscountAmount() {
        return discountAmount;
    }

}
