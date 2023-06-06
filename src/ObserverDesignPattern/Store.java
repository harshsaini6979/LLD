package ObserverDesignPattern;

import ObserverDesignPattern.Observable.IphoneObservableImpl;
import ObserverDesignPattern.Observable.StockObservable;
import ObserverDesignPattern.Observer.EmailNotificationAlert;
import ObserverDesignPattern.Observer.MobileNotificationAlert;
import ObserverDesignPattern.Observer.NotificationAlertObserver;

public class Store {
    public static void main(String args[]) {
        StockObservable iphoneSubscribers = new IphoneObservableImpl();

        NotificationAlertObserver user1 = new EmailNotificationAlert("abc@gmail.com", iphoneSubscribers);
        NotificationAlertObserver user2 = new EmailNotificationAlert("xyz@gmail.com", iphoneSubscribers);
        NotificationAlertObserver user3 = new MobileNotificationAlert("9369797348", iphoneSubscribers);

        iphoneSubscribers.add(user1);
        iphoneSubscribers.add(user2);
        iphoneSubscribers.add(user3);

        iphoneSubscribers.setRecord(10);
    }
}
