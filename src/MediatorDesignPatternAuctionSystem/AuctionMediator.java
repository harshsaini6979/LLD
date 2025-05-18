package MediatorDesignPatternAuctionSystem;

public interface AuctionMediator {
    void addBidder(Colleague colleague);
    void placeBid(String bidder, int bidAmount);
}
