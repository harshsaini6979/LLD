package MediatorDesignPatternAuctionSystem;

public interface Colleague {
    void getNotification(String bidder);
    void placeBid(String bidder, int bidAmount);
    String getName();
}
