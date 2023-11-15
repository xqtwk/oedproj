package factory;

public class RegularMember extends Member {
    @Override
    public void receiveNotification(String message) {
        System.out.println("Regular Member Notification: " + message);
    }
}
