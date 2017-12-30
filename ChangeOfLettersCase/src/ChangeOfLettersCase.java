/*
Napisz program odwracający rozmiar liter w słowie
podajesz : AbC
rezultat : aBc
*/
public class ChangeOfLettersCase {
    public static void main(String[] args) {
        String sampleString = "To JesT prZykłADowY tExT";

        StringBuilder stringBuilder = new StringBuilder();
        int stringLength = sampleString.length();

        System.out.println("String example:\n" + sampleString);
        char[] charArray = sampleString.toCharArray();
        for (int i = 0; i < stringLength; i++) {
            if (Character.isLowerCase(charArray[i])) {
                stringBuilder.append(Character.toUpperCase(charArray[i]));
            } else {
                stringBuilder.append(Character.toLowerCase(charArray[i]));
            }
        }
        System.out.print("Reversed case of letters:\n" + stringBuilder);
    }
}
