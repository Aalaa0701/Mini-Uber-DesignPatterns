class SupportTicketFactory {
    public static Ticket createTicket(String ticketType ) {
        if (ticketType.equals("ride")) {
            return new RideTicket();
        } else if (ticketType.equals("payment")) {
            return new PaymentTicket();
        }
        else {
            return null;
        }
    }


}