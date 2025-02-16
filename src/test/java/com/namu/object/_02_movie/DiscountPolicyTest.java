package com.namu.object._02_movie;


import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DiscountPolicyTest {

    @Nested
    @DisplayName("할인 미적용 정책")
    class NoneDiscountPolicyTest {

        @Test
        @DisplayName("항상 0원을 반환한다")
        void calculateDiscountAmount() {
            // given
            DiscountPolicy policy = new NoneDiscountPolicy();
            Screening screening = new Screening(new Movie("테스트", Duration.ofMinutes(120), Money.wons(10000), policy), 1,
                    LocalDateTime.now());

            // when
            Money discountAmount = policy.calculateDiscountAmount(screening);

            // then
            assertThat(discountAmount).isEqualTo(Money.ZERO);
        }
    }

    @Nested
    @DisplayName("금액 할인 정책")
    class AmountDiscountPolicyTest {
        @Test
        @DisplayName("조건 만족 시 지정된 금액만큼 할인한다")
        void calculateDiscountAmount() {
            // given
            DiscountPolicy policy = new AmountDiscountPolicy(Money.wons(1000), new SequenceCondition(1));
            Screening screening = new Screening(new Movie("테스트", Duration.ofMinutes(120), Money.wons(10000), policy), 1,
                    LocalDateTime.now());

            // when
            Money discountAmount = policy.calculateDiscountAmount(screening);

            // then
            assertThat(discountAmount).isEqualTo(Money.wons(1000));
        }
    }

    @Nested
    @DisplayName("비율 할인 정책")
    class PercentDiscountPolicyTest {
        @Test
        @DisplayName("조건 만족 시 지정된 비율만큼 할인한다")
        void calculateDiscountAmount() {
            // given
            DiscountPolicy policy = new PercentDiscountPolicy(0.1, new SequenceCondition(1));
            Screening screening = new Screening(new Movie("테스트", Duration.ofMinutes(120), Money.wons(10000), policy), 1,
                    LocalDateTime.now());

            // when
            Money discountAmount = policy.calculateDiscountAmount(screening);

            // then
            assertThat(discountAmount).isEqualTo(Money.wons(10000).times(0.1)); // BigDecimal precision
        }
    }
}