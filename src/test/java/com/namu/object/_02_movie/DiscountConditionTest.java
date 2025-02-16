package com.namu.object._02_movie;


import static org.assertj.core.api.Assertions.assertThat;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import net.bytebuddy.asm.Advice.Local;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DiscountConditionTest {

    @Nested
    @DisplayName("순서 할인 조건")
    class SequenceConditionTest {

        @Test
        @DisplayName("지정된 순서와 같은 순번의 상영에 대해 할인 조건을 만족한다")
        void isSatisfiedBy() {
            // given
            DiscountCondition condition = new SequenceCondition(1);
            Movie movie = new Movie("테스트", Duration.ofMinutes(120), Money.wons(10000), new NoneDiscountPolicy());

            // when
            Screening discountScreening = new Screening(movie, 1, LocalDateTime.now());
            Screening noneDiscountScreening = new Screening(movie, 2, LocalDateTime.now());

            // when && then
            assertThat(condition.isSatisfiedBy(discountScreening)).isTrue();
            assertThat(condition.isSatisfiedBy(noneDiscountScreening)).isFalse();
        }
    }

    @Nested
    @DisplayName("기간 할인 조건")
    class PeriodConditionTest {

        @Test
        @DisplayName("지정된 요일과 시간 범위 내의 상영에 대해 할인 조건을 만족한다")
        void isSatisfiedBy() {
            // given
            DiscountCondition condition = new PeriodCondition(DayOfWeek.WEDNESDAY, LocalTime.of(9, 0), LocalTime.of(11, 0));
            DiscountPolicy policy = new AmountDiscountPolicy(Money.wons(1000), condition);
            Movie movie = new Movie("테스트", Duration.ofMinutes(120), Money.wons(10000), policy);

            LocalDateTime validTime = LocalDateTime.of(2025, 1, 1, 10, 0);
            LocalDateTime invalidTime = LocalDateTime.of(2025, 1, 1, 12, 0);
            LocalDateTime invalidDay = LocalDateTime.of(2025, 1, 2, 10, 0);

            // when & then
            assertThat(condition.isSatisfiedBy(new Screening(movie, 1, validTime))).isTrue();
            assertThat(condition.isSatisfiedBy(new Screening(movie, 1, invalidTime))).isFalse();
            assertThat(condition.isSatisfiedBy(new Screening(movie, 1, invalidDay))).isFalse();
        }
    }

}