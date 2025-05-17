package CommandPatternACController;

public class AirConditioner {
    boolean isOn;
    int temperature;

    public AirConditioner() {
        this.isOn = false;
        this.temperature = 24; // Default temperature
    }

    public void turnOn() {
        isOn = true;
        System.out.println("Air Conditioner is turned ON.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Air Conditioner is turned OFF.");
    }

    public void setTemperature(int temperature) {
        if (isOn) {
            this.temperature = temperature;
            System.out.println("Air Conditioner temperature set to " + temperature + "°C.");
        } else {
            System.out.println("Air Conditioner is OFF. Please turn it ON to set the temperature.");
        }
    }
}
