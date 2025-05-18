package MediatorDesignPatternAuctionSystem;

import java.util.ArrayList;
import java.util.List;

public class Auction implements AuctionMediator {
    private List<Colleague> bidders;
    private int highestBid;

    public Auction() {
        bidders = new ArrayList<>();
        highestBid = 0;
    }

    @Override
    public void addBidder(Colleague colleague) {
        bidders.add(colleague);
    }

    @Override
    public void placeBid(String bidder, int bidAmount) {
        if (bidAmount > highestBid) {
            highestBid = bidAmount;
            notifyBidders(bidder);
        }
    }

    private void notifyBidders(String bidder) {
        for (Colleague colleague : bidders) {
            if (colleague.getName().equals(bidder)) {
                continue; // Skip notifying the bidder who placed the bid
            }
            colleague.getNotification(bidder);
        }
    }

    public int getHighestBid() {
        return highestBid;
    }
}
