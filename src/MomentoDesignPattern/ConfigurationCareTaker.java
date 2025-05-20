package MomentoDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationCareTaker {
    private List<ConfigurationMomento> momentoList = new ArrayList<>();

    public void addMomento(ConfigurationOriginator originator) {
        momentoList.add(originator.saveConfiguration());
    }

    public void restoreMomento(ConfigurationOriginator originator) {
        if (!momentoList.isEmpty()) {
            ConfigurationMomento momento = momentoList.remove(momentoList.size() - 1);
            originator.restoreConfiguration(momento);
        }
    }
}
