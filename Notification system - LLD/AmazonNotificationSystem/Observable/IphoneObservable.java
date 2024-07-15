package AmazonNotificationSystem.Observable;

import AmazonNotificationSystem.Observer.StockObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements StockObservable{
    List<StockObserver> observerList;
    int count;

    public IphoneObservable(int count) {
        this.count = count;
        observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(StockObserver stockObserver) {
        System.out.println("Added stock observer for Iphone");
        observerList.add(stockObserver);
    }

    @Override
    public void removeObserver(StockObserver stockObserver) {
        System.out.println("Removed the stock observer for Iphone");
        observerList.remove(stockObserver);
    }

    @Override
    public void notifyObservers() {
        System.out.println("Notify All the Iphone Observers");
        for(StockObserver stockObserver: observerList){
            stockObserver.update(this);
        }
    }

    @Override
    public void setData(int newCount) {
        if(newCount == 0){
            System.out.println("Iphone not in stock");
            this.count = newCount;
        } else if(newCount > 0){
            notifyObservers();
            this.count = newCount;
        } else{
            System.out.println("Product count cannot be less than zero");
        }
    }

    @Override
    public int getData() {
        return count;
    }
}
