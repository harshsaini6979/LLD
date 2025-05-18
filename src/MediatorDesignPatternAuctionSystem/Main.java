package MediatorDesignPatternAuctionSystem;

public class Main {
    public static void main(String[] args) {
        AuctionMediator auctionMediator = new Auction();

        Colleague bidder1 = new Bidder("Bidder 1", auctionMediator);
        Colleague bidder2 = new Bidder("Bidder 2", auctionMediator);
        Colleague bidder3 = new Bidder("Bidder 3", auctionMediator);

        System.out.println("Round 1:");
        bidder1.placeBid("Bidder 1", 100);
        System.out.println("\nRound 2:");
        bidder2.placeBid("Bidder 2", 150);
        System.out.println("\nRound 3:");
        bidder3.placeBid("Bidder 3", 200);

        System.out.println("\nHighest bit amount: " + ((Auction) auctionMediator).getHighestBid());
    }
}
