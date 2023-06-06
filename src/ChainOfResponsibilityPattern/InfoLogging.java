package ChainOfResponsibilityPattern;

public class InfoLogging extends Logging{
    public InfoLogging (Logging nextLogging) {
        super(nextLogging);
    }

    public void log(int level, String message) {
        if (level == Logging.INFO)
            System.out.println("INFO: " + message);
        else
            super.log(level, message);
    }
}
