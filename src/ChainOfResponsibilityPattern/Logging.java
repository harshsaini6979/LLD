package ChainOfResponsibilityPattern;

public abstract class Logging {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;


    Logging nextLoggingLevel;

    public Logging(Logging nextLoggingLevel) {
        this.nextLoggingLevel = nextLoggingLevel;
    }

    public void log(int level, String message) {
        if (nextLoggingLevel != null)
            nextLoggingLevel.log(level, message);
        else
            System.out.println("The mentioned Log level does not exist!!");
    }
}
