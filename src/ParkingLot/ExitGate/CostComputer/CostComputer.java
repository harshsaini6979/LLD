package ParkingLot.ExitGate.CostComputer;

import ParkingLot.EnteranceGate.Ticket;
import ParkingLot.ExitGate.PriceStategy.PriceStrategy;

public class CostComputer {
    PriceStrategy priceStategy;

    public CostComputer() {}

    public CostComputer(PriceStrategy priceStrategy) {
        this.priceStategy = priceStrategy;
    }

    public int price(Ticket ticket) {
        return this.priceStategy.price(ticket);
    }
}
