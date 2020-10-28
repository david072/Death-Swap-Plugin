package commands;

import org.bukkit.entity.Player;

public interface CommandFunction {

    void execute(Player sender, String[] args);

}
