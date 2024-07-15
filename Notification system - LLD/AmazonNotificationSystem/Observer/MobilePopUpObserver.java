package AmazonNotificationSystem.Observer;

import AmazonNotificationSystem.Observable.StockObservable;

public class MobilePopUpObserver implements StockObserver{
    String username;

    public MobilePopUpObserver(String username) {
        this.username = username;
    }


    @Override
    public void update(StockObservable stockObservable) {
        popup();
    }

    private void popup(){
        System.out.println(username + " received in-App popup notification in mobile phone");
    }
}
