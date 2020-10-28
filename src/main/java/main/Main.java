package main;

import commands.CommandListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        registerCommands();
    }

    private void registerCommands() {
        getCommand("ds").setExecutor(new CommandListener());
        getCommand("deathSwap").setExecutor(new CommandListener());
    }

}
