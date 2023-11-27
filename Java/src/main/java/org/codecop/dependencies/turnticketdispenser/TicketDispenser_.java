package org.codecop.dependencies.turnticketdispenser;

public class TicketDispenser_ {

    public TurnTicket getTurnTicket() {

        /*
         * This static global method always counts up, even in test.
         * What to do?
         */
        int newTurnNumber = TurnNumberSequence.getNextTurnNumber();

        TurnTicket newTurnTicket = new TurnTicket(newTurnNumber);

        return newTurnTicket;
    }

}
