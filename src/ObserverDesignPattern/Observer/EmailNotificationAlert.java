package ObserverDesignPattern.Observer;

import ObserverDesignPattern.Observable.StockObservable;

public class EmailNotificationAlert implements NotificationAlertObserver{
    private String email;
    private StockObservable observable;

    public EmailNotificationAlert(String email, StockObservable observable) {
        this.email = email;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendEmail();
    }

    public void sendEmail() {
        System.out.println("Email sent to mail Id: " + this.email);
    }
}
