package com.namu.object._01_ticket;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("관람객 테스트")
public class AudienceTest {
    private static final Long TICKET_PRICE = 2000L;
    private static final Long INITIAL_AMOUNT = 10000L;

    private Ticket ticket;

    @BeforeEach
    void setUp() {
        ticket = new Ticket(TICKET_PRICE);
    }

    @Test
    @DisplayName("초대장이 있으면 무료로 티켓을 교환한다")
    void shouldBuyTicketWithInvitation() {
        // given
        Bag bag = new Bag(new Invitation(), INITIAL_AMOUNT);
        Audience audience = new Audience(bag);

        // when
        Long payment = audience.buy(ticket);

        // then
        assertThat(payment).isZero();
    }

    @Test
    @DisplayName("초대장이 없으면 티켓을 구매한다")
    void shouldBuyTicketWithoutInvitation() {
        // given
        Bag bag = new Bag(INITIAL_AMOUNT);
        Audience audience = new Audience(bag);

        // when
        Long payment = audience.buy(ticket);

        // then
        assertThat(payment).isEqualTo(TICKET_PRICE);
    }
}
