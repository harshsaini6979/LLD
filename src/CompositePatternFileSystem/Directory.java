package CompositePatternFileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{
    String name;
    List<FileSystem> fileSystems = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public void ls(String space) {
        System.out.println(space + "Directory:" + name);
        for (FileSystem fileSystem : fileSystems) {
            fileSystem.ls(space + "  ");
        }
    }

    @Override
    public void add(FileSystem fileSystem) {
        this.fileSystems.add(fileSystem);
    }
}
