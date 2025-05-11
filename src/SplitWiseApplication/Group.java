package SplitWiseApplication;

import java.util.List;

public class Group {
    String groupId;
    String groupName;
    List<User> users;

    public Group(String groupId, String groupName, List<User> users) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        if (users.contains(user)) {
            System.out.println("User already exists in the group.");
            return;
        }
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupId() {
        return groupId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Group ID: ").append(groupId).append("\t");
        sb.append("Group Name: ").append(groupName).append("\t");
        sb.append("Users in Group: \t");
        for (User user : users) {
            sb.append("[");
            sb.append(user.toString()).append("], ");
        }
        return sb.toString();
    }
}
