package MediatorDesignPatternAuctionSystem;

public class Bidder implements Colleague {
    private String name;
    private int bidAmount;
    private AuctionMediator auction;

    public Bidder(String name, AuctionMediator auction) {
        this.name = name;
        this.auction = auction;
        auction.addBidder(this);
    }

    @Override
    public void getNotification(String bidder) {
        System.out.println(name + " has been notified that " + bidder + " has placed a bid.");
    }

    @Override
    public void placeBid(String bidder, int bidAmount) {
        this.bidAmount = bidAmount;
        auction.placeBid(bidder, bidAmount);
    }

    public String getName() {
        return name;
    }

    public int getBidAmount() {
        return bidAmount;
    }
}
