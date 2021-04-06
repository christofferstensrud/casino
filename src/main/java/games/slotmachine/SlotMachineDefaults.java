package games.slotmachine;

import games.slotmachine.SlotSymbol;

import java.util.Arrays;
import java.util.List;

public class SlotMachineDefaults {

    public static final SlotSymbol CHERRY = new SlotSymbol("Cherry",'C',1, true);
    public static final SlotSymbol LEMON = new SlotSymbol("Lemon",'L',1, true);
    public static final SlotSymbol MELON = new SlotSymbol("Melon",'M',1, true);
    public static final SlotSymbol SEVENS = new SlotSymbol("Seven",'7',7, false);
    public static final SlotSymbol BAR = new SlotSymbol("Bar",'B',10, false);

    public static final List<SlotSymbol> SLOTS_SYMBOLS = Arrays.asList(CHERRY,LEMON,MELON,SEVENS,BAR);
}
