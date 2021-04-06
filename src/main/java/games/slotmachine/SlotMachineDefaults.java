package games.slotmachine;

import games.slotmachine.SlotSymbol;

import java.util.Arrays;
import java.util.List;

public class SlotMachineDefaults {

    private static final SlotSymbol CHERRY = new SlotSymbol("Cherry",'C',1, true);
    private static final SlotSymbol LEMON = new SlotSymbol("Lemon",'L',1, true);
    private static final SlotSymbol MELON = new SlotSymbol("Melon",'M',1, true);

    static final SlotSymbol SEVENS = new SlotSymbol("Seven",'7',7, false);
    static final SlotSymbol BAR = new SlotSymbol("Bar",'B',10, false);

    static final List<SlotSymbol> SLOTS_SYMBOLS = Arrays.asList(CHERRY,LEMON,MELON,SEVENS,BAR);
}
