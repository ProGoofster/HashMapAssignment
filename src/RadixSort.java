import java.util.*;

public class RadixSort {
    //I did the uppercase extra credit

    //time O(n*m) where n is the lenght of the string array and m is the lenght of the longest string
    // the countingSort() method is called for every character in the longest string (m)
    // the loop in the middle adds a char for every string (n)
    //space is O(n) because the lists inside the hashmap grows with the amount of strings given in the input
    public static void main(String[] args) {
        String[] arr = new String[]{"google", "gojo", "amazingly", "jogo", "luna", "pup", "solas", "solo", "pupperino", "amaterasu",
                "amazon", "puppy", "hydra", "amazonia", "vueltiao", "UpperCase"};
        radixSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(String[] input){
        int maxLength = getMaxLength(input);

        for (int i = maxLength - 1; i >= 0; i--) {
            countingSort(input, i);
        }
    }

    public static int getMaxLength(String[] input){
        int maxLength = 0;
        for (String str : input){
            if(str.length() > maxLength) maxLength = str.length();
        }
        return maxLength;
    }

    private static void countingSort(String[] arr, int charIndex) {
        // Create a HashMap to store the frequency of each character
        HashMap<Character, List<String>> charToWords = new HashMap<>();

        // Initialize the HashMap with empty lists
        for (char c = '@'; c <= 'z'; c++) {
            charToWords.put(c, new ArrayList<>());
        }

        for (String word : arr) {
            char currentChar = charIndex < word.length() ? word.charAt(charIndex) : '@'; // "@" (shorter strings always appear first
            charToWords.get(currentChar).add(word);
        }

        int index = 0;
        for (char c = '@'; c <= 'z'; c++) {
            List<String> words = charToWords.get(c);
            for (String word : words) {
                arr[index++] = word;
            }
        }
    }
}
