package main.observer;

class ConcreteObserver implements Observer {
    private String name;
    private String role;

    public ConcreteObserver(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " gavo pranesima: " + message);
    }
}