package ChainOfResponsibilityPattern;

public class Main {
    public static void main(String args[]) {
        Logging obj = new InfoLogging(new DebugLogging(new ErrorLogging(null)));

        obj.log(Logging.INFO, "This is Info message");
        obj.log(Logging.DEBUG, "This is Debug message");
        obj.log(Logging.ERROR, "This is Error message");
        obj.log(32, "This is EXTRA message");
    }
}
