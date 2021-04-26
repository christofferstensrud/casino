package games.slot;

import java.util.Arrays;
import java.util.List;

public class SlotDefaults {

    private static final SlotSymbol CHERRY = new SlotSymbol("Cherry","/CHERRY.PNG",3, true);
    private static final SlotSymbol LEMON = new SlotSymbol("Lemon","/LEMON.PNG",3, true);
    private static final SlotSymbol MELON = new SlotSymbol("Melon","/MELON.PNG",3, true);

    private static final SlotSymbol BELL = new SlotSymbol("Bell","",10, true);

    static final SlotSymbol SEVENS = new SlotSymbol("Seven","/SEVENS.PNG",17, false);
    static final SlotSymbol BAR = new SlotSymbol("Bar","/BAR.PNG",50, false);

    static final List<SlotSymbol> SLOTS_SYMBOLS = Arrays.asList(CHERRY,LEMON,MELON,SEVENS,BAR);
}
