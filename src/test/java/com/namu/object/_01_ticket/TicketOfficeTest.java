package com.namu.object._01_ticket;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("매표소 테스트")
class TicketOfficeTest {
    private static final Long TICKET_PRICE = 2000L;
    private static final Long INITIAL_AMOUNT = 0L;

    private TicketOffice ticketOffice;

    @BeforeEach
    void setUp() {
        ticketOffice = new TicketOffice(INITIAL_AMOUNT, new Ticket(TICKET_PRICE));
    }

    @Test
    @DisplayName("초대장을 소지한 관람객에겐 티켓을 발급한다")
    void shouldExchangeTicketForFree() {
        // given
        Audience audience = new Audience(new Bag(new Invitation(), 0L));

        // when
        ticketOffice.sellTicketTo(audience);

        // then
        assertThat(ticketOffice.getAmount()).isEqualTo(INITIAL_AMOUNT);
        assertThat(ticketOffice.getTicketsCount()).isZero();
//        assertThat(audience.getTicket()).isNonNull();
    }

    @Test
    @DisplayName("초대장을 소지한 관람객에겐 티켓을 판매한다")
    void shouldSellTicket() {
        // given
        Audience audience = new Audience(new Bag(TICKET_PRICE));

        // when
        ticketOffice.sellTicketTo(audience);

        // then
        assertThat(ticketOffice.getAmount()).isEqualTo(INITIAL_AMOUNT + TICKET_PRICE);
        assertThat(ticketOffice.getTicketsCount()).isZero();
//        assertThat(bag.getTicket()).isNonNull();
//        assertThat(bag.getAmount()).isZero();
    }
}