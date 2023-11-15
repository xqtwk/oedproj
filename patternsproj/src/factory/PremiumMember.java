package factory;

public class PremiumMember extends Member {
    @Override
    public void receiveNotification(String message) {
        System.out.println("Premium Member Notification: " + message);
    }
}
