package lt.kvk.i4_2.olga_korolkova.main;

public abstract class Animal implements Soundable {
    private String name;
    private int age;
    private final String gender;
    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }

    public String getGender() {
        return gender;
    }
}