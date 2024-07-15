package AmazonNotificationSystem.Observer;

import AmazonNotificationSystem.Observable.StockObservable;

public interface StockObserver {
    public void update(StockObservable stockObservable);
}
