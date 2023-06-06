package ParkingLot.ExitGate.PriceStategy;

import ParkingLot.EnteranceGate.Ticket;

public class MinutePriceStrategy implements PriceStrategy {
    int minutePrice;

    public MinutePriceStrategy() {
        this.minutePrice = 2;
    }

    public MinutePriceStrategy(int minutePrice) {
        this.minutePrice = minutePrice;
    }

    @Override
    public int price(Ticket ticket) {
        long exitTime = System.currentTimeMillis();

        long timeInMinutes = (exitTime - ticket.getEntryTime())/60000;

        return (int)Math.ceil(this.minutePrice * timeInMinutes);
    }
}
