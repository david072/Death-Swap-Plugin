package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import util.Messages;

public class CommandListener implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player sender = (Player) commandSender;

            boolean commandFound = false;
            for(Commands commandsInstance : Commands.values()) {
                if(commandsInstance.getActivationWord().equalsIgnoreCase(strings[0])) {
                    commandFound = true;
                    commandsInstance.getFunction().execute(sender, strings);
                }
            }

            if(!commandFound) {
                sender.sendMessage(Messages.COMMAND_NOT_EXISTING.replace("%cmdName%", strings[0]));
            }
        }

        return true;
    }

}