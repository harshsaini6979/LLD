package FlyWeightWordProcessor;

public class DocumentCharacter implements ILetter {
    //Extrinsic
    private String character;
    private String font;
    private int size;

    public DocumentCharacter(String character, String font, int size) {
        this.character = character;
        this.font = font;
        this.size = size;
    }

    @Override
    public void display(int row, int col) {
        System.out.println("Character: " + character + ", Font: " + font + ", Size: " + size + ", Row: " + row + ", Col: " + col);
    }
}
