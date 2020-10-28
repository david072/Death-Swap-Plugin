package deathSwap.invites;

import org.bukkit.entity.Player;
import util.Messages;

public class Invite {

    private final Player inviter;
    private final Player target;

    private final Runnable task;
    private int taskID;

    public Invite(Player inviter, Player target) {
        this.inviter = inviter;
        this.target = target;

        task = () -> {
            inviter.sendMessage(Messages.INVITE_MSG_SEPERATOR);
            inviter.sendMessage(Messages.INVITE_EXPIRED_INVITER.replace("%target%", target.getDisplayName()));
            inviter.sendMessage(Messages.INVITE_MSG_SEPERATOR);

            target.sendMessage(Messages.INVITE_MSG_SEPERATOR);
            target.sendMessage(Messages.INVITE_EXPIRED_TARGET.replace("%inviter%", inviter.getDisplayName()));
            target.sendMessage(Messages.INVITE_MSG_SEPERATOR);

            InviteManager.cancelInvite(this);
        };
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public Player getInviter() {
        return inviter;
    }
    public Player getTarget() {
        return target;
    }
    public Runnable getTask() {
        return task;
    }
    public int getTaskID() {
        return taskID;
    }
}
