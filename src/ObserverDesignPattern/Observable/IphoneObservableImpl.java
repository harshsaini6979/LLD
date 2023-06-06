package ObserverDesignPattern.Observable;

import ObserverDesignPattern.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable{
    List<NotificationAlertObserver> observerList = new ArrayList<NotificationAlertObserver>();
    int currentStock = 0;

    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyAlert() {
        for (NotificationAlertObserver obs : observerList) {
            obs.update();
        }
    }

    @Override
    public void setRecord(int stockAdded) {
        if (currentStock == 0)
            notifyAlert();
        currentStock += stockAdded;
    }

    @Override
    public int getRecord() {
        return currentStock;
    }
}
