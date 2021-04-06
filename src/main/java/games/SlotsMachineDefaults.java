package games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlotsMachineDefaults {

    public static final Symbol CHERRY = new Symbol("Cherry",'C',1, true);
    public static final Symbol LEMON = new Symbol("Lemon",'L',1, true);
    public static final Symbol MELON = new Symbol("Melon",'M',1, true);
    public static final Symbol SEVENS = new Symbol("Seven",'7',7, false);
    public static final Symbol BAR = new Symbol("Bar",'B',10, false);

    public static final List<Symbol> SYMBOLS = Arrays.asList(CHERRY,LEMON,MELON,SEVENS,BAR);
}
