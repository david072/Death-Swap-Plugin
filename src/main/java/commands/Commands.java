package commands;

public enum Commands {

    INVITE_COMMAND("invite", CommandExecutors::inviteCommand),
    INVITE_ACCEPT_COMMAND("accept", CommandExecutors::acceptCommand),

    SWAP_STARTSWAPPING_COMMAND("start", CommandExecutors::startSwapping),
    SWAP_STOPSWAPPING_COMMAND("stop", CommandExecutors::stopSwapping);

    private final String activationWord;
    private final CommandFunction function;

    Commands(String activationWord, CommandFunction function)  {
        this.activationWord = activationWord;
        this.function = function;
    }

    public String getActivationWord() {
        return activationWord;
    }

    public CommandFunction getFunction() {
        return function;
    }

}
