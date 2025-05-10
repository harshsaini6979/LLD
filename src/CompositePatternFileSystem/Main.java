package CompositePatternFileSystem;

public class Main {
    public static void main(String[] args) {
        FileSystem directory1 = new Directory("directory1");

        FileSystem file1 = new File("file1");

        FileSystem directory2 = new Directory("directory2");
        FileSystem file2 = new File("file2");

        directory2.add(file2);

        directory1.add(file1);
        directory1.add(directory2);

        directory1.ls("");
    }


}
