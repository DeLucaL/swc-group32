package assignments.SoftCon2020_Assignment_4;

public abstract class Person {
    final String name;
    final String surname;
    int age;
    final int ID;

    protected Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.ID = this.hashCode();
    }

    //Getters
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }
}
