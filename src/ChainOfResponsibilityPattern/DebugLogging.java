package ChainOfResponsibilityPattern;

public class DebugLogging extends Logging{
    public DebugLogging (Logging nextLogging) {
        super(nextLogging);
    }

    public void log(int level, String message) {
        if (level == Logging.DEBUG)
            System.out.println("DEBUG: " + message);
        else
            super.log(level, message);
    }
}
