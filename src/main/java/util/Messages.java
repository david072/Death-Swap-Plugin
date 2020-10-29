package util;

public class Messages {

    public static final String COMMAND_NOT_EXISTING = "§cThere is no command called §b%cmdName%§c!";

    // -------------------------------
    // --- Invite command messages ---
    public static final String INVITE_PLAYER_NOT_ONLINE = "§cYou can't invite that player since they're not online!";
    public static final String INVITE_INVITER_NOT_ONLINE = "§cThat player could not be found. They most likely logged off.";
    public static final String INVITE_NOT_ENOUGH_ARGUMENTS = "§cPlease use §b/ds invite [Player name] §cto invite other players to your Death Swap.";
    public static final String INVITE_CANT_INVITE_SELF = "§cYou can't invite yourself to a Death Swap!";
    public static final String INVITE_TARGET_ALREADY_IN_SWAP = "§cYou can't invite that player since they're already in a Death Swap!";
    public static final String INVITE_INVITER_ALREADY_IN_SWAP = "§cYou can't invite other players since you're already in a Death Swap!";

    public static final String INVITE_EXPIRED_INVITER = "§cYour Death Swap invite to §b%target% §cexpired!";
    public static final String INVITE_EXPIRED_TARGET = "§cThe Death Swap invite from §b%inviter% §cexpired!";

    public static final String INVITE_MSG_SEPERATOR = "§1=========================";
    public static final String INVITE_TARGET_INFO_MSG = "§b%inviterName% §ehas invited you to their Death Swap.";
    public static final String INVITE_INVITER_INFO_MSG = "§eYou invited §b%target% §eto your Death Swap. They have §c60 §eseconds to accept.";

    public static final String INVITE_TARGET_ACCEPT_MSG = "§eYou have §c60 §eseconds to accept. §6Click here to join.";
    public static final String INVITE_TARGET_ACCEPT_HOVER_MSG = "Click here to run\n/ds accept %inviterName%";

    public static final String INVITE_SUCCESS = "§B%target% §ejoined the Death Swap!";
    // -------------------------------

    // ---------------------------
    // --- Death Swap messages ---
    public static final String SWAP_PLAYER_DISCONNECTED = "§b%otherPlayer% §ccould not be found. They most likely logged off. Your Death Swap is now going to be deleted!";

    public static final String SWAP_SWAP_STARTED = "§b%starter% §estarted the Death Swap!";
    public static final String SWAP_SWAP_STOPPED = "§b%stopper% §estopped the Death Swap!";

    public static final String SWAP_SWAPPING_IN = "§eSwapping in §c%seconds%§e!";
    public static final String SWAP_SWAPPNG_NOW = "§cSwapping now...";

    public static final String SWAP_FORCED = "§b%forcer% §eforced a swap!";
    // ---------------------------

}