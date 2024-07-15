package AmazonNotificationSystem;

import AmazonNotificationSystem.Observable.CerealObservable;
import AmazonNotificationSystem.Observable.IphoneObservable;
import AmazonNotificationSystem.Observable.StockObservable;
import AmazonNotificationSystem.Observer.EmailObserver;
import AmazonNotificationSystem.Observer.MobilePopUpObserver;
import AmazonNotificationSystem.Observer.StockObserver;

public class Store {
    public static void main(String args[]){

        // Products in store
        StockObservable iPhone = new IphoneObservable(0);
        StockObservable cereal = new CerealObservable(0);

        // Create Observers
        StockObserver mobileObserver1 = new MobilePopUpObserver("Benny");
        StockObserver mobileObserver2 = new MobilePopUpObserver("Kenny");

        StockObserver emailObserver1 = new EmailObserver("alex@gmail.com");
        StockObserver emailObserver2 = new EmailObserver("john.d@gmail.com");

        // Subscribe to the products
        iPhone.addObserver(mobileObserver1);
        iPhone.addObserver(emailObserver1);
        iPhone.addObserver(emailObserver2);

        cereal.addObserver(mobileObserver2);
        cereal.addObserver(mobileObserver1);
        cereal.addObserver(emailObserver1);
        cereal.addObserver(emailObserver2);

        // update the count of the products
        iPhone.setData(5);
        cereal.setData(4);

        cereal.removeObserver(mobileObserver2);

        cereal.setData(0);

    }
}
