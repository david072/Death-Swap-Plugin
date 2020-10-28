package deathSwap;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Swap {

    private final Player player1;
    private final Player player2;

    public Swap(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void swap() {
        Location locPlayer1 = player1.getLocation();
        player1.teleport(player2.getLocation());
        player2.teleport(locPlayer1);
    }

    public Player getPlayer1() {
        return player1;
    }
    public Player getPlayer2() {
        return player2;
    }
}
