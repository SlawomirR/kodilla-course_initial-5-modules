/*
Zadanie: mapa uczniów i ocen
    Stwórz program z użyciem HashMap, który będzie przechowywał dane uczniów oraz ich ocen.
    Program ma wyświetlać średnią arytmetyczną ocen każdego ucznia.
*/
import java.util.*;
public class Main_2_6 {
        public static void main(String[] args) {
            HashMap<Student, Scores> classRegister = new HashMap<Student, Scores>();
            classRegister.put(new Student("Monika", "Mika", 1982, 3,18, Subjects.MATH), new Scores());
            classRegister.put(new Student("Monika", "Mika", 1982, 3,18, Subjects.BIOLOGY), new Scores());
            classRegister.put(new Student("Monika", "Mika", 1982, 3,18, Subjects.GEOGRAPHY), new Scores());
            classRegister.put(new Student("Piotr", "Gruszka", 1983, 7,28, Subjects.BIOLOGY), new Scores());
            classRegister.put(new Student("Piotr", "Gruszka", 1983, 7,28, Subjects.MATH), new Scores());
            classRegister.put(new Student("Krzysztof", "Żuk", 1981, 8,12, Subjects.GEOGRAPHY), new Scores());

            for (Map.Entry<Student, Scores> entry: classRegister.entrySet()) {
                double average = 0;
                for (double i: entry.getValue().scores) {
                    average += i;
                }
                average = average/entry.getValue().scores.size();
                System.out.println(entry + " average score: " + String.format("%.2f", (average)));
            }
        }
    }

    class Student {
        private String firstName;
        private String lastName;
        private Integer birthYear;
        private Integer birthMonth;
        private Integer birthDay;
        private Subjects subject;

        //getters
        public String getFirstName() {
            return firstName;
        }
        public String getLastName() {
            return lastName;
        }
        public Integer getBirthYear() {
            return birthYear;
        }
        public Integer getBirthMonth() {
            return birthMonth;
        }
        public Integer getBirthDay() {
            return birthDay;
        }
        public Subjects getSubject() {
            return subject;
        }

        // setters
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public void setBirthYear(int birthYear) {
            this.birthYear = birthYear;
        }
        public void setBirthMonth(int birthMonth) {
            this.birthMonth = birthMonth;
        }
        public void setBirthDay(int birthDay) {
            this.birthDay = birthDay;
        }
        public void setSubject(Subjects subject) {
            this.subject = subject;
        }

        public Student(String firstName, String lastName, int birthYear, int birthMonth, int birthDay) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthYear = birthYear;
            this.birthMonth = birthMonth;
            this.birthDay = birthDay;
        }

        public Student(String firstName, String lastName, int birthYear, int birthMonth, int birthDay, Subjects subject) {
            this(firstName, lastName, birthYear, birthMonth, birthDay);
            this.subject = subject;
        }

        @Override
        public String toString() {
            return "Student: " + firstName + " " + lastName + ", born: " + birthYear + "-" + birthMonth + "-" + birthDay + ", " + subject + " scores";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return birthYear == student.birthYear &&
                    birthMonth == student.birthMonth &&
                    birthDay == student.birthDay &&
                    Objects.equals(firstName, student.firstName) &&
                    Objects.equals(lastName, student.lastName) &&
                    Objects.equals(subject, student.subject);
        }

        @Override
        public int hashCode() {

            return Objects.hash(subject);
        }
    }

    class Scores {
        ArrayList<Integer> scores = new ArrayList<>();
        Random random = new Random();
        Scores() {
            for (int i = 0; i < 9; i++) {
                scores.add(random.nextInt(6)+1);
            }
        }

        @Override
        public String toString() {
            String result = "{ ";
            for (Integer i: scores) {
                result += i.toString() + " ";
            }
            result += "}";
            return result;
        }
    }

    enum Subjects {
        MATH, GEOGRAPHY, BIOLOGY
    }
