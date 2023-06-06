package ParkingLot.ExitGate.PriceStategy;

import ParkingLot.EnteranceGate.Ticket;

public class HourlyPriceStrategy implements PriceStrategy {
    int hourPrice;

    public HourlyPriceStrategy() {
        this.hourPrice = 10;
    }

    public HourlyPriceStrategy(int hourPrice) {
        this.hourPrice = hourPrice;
    }

    @Override
    public int price(Ticket ticket) {
        long exitTime = System.currentTimeMillis();

        long timeInHour = (exitTime - ticket.getEntryTime())/3600000;

        return (int)Math.ceil(this.hourPrice * timeInHour);
    }
}
