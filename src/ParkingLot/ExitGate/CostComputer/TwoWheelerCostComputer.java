package ParkingLot.ExitGate.CostComputer;

import ParkingLot.ExitGate.PriceStategy.HourlyPriceStrategy;
import ParkingLot.ExitGate.PriceStategy.PriceStrategy;

public class TwoWheelerCostComputer extends CostComputer {
    public TwoWheelerCostComputer() {
        super(new HourlyPriceStrategy());
    }
}
