package proxy;

public class LibraryManagerProxy implements LibraryManager {
    private LibraryManagerImpl manager;
    private boolean isAdmin;

    public LibraryManagerProxy(boolean isAdmin) {
        this.manager = new LibraryManagerImpl();
        this.isAdmin = isAdmin;
    }

    @Override
    public void performOperation() {
        if (isAdmin) {
            manager.performOperation();
        } else {
            System.out.println("Access Denied: This operation is restricted to admin users.");
        }
    }
}
