package CompositePatternFileSystem;

public interface FileSystem {
    public void ls(String space);

    public default void add(FileSystem fileSystem) {
        throw new UnsupportedOperationException("This operation is not supported");
    }
}
