package com.namu.object._01_ticket;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("가방 테스트")
public class BagTest {
    private static final Long TICKET_PRICE = 2000L;
    private static final Long INITIAL_AMOUNT = 10000L;

    @Test
    @DisplayName("초대장이 있으면 값을 지불하지 않고 티켓을 받는다")
    void shouldExchangeTicketForFree() {
        // given
        Bag bag = new Bag(new Invitation(), INITIAL_AMOUNT);
        Ticket ticket = new Ticket(TICKET_PRICE);

        // when
        bag.hold(ticket);

        // then
//        assertThat(bag.hasTicket()).isTrue();
//        assertThat(bag.getAmount()).isEqual(INITIAL_AMOUNT);
    }

    @Test
    @DisplayName("초대장이 없으면 값을 지불하고 티켓을 구매한다")
    void shouldPayForTicket() {
        // given
        Bag bag = new Bag(INITIAL_AMOUNT);
        Ticket ticket = new Ticket(TICKET_PRICE);

        // when
        bag.hold(ticket);

        // then
//        assertThat(bag.hasTicket()).isTrue();
//        assertThat(bag.getAmount()).isEqual(INITIAL_AMOUNT - TICKET_PRICE);
    }
}
