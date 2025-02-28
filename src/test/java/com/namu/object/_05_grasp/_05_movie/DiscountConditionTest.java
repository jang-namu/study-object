package com.namu.object._05_grasp._05_movie;

import static org.assertj.core.api.Assertions.assertThat;

import com.namu.object._02_movie.AmountDiscountPolicy;
import com.namu.object._02_movie.DiscountCondition;
import com.namu.object._02_movie.DiscountPolicy;
import com.namu.object._02_movie.Money;
import com.namu.object._02_movie.Movie;
import com.namu.object._02_movie.NoneDiscountPolicy;
import com.namu.object._02_movie.PeriodCondition;
import com.namu.object._02_movie.Screening;
import com.namu.object._02_movie.SequenceCondition;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("할인 조건 테스트")
public class DiscountConditionTest {
    @Nested
    @DisplayName("순서 할인 조건")
    class SequenceConditionTest {

        @Test
        @DisplayName("지정된 순서와 같은 순번의 상영에 대해 할인 조건을 만족한다")
        void isSatisfiedBy() {
            // given
            com.namu.object._02_movie.DiscountCondition condition = new SequenceCondition(1);
            com.namu.object._02_movie.Movie movie = new com.namu.object._02_movie.Movie("테스트", Duration.ofMinutes(120), Money.wons(10000), new NoneDiscountPolicy());

            // when
            com.namu.object._02_movie.Screening discountScreening = new com.namu.object._02_movie.Screening(movie, 1, LocalDateTime.now());
            com.namu.object._02_movie.Screening noneDiscountScreening = new com.namu.object._02_movie.Screening(movie, 2, LocalDateTime.now());

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
            DiscountCondition condition = new PeriodCondition(
                    DayOfWeek.WEDNESDAY, LocalTime.of(9, 0), LocalTime.of(11, 0));
            DiscountPolicy policy = new AmountDiscountPolicy(Money.wons(1000), condition);
            com.namu.object._02_movie.Movie movie = new Movie("테스트", Duration.ofMinutes(120), Money.wons(10000), policy);

            LocalDateTime validTime = LocalDateTime.of(2025, 1, 1, 10, 0);
            LocalDateTime invalidTime = LocalDateTime.of(2025, 1, 1, 12, 0);
            LocalDateTime invalidDay = LocalDateTime.of(2025, 1, 2, 10, 0);

            // when & then
            assertThat(condition.isSatisfiedBy(new com.namu.object._02_movie.Screening(movie, 1, validTime))).isTrue();
            assertThat(condition.isSatisfiedBy(new com.namu.object._02_movie.Screening(movie, 1, invalidTime))).isFalse();
            assertThat(condition.isSatisfiedBy(new Screening(movie, 1, invalidDay))).isFalse();
        }
    }
}
