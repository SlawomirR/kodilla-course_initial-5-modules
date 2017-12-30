/*
KROK 1 Stwórz klasę

    Nazwij ją User.
    Dodaj atrybuty użytkownika takie jak: imię, nazwisko, płeć, wiek, mail.
    Utwórz konstruktor dla tej klasy.
    Stwórz metody charakterystyczne dla klasy użytkownika tj.: logowanie, usunięcie konta.
    Stwórz gettery dla atrybutów klasy.

KROK 2 Stwórz klasę podrzędną (dziedziczącą po klasie User).

    Nazwij ją ForumUser.
    Dodaj atrybuty charakterystyczne dla użytkownika forum np. nazwa użytkownika, liczba postów, zalogowany (true/false).
    Utwórz konstruktor dla użytkownika forum.
    Stwórz metody charakterystyczne dla użytkownika forum np. opublikowanie postu na forum czy komentowanie postu oraz taką która będzie przedstawiała użytkownika w konsoli.
    Odziedzicz właściwości klasy User.
    Rozbuduj konstruktor o metodę super().

KROK 3 Stwórz klasę Application:

    Stwórz w niej metodę main().
    Utwórz nowy obiekt ForumUser.
    Wywołaj metodą która przedstawi nam użytkownika forum w konsoli.

*/
public class Main_0_6 {
    public static void main(String[] args) {
        ForumUser forumUser = new ForumUser("Jan", "Kowalski", "male", 25, "jan.kowalski@kodilla.com",
                "jan_kowalski", 34, false);
        forumUser.setIsLogged(true); // I changed manually this value to achieve assumed return answer
        forumUser.showSafelUserInfo();
    }
}

class User {
    private final String name;
    private final String surname;
    private final String sex;
    private final int age;
    private final String mail;

    // getters
    String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getSex() {
        return sex;
    }
    public int getAge() {
        return age;
    }
    public String getMail() {
        return mail;
    }

    // constructor
    User(String name, String surname, String sex, int age, String mail) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
        this.mail = mail;
    }

    // methods
    public void login() {

    }
    public void removeAccount() {

    }
}

class ForumUser extends User {
    private String forumUserName;
    private int postsNumber;
    private boolean isLogged;

    // getters
    private String getForumUserName() {
        return forumUserName;
    }
    private int getPostsNumber() {
        return postsNumber;
    }
    private boolean getIsLogged() {
        return isLogged;
    }
    // setter
    public void setIsLogged(boolean loginStatus) {
        this.isLogged = loginStatus;
    }

    // constructor
    ForumUser(String name, String surname, String sex, int age, String mail, String forumUserName,
              int postsNumber, boolean isLogged) {
        super(name, surname, sex, age, mail);
        this.forumUserName = forumUserName;
        this.postsNumber = postsNumber;
        this.isLogged = isLogged;
    }

    // methods
    private String printLoginStatus() { //additional method for formatting purposes
        if (getIsLogged()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    @SuppressWarnings("EmptyMethod")
    public void postPublish() {
    }

    @SuppressWarnings("EmptyMethod")
    public void postComment() {
    }

    public void showSafelUserInfo() { // show safe user info only
        System.out.println("Hello from: "+getName()+", well known as: "+getForumUserName());
        System.out.println("The user posted: "+getPostsNumber()+" messages");
        System.out.println("Is the user currently logged in? => "+printLoginStatus());
    }
}
