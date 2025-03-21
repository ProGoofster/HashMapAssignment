import java.util.*;

public class RadixSort {
    public static void main(String[] args) {
        String[] arr = new String[]{"google", "gojo", "amazingly", "jogo", "luna", "pup", "solas", "solo", "pupperino", "amaterasu",
                "amazon", "puppy", "hydra", "amazonia", "vueltiao"};
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
        for (char c = '`'; c <= 'z'; c++) {
            charToWords.put(c, new ArrayList<>());
        }

        for (String word : arr) {
            char currentChar = charIndex < word.length() ? word.toLowerCase().charAt(charIndex) : '`'; // "`" (ascii 96) makes shorter strings always appear first
            charToWords.get(currentChar).add(word);
        }

        int index = 0;
        for (char c = '`'; c <= 'z'; c++) {
            List<String> words = charToWords.get(c);
            for (String word : words) {
                arr[index++] = word;
            }
        }
    }
}
