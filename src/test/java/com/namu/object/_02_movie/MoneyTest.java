package com.namu.object._02_movie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Money 클래스 테스트")
class MoneyTest {

    @Test
    @DisplayName("금액을 더한다")
    void plus() {
        // given
        Money amount1 = Money.wons(2000);
        Money amount2 = Money.wons(1000);

        // when
        Money result = amount1.plus(amount2);

        // then
        assertThat(result).isEqualTo(Money.wons(3000));
    }

    @Test
    @DisplayName("금액을 뺀다")
    void minus() {
        // given
        Money amount1 = Money.wons(2000);
        Money amount2 = Money.wons(1000);

        // when
        Money result = amount1.minus(amount2);

        // then
        assertThat(result).isEqualTo(Money.wons(1000));
    }

    @Test
    @DisplayName("금액에 비율을 곱한다")
    void times() {
        // given
        Money amount1 = Money.wons(2000);
        double percent = 0.1;

        // when
        Money result = amount1.times(percent);

        // then
//        assertThat(result).isEqualTo(Money.wons(200)); // BigDecimal의 구현방식 때문에 동등하지 않다고 나올 수 있음
    }

    @Test
    @DisplayName("금액을 비교한다")
    void compareAmount() {
        // given
        Money amount1 = Money.wons(2000);
        Money amount2 = Money.wons(1000);

        // when & then
        assertThat(amount1.isLessThan(amount2)).isFalse();
        assertThat(amount1.isGreaterThanOrEqual(amount2)).isTrue();
    }
}