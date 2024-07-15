package AmazonNotificationSystem.Observer;

import AmazonNotificationSystem.Observable.StockObservable;

public class EmailObserver implements StockObserver{
    String email;

    public EmailObserver(String email) {
        this.email = email;
    }

    @Override
    public void update(StockObservable stockObservable) {
        sendEmail(email);
    }

    private void sendEmail(String email){
        System.out.println("Notification received on the email id: " + email);
    }
}
