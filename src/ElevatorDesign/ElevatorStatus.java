package ElevatorDesign;

public enum ElevatorStatus {
    MOVING, IDLE;

    public String getStatus() {
        return this.toString();
    }
}
