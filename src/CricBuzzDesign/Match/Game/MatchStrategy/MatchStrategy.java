package CricBuzzDesign.Match.Game.MatchStrategy;

import CricBuzzDesign.Match.ScoreCard;
import CricBuzzDesign.Player.Player;

import java.util.List;

public interface MatchStrategy {
    public void play(String battingTeam, String bowlingTeam, ScoreCard scoreCard);
}
