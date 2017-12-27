public class Main_0_6 {
    public static void main(String[] args) {
        ForumUser forumUser = new ForumUser("Jan", "Kowalski", "male", 25, "jan.kowalski@kodilla.com",
                "jan_kowalski", 34, false);
        forumUser.setIsLogged(true); // I changed manually this value to achieve assumed return answer
        forumUser.showSafelUserInfo();
    }
}

class User {
    private String name;
    private String surname;
    private String sex;
    private int age;
    private String mail;

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
    String printLoginStatus() { //additional method for formatting purposes
        if (getIsLogged()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public void postPublish() {
    }

    public void postComment() {
    }

    public void showSafelUserInfo() { // show safe user info only
        System.out.println("Hello from: "+getName()+", well known as: "+getForumUserName());
        System.out.println("The user posted: "+getPostsNumber()+" messages");
        System.out.println("Is the user currently logged in? => "+printLoginStatus());
    }
}
