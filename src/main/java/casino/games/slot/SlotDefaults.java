package casino.games.slot;

import java.util.Arrays;
import java.util.List;

public class SlotDefaults {

    private static final SlotSymbol CHERRY = new SlotSymbol("Cherry", "/images/CHERRY.PNG",4, true);
    private static final SlotSymbol LEMON = new SlotSymbol("Lemon", "/images/LEMON.PNG",4, true);
    private static final SlotSymbol MELON = new SlotSymbol("Melon", "/images/MELON.PNG",4, true);

    private static final SlotSymbol BELL = new SlotSymbol("Bell","/images/BELL.PNG",10, true);

    private static final SlotSymbol SEVENS = new SlotSymbol("Seven", "/images/SEVENS.PNG",17, false);
    private static final SlotSymbol BAR = new SlotSymbol("Bar", "/images/BAR.PNG",50, false);

    static final List<SlotSymbol> SLOTS_SYMBOLS = Arrays.asList(CHERRY,LEMON,MELON,SEVENS,BAR);
}
