package AmazonNotificationSystem.Observable;

import AmazonNotificationSystem.Observer.StockObserver;

public interface StockObservable {
    public void addObserver(StockObserver stockObserver);
    public void removeObserver(StockObserver stockObserver);
    public void notifyObservers();

    public void setData(int count);
    public int getData();
}
