package ObserverDesignPattern.Observer;

import ObserverDesignPattern.Observable.StockObservable;

public class MobileNotificationAlert implements NotificationAlertObserver{
    private String mobile;
    private StockObservable observable;

    public MobileNotificationAlert(String mobile, StockObservable observable) {
        this.mobile = mobile;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMessage();
    }

    public void sendMessage() {
        System.out.println("Message sent to mail Id: " + this.mobile);
    }
}
