package com.namu.object._02_movie;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Screening 클래스 테스트")
class ScreeningTest {

    @Test
    @DisplayName("주어진 순번과 일치하는지 확인한다")
    void isSequence() {
        // Given
        Screening screening = new Screening(
                new Movie("테스트", Duration.ofMinutes(120), Money.wons(10000), new NoneDiscountPolicy()),
                1,
                LocalDateTime.now()
        );
        // when & Then
        assertThat(screening.isSequence(1)).isTrue();
        assertThat(screening.isSequence(2)).isFalse();
    }

    @Test
    @DisplayName("주어진 인원에 대한 예매를 생성한다")
    void reserve() {
        // Given
        Movie avatar = new Movie(
                "아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(1000), new SequenceCondition(1)));
        Screening screening = new Screening(avatar, 1, LocalDateTime.of(2025, 2, 16, 10, 0));
        // when
        Reservation reservation = screening.reserve(new Customer(), 5);

        // Then
//        assertThat(reservation.getFee()).isEqualTo(Money.wons(9000 * 5));
    }
}