package games.slot;

import java.util.Arrays;
import java.util.List;

public class SlotDefaults {

    private static final SlotSymbol CHERRY = new SlotSymbol("Cherry",'C',3, true);
    private static final SlotSymbol LEMON = new SlotSymbol("Lemon",'L',3, true);
    private static final SlotSymbol MELON = new SlotSymbol("Melon",'M',3, true);

    private static final SlotSymbol BELL = new SlotSymbol("Bell",'B',10, true);

    static final SlotSymbol SEVENS = new SlotSymbol("Seven",'7',17, false);
    static final SlotSymbol BAR = new SlotSymbol("Bar",'B',50, false);

    static final List<SlotSymbol> SLOTS_SYMBOLS = Arrays.asList(CHERRY,LEMON,MELON,SEVENS,BAR);
}
