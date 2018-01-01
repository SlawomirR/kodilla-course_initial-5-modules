/*
Zadanie: mapa uczniów i ocen
    Stwórz program z użyciem HashMap, który będzie przechowywał dane uczniów oraz ich ocen.
    Program ma wyświetlać średnią arytmetyczną ocen każdego ucznia.
*/
import java.util.*;
/**
 * Version 1.1
 // TODO jak zapisywać średnie w mapie?
 // TODO wyszukiwać najlepszego i najgorszego z poszczególnych przedmiotów
 // TODO tworzyć listę top 10 najlepszych i najgorszych
 // TODO dodać wyszukiwanie osoby
 // TODO dodać możliwość dodawania ocen z przeliczeniem średniej
 // TODO dodać możliwość korekty oceny z przeliczeniem średniej
 // TODO dadoć podział uczniów na klasy
 */
public class Main_2_6 {
        public static void main(String[] args) {
            ClassRegister classRegister = new ClassRegister();

            classRegister.getClassRegister();
        }
    }

    final class ClassRegister {
        private HashMap<Student, HashMap<Subjects, Scores>> classRegister = new HashMap<>();
        void getClassRegister() {
            System.out.println("We've had " + classRegister.size() + " users in our school ;-)\n");
            for (Map.Entry<Student, HashMap<Subjects, Scores>> outerEntry: classRegister.entrySet()) {
                System.out.println(outerEntry.getKey().toString());
                for (Map.Entry<Subjects, Scores> innerEntry: outerEntry.getValue().entrySet()) {
                    double average = 0;
                    for (double iEntry: innerEntry.getValue().getScores()) {
                        average += iEntry;
                    }
                    average = average / innerEntry.getValue().getScores().size();
                    System.out.println("\t" + innerEntry.getKey().toString() + " " + innerEntry.getValue().toString()
                            + " with average score: " + String.format("%.2f", average));
                }
                System.out.println("====================");
            }
            System.out.println("We've had " + classRegister.size() + " users in our school ;-)");
        }

        ClassRegister() {
            classRegister.put(new Student("Monika", "Mika", new RandomShortFakePeselGenerator().getFakePesel()), new ParticularSubjectsScores().getParticularSubjectsScores());
            classRegister.put(new Student("Monika", "Mika", new RandomShortFakePeselGenerator().getFakePesel()), new ParticularSubjectsScores().getParticularSubjectsScores());
            classRegister.put(new Student("Monika", "Mika", new RandomShortFakePeselGenerator().getFakePesel()), new ParticularSubjectsScores().getParticularSubjectsScores());
            classRegister.put(new Student("Piotr", "Gruszka", new RandomShortFakePeselGenerator().getFakePesel()), new ParticularSubjectsScores().getParticularSubjectsScores());
            classRegister.put(new Student("Piotr", "Gruszka", new RandomShortFakePeselGenerator().getFakePesel()), new ParticularSubjectsScores().getParticularSubjectsScores());
            classRegister.put(new Student("Krzysztof", "Żuk", new RandomShortFakePeselGenerator().getFakePesel()), new ParticularSubjectsScores().getParticularSubjectsScores());
            for (int i = 0; i < 170; i++) {
                String helpString = "abcdefghijklmnopqrstwzźżąęćśńłó";
                classRegister.put(new Student(new RandomStringGenerator(3, 12, helpString).getRandomString(), new RandomStringGenerator(3, 31, helpString).getRandomString(), new RandomShortFakePeselGenerator().getFakePesel()), new ParticularSubjectsScores().getParticularSubjectsScores());
            }
        }

        @Override
        public String toString() {
            String getKey ="";
            for (Map.Entry<Student, HashMap<Subjects, Scores>> outerEntry: classRegister.entrySet()) {
                getKey = outerEntry.getKey().toString();
            }
            return "Student: " + getKey;
        }
    }

    final class Student {
        private String firstName;
        private String lastName;
        private String peselId;

        //getters
        private String getFirstName() {
            return firstName;
        }
        private String getLastName() {
            return lastName;
        }
        private String getBirthYear() {
            return peselId.substring(0, 2);
        }
        private String getBirthMonth() {
            return peselId.substring(2, 4);
        }
        private String getBirthDay() {
            return peselId.substring(4);
        }

        Student(String firstName, String lastName, String dateFromPesel) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.peselId = dateFromPesel;
        }

        @Override
        public String toString() {
            return "Student: " + getFirstName() + " " + getLastName() + ", born: 19" + getBirthYear() + "-" + getBirthMonth() + "-" + getBirthDay();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return  Objects.equals(firstName, student.firstName) &&
                    Objects.equals(lastName, student.lastName) &&
                    Objects.equals(peselId, student.peselId);
        }

        @Override
        public int hashCode() {
        /*
        int result = 17;
        result = result *37 + firstName.hashCode();
        result = result *37 + lastName.hashCode();
        result = result *37 + peselId.hashCode();
        */
            return Objects.hash(firstName, lastName, peselId);
        }
    }

    final class ParticularSubjectsScores {
        private HashMap<Subjects, Scores> ParticularSubjectsScores;
        private StringBuilder fullInfo;

        HashMap<Subjects, Scores> getParticularSubjectsScores() {
            return ParticularSubjectsScores;
        }

        ParticularSubjectsScores() {
            ParticularSubjectsScores = new HashMap<>();
            //fullInfo = "";
            for (Subjects subject: Subjects.values()) {
                ParticularSubjectsScores.put(subject, new Scores());
            }
        }

        @Override
        public String toString() {
            for (Map.Entry<Subjects, Scores> deepEntry : ParticularSubjectsScores.entrySet()) {
                double average = 0;
                for (double i : deepEntry.getValue().getScores()) {
                    average += i;
                }
                average = average / deepEntry.getValue().getScores().size();
                fullInfo.append(deepEntry.getKey() + " " + deepEntry.getValue() + " average score: " + String.format("%.2f", (average)) + "\n");
            }
            return fullInfo.toString();
        }
    }

    final class Scores {
        private ArrayList<Integer> scores;

        protected ArrayList<Integer> getScores() {
            return scores;
        }

        Scores() {
            scores = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < 9; i++) {
                scores.add(random.nextInt(6) + 1);
            }
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append("{ ");
            for (Integer i : scores) {
                result.append(i.toString()).append(" ");
            }
            result.append("}");
            return result.toString();
        }
    }

    enum Subjects {
        MATH, GEOGRAPHY, BIOLOGY, CHEMISTRY, PHYSICS
    }

    final class RandomStringGenerator {
        private StringBuilder randomString = new StringBuilder();

        RandomStringGenerator(int minLength, int maxLength, String setOfChars) {
            Random rndStrNum = new Random();
            int setOfCharsLength = setOfChars.length();
            int rndStrLen = rndStrNum.nextInt(maxLength - minLength) + minLength;
            while (rndStrLen >= 0) {
                randomString.append(setOfChars.charAt(rndStrNum.nextInt(setOfCharsLength)));
                rndStrLen--;
            }
        }

        protected String getRandomString() {
            return randomString.toString();
        }
    }

    final class RandomShortFakePeselGenerator {
        private String fakePesel;

        RandomShortFakePeselGenerator() {
            Random rndNum = new Random();
            Integer rndYear  = rndNum.nextInt(99 - 19) + 19;
            String rndMonth  = Integer.toString(rndNum.nextInt(12 - 1)  + 1);
            String rndDay    = Integer.toString(rndNum.nextInt(28 - 1)  + 1);
            rndMonth = rndMonth.length() == 1? "0" + rndMonth : rndMonth;
            rndDay   = rndDay.length()   == 1? "0" + rndDay   : rndDay;
            fakePesel = rndYear.toString() + rndMonth + rndDay;
        }

        protected String getFakePesel() {
            return fakePesel;
        }
    }
