package com.namu.object._01_ticket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("극장 티켓 판매 시나리오")
class TheaterTest {
    private static final Long TICKET_PRICE = 2000L;
    private static final Long INITIAL_AMOUNT = 10000L;

    private Theater theater;
    private TicketOffice ticketOffice;

    @BeforeEach
    void setUp() {
        ticketOffice = new TicketOffice(0L, new Ticket(TICKET_PRICE));
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        theater = new Theater(ticketSeller);
    }

    @Test
    @DisplayName("초대장이 있는 관람객을 입장시킨다")
    void enterAudienceWithInvitation() {
        // given
        Audience audience = new Audience(new Bag(new Invitation(), INITIAL_AMOUNT));

        // when
        theater.enter(audience);

        // then
        assertThat(ticketOffice.getAmount()).isZero();
        assertThat(ticketOffice.getTicketsCount()).isZero();
    }

    @Test
    @DisplayName("초대장이 없는 관람객에게 티켓을 판매하고 입장시킨다")
    void enterAudienceWithoutInvitation() {
        // given
        Audience audience = new Audience(new Bag(INITIAL_AMOUNT));

        // when
        theater.enter(audience);

        // then
        assertThat(ticketOffice.getAmount()).isEqualTo(TICKET_PRICE);
        assertThat(ticketOffice.getTicketsCount()).isZero();
    }
}