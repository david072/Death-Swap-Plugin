package commands;

import deathSwap.DeathSwap;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import util.Messages;

public class ForceSwapCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(DeathSwap.swaps.isEmpty()) return true;

            Bukkit.broadcastMessage(Messages.SWAP_FORCED.replace("%forcer%", player.getDisplayName()));
            DeathSwap.tenSecCountdown();
        }

        return true;
    }

}
