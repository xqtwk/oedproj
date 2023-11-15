package observer;

public class CustomerSubscriber implements Subscriber {
    private String name;

    public CustomerSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + ", " + message);
    }
}
