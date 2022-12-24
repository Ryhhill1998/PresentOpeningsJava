import java.util.Arrays;
import java.util.HashSet;

public class Main {

    private static String firstPreviously = null;

    public static void main(String[] args) {
        String[] names = {"Aaron", "Dad", "Juliette", "Mum", "Ryan"};
        String[] shuffledNames = shuffleList(names);

        while (getFirst(shuffledNames).equals(firstPreviously)) {
            shuffledNames = shuffleList(names);
        }

        setFirst(getFirst(shuffledNames));

        printNames(shuffledNames);
    }

    private static String[] shuffleList(String[] names) {
        String[] shuffledArray = new String[names.length];
        HashSet<Integer> indexes = new HashSet<>();

        for (int i = 0; i < names.length; i++) {
            int randomIndex = getRandomIndex(names.length);

            while (indexes.contains(randomIndex)) {
                randomIndex = getRandomIndex(names.length);
            }

            indexes.add(randomIndex);
            String randomName = names[randomIndex];
            shuffledArray[i] = randomName;
        }

        return shuffledArray;
    }

    private static int getRandomIndex(int lengthOfList) {
        return (int) (Math.random() * lengthOfList);
    }

    private static String getFirst(String[] names) {
        return names[0];
    }

    private static void setFirst(String first) {
        firstPreviously = first;
    }

    private static void printNames(String[] names) {
        for (int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + ". " + names[i]);
        }
    }
}