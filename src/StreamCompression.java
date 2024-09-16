import java.util.Map;
import java.util.TreeMap;

public class StreamCompression {
    //Do not modify this method signature but you can modify the code in the method as you see fit
    //You can create other classes or functions if needed

    private static final Map<Character, Integer> STATE = new TreeMap<>();

    public static String compressStream(char c, boolean add) {
        char lowerCase = Character.toLowerCase(c);
        STATE.putIfAbsent(lowerCase, 0);
        STATE.computeIfPresent(lowerCase, (k, v) -> add ? v + 1 : (v > 0 ? v - 1 : 0));

        StringBuilder result = new StringBuilder();

        STATE.forEach((k, v) -> {
            if (v > 0) {
                result.append(v).append(k);
            }
        });
        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(compressStream('a', true));
        System.out.println(compressStream('t', true));
        System.out.println(compressStream('n', true));
        System.out.println(compressStream('a', true));
        System.out.println(compressStream('t', true));
        System.out.println(compressStream('b', true));
        System.out.println(compressStream('N', false));
    }
}