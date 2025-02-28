package com.namu.object._05_grasp._04_movie_refactor;

import com.namu.object._02_movie.Money;
import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Money calculateMovieFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public int getSequence() {
        return sequence;
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }
}
