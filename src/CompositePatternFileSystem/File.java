package CompositePatternFileSystem;

public class File implements FileSystem{
    String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void ls(String space) {
        System.out.println(space + "Filename:" + name);
    }
}
