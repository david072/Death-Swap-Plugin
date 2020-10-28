package deathSwap.invites;

import main.Main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import util.Constants;
import util.Messages;

import java.util.ArrayList;

public class InviteManager {

    public static ArrayList<Invite> invites = new ArrayList<>();

    public static void scheduleInvite(Player inviter, Player target) {
        Invite invite = new Invite(inviter, target);
        int taskID = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, invite.getTask(), Constants.INVITE_EXPIRE_DElAY);
        invite.setTaskID(taskID);
        invites.add(invite);

        target.sendMessage(Messages.INVITE_MSG_SEPERATOR);
        target.sendMessage(Messages.INVITE_TARGET_INFO_MSG.replace("%inviterName%", inviter.getDisplayName()));

        TextComponent message = new TextComponent(Messages.INVITE_TARGET_ACCEPT_MSG);
        message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ds accept " + inviter.getDisplayName()));
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Messages.INVITE_TARGET_ACCEPT_HOVER_MSG.replace("%inviterName%", inviter.getDisplayName())).create()));

        target.spigot().sendMessage(message);
        target.sendMessage(Messages.INVITE_MSG_SEPERATOR);

        inviter.sendMessage(Messages.INVITE_MSG_SEPERATOR);
        inviter.sendMessage(Messages.INVITE_INVITER_INFO_MSG.replace("%target%", target.getDisplayName()));
        inviter.sendMessage(Messages.INVITE_MSG_SEPERATOR);
    }

    public static void cancelInvite(Invite toRemove) {
        invites.remove(toRemove);
    }

}
