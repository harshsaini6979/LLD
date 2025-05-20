package MomentoDesignPattern;

public class ConfigurationOriginator {
    int height;
    int width;

    public ConfigurationOriginator(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public ConfigurationMomento saveConfiguration() {
        return new ConfigurationMomento(height, width);
    }

    public void restoreConfiguration(ConfigurationMomento memento) {
        this.height = memento.getHeight();
        this.width = memento.getWidth();
    }

    public void setHeight (int height) {
        this.height = height;
    }

    public void setWidth (int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
