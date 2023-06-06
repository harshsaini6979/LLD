package ChainOfResponsibilityPattern;

public class ErrorLogging extends Logging{
    public ErrorLogging (Logging nextLogging) {
        super(nextLogging);
    }

    public void log(int level, String message) {
        if (level == Logging.ERROR)
            System.out.println("ERROR: " + message);
        else
            super.log(level, message);
    }
}
