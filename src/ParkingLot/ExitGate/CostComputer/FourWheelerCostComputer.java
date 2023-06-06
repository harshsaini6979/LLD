package ParkingLot.ExitGate.CostComputer;

import ParkingLot.ExitGate.PriceStategy.MinutePriceStrategy;

public class FourWheelerCostComputer extends CostComputer {
    public FourWheelerCostComputer() {
        super(new MinutePriceStrategy());
    }
}
