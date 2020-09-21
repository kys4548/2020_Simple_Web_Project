package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private Long amounts;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amounts, Ticket ... tickets) {
        this.amounts = amounts;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    private Ticket getTicket() {
        return tickets.remove(0);
    }

    public void plusAmount(Long amounts) {
        this.amounts += amounts;
    }

    public void minusAmount(Long amounts) {
        this.amounts -= amounts;
    }

    public void sellTicketTo(Audience audience) {
        plusAmount(audience.buy(getTicket()));
    }
}
