package main;

public class Direktorius {
    private static Direktorius direktoriusInstance;

    private Direktorius() {

    }

    public static Direktorius getDirektoriusInstance() {
        if (null == direktoriusInstance) {
            direktoriusInstance = new Direktorius();
        }
        return direktoriusInstance;
    }
    public void printDirektorius() {
        System.out.println(getDirektoriusInstance());
    }
}
