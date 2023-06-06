package ParkingLot.ExitGate.PriceStategy;

import ParkingLot.EnteranceGate.Ticket;

public interface PriceStrategy {
    public int price(Ticket ticket);
}
