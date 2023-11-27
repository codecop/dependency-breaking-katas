package org.codecop.dependencies.turnticketdispenser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TicketDispenserTest {

    @Test
    public void foo() {
        TicketDispenser dispenser = new TicketDispenser();
        TurnTicket ticket = dispenser.getTurnTicket();
        assertEquals(-1, ticket.getTurnNumber());
    }

}
