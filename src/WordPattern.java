import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Pattern;

public class WordPattern {
    public static void main(String[] args){
        System.out.println(pattern("abba", "?","dog?cat?cat?dog"));
        System.out.println(pattern("abba", "|","apple|banana|grape|apple"));
        System.out.println(pattern("aaaa", ",","dog,cat,cat,dog"));
        System.out.println(pattern("aaaa", " ","ice cream taco day"));
        System.out.println(pattern("adxp", " ","ice cream taco day"));
    }

    public static boolean pattern(String p, String d, String s){
        String[] words = s.split(Pattern.quote(d)); //I HATE REGEX!!!!

        if (words.length != p.length()) return false;

        HashMap<Character, String> patternMap = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char currentChar = p.charAt(i);
            String currentWord = words[i];

            if(!patternMap.containsKey(currentChar)){
                patternMap.put(currentChar,currentWord);
            } else if (!patternMap.get(currentChar).equals(currentWord)) {
                return false;
            }
        }

        // If all checks pass, return true
        return true;
    }
}
