package singleton;

/**
 * SINGLETON
 */
public class SystemConfiguration {
    private static SystemConfiguration instance = new SystemConfiguration();

    private SystemConfiguration() {}

    public static SystemConfiguration getInstance() {
        return instance;
    }

}
