package com.example.demo;

public class Bag {
    private Long amount;
    private Ticket ticket;
    private Invitation invitation;

    public Bag(Long amount) {
        this.amount = amount;
    }

    public Bag(Long amount, Invitation invitation) {
        this.amount = amount;
        this.invitation = invitation;
    }

    private boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public Long hold(Ticket ticket) {
        if(hasInvitation()) {
            this.ticket = ticket;
            return 0L;
        } else {
            minusAmount(ticket.getFee());
            this.ticket = ticket;
            return ticket.getFee();
        }
    }
}
