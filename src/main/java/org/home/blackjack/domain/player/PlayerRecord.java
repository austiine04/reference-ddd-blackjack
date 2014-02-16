package org.home.blackjack.domain.player;

import org.home.blackjack.domain.core.PlayerId;
import org.home.blackjack.domain.game.Game;

/**
 * An aggregate root of a single entity. It is eventually consistent with the
 * aggregated content of {@link Game} entities. From the state of a {@link Game}
 * instance, the result can be derived, so for any player the winNumber of
 * {@link PlayerRecord} should equal the number of {@link Game}-s she has won.
 * 
 * But eventual consistency is enough.
 * 
 * @author Mate
 * 
 */
public class PlayerRecord {

	private final PlayerId player;
	private int winNumber = 0;

	public PlayerRecord(PlayerId player) {
		this.player = player;
	}

	public void recordWin() {
		winNumber++;
	}

	public int getWinNumber() {
		return winNumber;
	}

	public PlayerId getPlayer() {
		return player;
	}

}