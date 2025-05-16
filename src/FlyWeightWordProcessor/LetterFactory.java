package FlyWeightWordProcessor;

import java.util.HashMap;
import java.util.Map;

public class LetterFactory {
    private static Map<Character, ILetter> letterMap = new HashMap<>();

    public static ILetter createLetter(char character, String font, int size) {
        ILetter letter = letterMap.get(character);
        if (letter == null) {
            letter = new DocumentCharacter(String.valueOf(character), font, size);
            letterMap.put(character, letter);
        }
        return letter;
    }
}
