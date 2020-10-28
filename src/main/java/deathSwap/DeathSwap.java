package deathSwap;

import main.Main;
import org.bukkit.Bukkit;
import util.Constants;
import util.Messages;

import java.util.ArrayList;
import java.util.UUID;

public class DeathSwap {

    public static boolean isRunning = false;

    public static int taskID;
    public static int countdownTaskID;

    public static ArrayList<Swap> swaps = new ArrayList<>();

    public static void addSwap(Swap swap) {
        swaps.add(swap);
    }

    public static void startSwapping() {
        isRunning = true;
        taskID = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, DeathSwap::tenSecCountdown, Constants.SWAP_PLAYERS_DELAY);
    }

    public static void tenSecCountdown() {
        Bukkit.getScheduler().cancelTask(taskID);
        countdownTaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {

            private int seconds = 10;

            @Override
            public void run() {
                if(seconds == 0) {
                    Bukkit.broadcastMessage(Messages.SWAP_SWAPPNG_NOW);
                    swapPlayers();
                    Bukkit.getScheduler().cancelTask(countdownTaskID);
                }
                else {
                    Bukkit.broadcastMessage(Messages.SWAP_SWAPPING_IN.replace("%seconds%", Integer.toString(seconds)));
                }

                seconds--;
            }

        }, 0, 20);
    }

    public static void stopSwapping() {
        Bukkit.getScheduler().cancelTask(taskID);
        Bukkit.getScheduler().cancelTask(countdownTaskID);
    }

    public static void swapPlayers() {
        for(Swap swap : swaps) {
            if(!swap.getPlayer1().isOnline()) {
                swap.getPlayer2().sendMessage(Messages.SWAP_PLAYER_DISCONNECTED.replace("%otherPlayer%", swap.getPlayer1().getDisplayName()));
                swaps.remove(swap);

                if(swaps.isEmpty()) return;

                continue;
            }

            swap.swap();
        }

        startSwapping();
    }

    public static boolean isPlayerInSwap(UUID playerUUID) {
        for(Swap swap : swaps) {
            if(swap.getPlayer1().getUniqueId().equals(playerUUID) ||
                    swap.getPlayer2().getUniqueId().equals(playerUUID)) {
                return true;
            }
        }

        return false;
    }

}
