package com.namu.object._05_grasp._05_movie;

import static org.assertj.core.api.Assertions.assertThat;

import com.namu.object._02_movie.Money;
import java.time.Duration;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("할인 정책 테스트")
public class DiscountPolicyTest {

    @Nested
    @DisplayName("금액 할인 정책")
    class AmountDiscountPolicyTest {
        @Test
        @DisplayName("조건 만족 시 지정 금액만큼 할인한다")
        void shouldDiscountAmountWhenConditionIsSatisfied() {
            DiscountPolicy policy = new AmountDiscountPolicy(Money.wons(1000), new SequenceDiscountCondition(1));
            Movie movie = new Movie(
                    "영화 타이틀",
                    Duration.ofMinutes(120),
                    Money.wons(10000),
                    policy);
            Screening screening = new Screening(movie, 1, LocalDateTime.now());

            Money discountAmount = policy.calculateDiscountAmount(screening);

            assertThat(discountAmount).isEqualTo(Money.wons(1000));
        }

    }


    @Nested
    @DisplayName("비율 할인 정책")
    class PercentDiscountPolicyTest {
        @Test
        @DisplayName("조건 만족 시 일정 비율만큼 할인한다")
        void shouldDiscountPercentWhenConditionIsSatisfied() {
            DiscountPolicy policy = new PercentDiscountPolicy(0.05, new SequenceDiscountCondition(1));
            Movie movie = new Movie(
                    "영화 타이틀",
                    Duration.ofMinutes(120),
                    Money.wons(10000),
                    policy);
            Screening screening = new Screening(movie, 1, LocalDateTime.now());

            Money discountAmount = policy.calculateDiscountAmount(screening);

            assertThat(discountAmount).isEqualTo(Money.wons(500.0));
        }
    }


    @Nested
    @DisplayName("할인 미적용 정책")
    class NoneDiscountPolicyTest {
        @Test
        @DisplayName("항상 0원을 반환한다")
        void shouldReturnZeroAlways() {
            DiscountPolicy policy = new NoneDiscountPolicy();
            Movie movie = new Movie(
                    "영화 타이틀",
                    Duration.ofMinutes(120),
                    Money.wons(10000),
                    policy);
            Screening screening = new Screening(movie, 1, LocalDateTime.now());

            Money discountAmount = policy.calculateDiscountAmount(screening);

            assertThat(discountAmount).isEqualTo(Money.ZERO);
        }
    }

}
