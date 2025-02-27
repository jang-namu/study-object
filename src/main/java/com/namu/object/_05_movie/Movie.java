package com.namu.object._05_movie;

import com.namu.object._02_movie.DiscountCondition;
import com.namu.object._02_movie.Money;
import com.namu.object._05_movie.MovieType;
import java.util.List;

public class Movie {
    private String title;
    private Duration duration;
    private Moeny fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Money calculateMovieFee(Screening screening) {

    }
}
