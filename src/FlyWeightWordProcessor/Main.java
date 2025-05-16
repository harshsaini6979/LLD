package FlyWeightWordProcessor;

public class Main {
    public static void main(String[] args) {
        ILetter letterA = LetterFactory.createLetter('A', "Arial", 12);
        ILetter letterB = LetterFactory.createLetter('B', "Arial", 12);
        ILetter letterC = LetterFactory.createLetter('C', "Arial", 12);

        letterA.display(1, 1);
        letterB.display(1, 2);
        letterC.display(1, 3);

        // Reusing the same character 'A' with different font and size
        ILetter letterA2 = LetterFactory.createLetter('A', "Times New Roman", 14);
        letterA2.display(2, 1);
    }
}
