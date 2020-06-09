package com.parking.models.parking;

import java.time.LocalDateTime;

public class Ticket {
    private LocalDateTime issued;
    private TicketStatus status;

    public LocalDateTime getIssued() {
        return issued;
    }

    public void setIssued(LocalDateTime issued) {
        this.issued = issued;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
}
