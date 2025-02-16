package com.namu.object._02_movie;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Movie 클래스 테스트")
class MovieTest {

    @Test
    @DisplayName("주어진 할인 정책에 따라 영화 요금을 계산한다")
    void calculateMovieFee() {
        // Given
        Movie avatar = new Movie(
                "아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(1000), new SequenceCondition(1)));
        Screening screening = new Screening(avatar, 1, LocalDateTime.of(2025, 2, 16, 10, 0));

        // When
        Money fee = avatar.calculateMovieFee(screening);

        // Then
        assertThat(fee).isEqualTo(Money.wons(9000));
    }
}