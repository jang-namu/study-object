package com.namu.object._05_grasp._05_movie;


import static org.assertj.core.api.Assertions.assertThat;

import com.namu.object._02_movie.Money;
import java.time.Duration;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("영화 테스트")
public class MovieTest {

    @Test
    @DisplayName("주어진 할인 정책에 따라 영화 요금을 계산한다")
    void shouldCalculateMovieFeeByDiscountPolicy() {
        Movie movie = new Movie(
                "영화 타이틀",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(1000), new SequenceDiscountCondition(1)));
        Screening screening = new Screening(movie, 1, LocalDateTime.now());

        Money fee = movie.calculateMovieFee(screening);

        assertThat(fee).isEqualTo(Money.wons(9000));
    }
}
