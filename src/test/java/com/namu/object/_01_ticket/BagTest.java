package _01_ticket;

import com.namu.object._01_ticket.Bag;
import com.namu.object._01_ticket.Invitation;
import com.namu.object._01_ticket.Ticket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BagTest {

    @DisplayName("초대장을 소지한 경우")
    @Test
    void changeTicket() {
        // given
        Bag bag = new Bag(new Invitation(), 2000L);
        Ticket ticket = new Ticket(2000L);

        // when
        bag.hold(ticket);

        // then
        assertThat(bag.getTicket()).isTrue();
        assertThat(bag.getAmount()).isEqual(2000L);
    }

    @DisplayName("초대장을 소지하지 않은 경우")
    @Test
    void buyTicket() {
        // given
        Bag bag = new Bag(2000L);
        Ticket ticket = new Ticket(2000L);

        // when
        bag.hold(ticket);

        // then
        assertThat(bag.getTicket()).isTrue();
        assertThat(bag.getAmount()).isEqual(0L);
    }
}
