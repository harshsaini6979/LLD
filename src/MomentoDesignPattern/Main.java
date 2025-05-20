package MomentoDesignPattern;

public class Main {
    public static void main(String[] args) {
        ConfigurationOriginator originator = new ConfigurationOriginator(10, 20);
        ConfigurationCareTaker careTaker = new ConfigurationCareTaker();
        // Save the current configuration
        careTaker.addMomento(originator);

        originator.setHeight(100);
        originator.setWidth(200);

        careTaker.addMomento(originator);

        originator.setHeight(1000);
        originator.setWidth(2000);

        System.out.println("Current Configuration: " + originator.getHeight() + ", " + originator.getWidth());

        careTaker.restoreMomento(originator);
        System.out.println("Restored Configuration: " + originator.getHeight() + ", " + originator.getWidth());

        careTaker.restoreMomento(originator);
        System.out.println("Restored Configuration: " + originator.getHeight() + ", " + originator.getWidth());
    }
}
