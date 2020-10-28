package util;

public class Constants {

    public static final int INVITE_EXPIRE_DElAY = 60 * 20;                                                  // -> sec * ticks
    public static final int SWAP_PLAYERS_DELAY = ((60 * 1) - 10) * 20;                                      // -> ((sec(per min) * min(Anz)) - 10 (-> 10 sec earlier because 10 sec countdown)) * ticks

}
