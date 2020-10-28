package commands;

import deathSwap.DeathSwap;
import deathSwap.Swap;
import deathSwap.invites.Invite;
import deathSwap.invites.InviteManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import util.Messages;

public class CommandExecutors {

    public static void inviteCommand(Player sender, String[] args) {
        if(args.length < 2) {
            sender.sendMessage(Messages.INVITE_NOT_ENOUGH_ARGUMENTS);
            return;
        }

        if(DeathSwap.isPlayerInSwap(sender.getUniqueId())) {
            sender.sendMessage(Messages.INVITE_INVITER_ALREADY_IN_SWAP);
            return;
        }

        Player player = Bukkit.getPlayer(args[1]);
        if(player == null) {
            sender.sendMessage(Messages.INVITE_PLAYER_NOT_ONLINE);
        }
        else {
            if(sender.getUniqueId().equals(player.getUniqueId())) {
                sender.sendMessage(Messages.INVITE_CANT_INVITE_SELF);
                return;
            }

            if(DeathSwap.isPlayerInSwap(player.getUniqueId())) {
                sender.sendMessage(Messages.INVITE_TARGET_ALREADY_IN_SWAP);
                return;
            }

            InviteManager.scheduleInvite(sender, player);
        }
    }

    public static void acceptCommand(Player sender, String[] args) {
        Player inviter = Bukkit.getPlayer(args[1]);
        if(inviter == null) {
            sender.sendMessage(Messages.INVITE_INVITER_NOT_ONLINE);
        }
        else {
            if(InviteManager.invites.isEmpty()) return;

            for(Invite invite : InviteManager.invites) {
                if(invite.getTarget() == sender) {
                    if(invite.getInviter() == inviter) {
                        Bukkit.getScheduler().cancelTask(invite.getTaskID());
                        Swap swap = new Swap(inviter, sender);
                        DeathSwap.addSwap(swap);
                        InviteManager.cancelInvite(invite);

                        sender.sendMessage(Messages.INVITE_MSG_SEPERATOR);
                        sender.sendMessage(Messages.INVITE_SUCCESS.replace("%target%", sender.getDisplayName()));
                        sender.sendMessage(Messages.INVITE_MSG_SEPERATOR);

                        inviter.sendMessage(Messages.INVITE_MSG_SEPERATOR);
                        inviter.sendMessage(Messages.INVITE_SUCCESS.replace("%target%", sender.getDisplayName()));
                        inviter.sendMessage(Messages.INVITE_MSG_SEPERATOR);

                        break;
                    }
                }
            }
        }
    }

    public static void startSwapping(Player sender, String[] args) {
        if(!DeathSwap.isRunning) {
            DeathSwap.startSwapping();
            Bukkit.broadcastMessage(Messages.SWAP_SWAP_STARTED.replace("%starter%", sender.getDisplayName()));
        }
    }

    public static void stopSwapping(Player sender, String[] args) {
        if(DeathSwap.isRunning) {
            DeathSwap.stopSwapping();
            Bukkit.broadcastMessage(Messages.SWAP_SWAP_STOPPED.replace("%stopper%", sender.getDisplayName()));
        }
    }

}
