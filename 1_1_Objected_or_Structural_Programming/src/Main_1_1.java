public class Main_1_1 {
    public static void main(String[] args) {
        // zmienne do kontroli granic wieku i wzrostu uzytkownika
        double limitAge = 30;
        double limitHeight = 160;

        // dane do zadania
        String name = "Adam";
        double age = 40.5;
        double height = 178;

        UserValidator uservalidator = new UserValidator(name, age, height);
        if (uservalidator.nameValidator()) {
            uservalidator.groupAge(limitAge);
            uservalidator.groupHeight(limitHeight);
        }
    }
}

class UserValidator extends User {
    UserValidator(String name, double age, double height) {
        super(name, age, height);
    }

    boolean nameValidator() {
        if (getName() != null) {
            System.out.println("User name is: " + getName() + ". Age: " + getAge() + ". Height: " + getHeight() + "cm.\n");
            return true;
        } else {
            System.err.println("Variable \"name\" is not set");
            return false;
        }
    }

    void groupAge(double limitAge) {
        if (getAge() > limitAge) {
            System.out.print("User is older than " + limitAge);
        } else {
            System.out.print("User is younger or equal " + limitAge);
        }
    }

    void groupHeight(double limitHeight) {
        if (getHeight() > limitHeight) {
            System.out.println(" and higher than " + limitHeight + "cm");
        } else {
            System.out.println(" or lower or equal than " + limitHeight + "cm");
        }
    }
}

class User {
    private String name;
    private double age;
    private double height;

    double getAge() {
        return age;
    }

    String getName() {
        return name;
    }

    double getHeight() {
        return height;
    }

    User(String name, double age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
}

