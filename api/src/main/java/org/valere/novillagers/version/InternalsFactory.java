package org.valere.novillagers.version;

import org.valere.novillagers.abstraction.NoVillagerInternals;
import org.valere.novillagers.abstraction.NoVillager_1_15_R1;
import org.valere.novillagers.abstraction.NoVillager_1_16_R1;
import java.util.Arrays;

public class InternalsFactory {

    private static final NoVillagerInternals internals = new Internals<NoVillagerInternals>(Arrays.asList(
            NoVillager_1_15_R1.class,
            NoVillager_1_16_R1.class
    )).get();

    public static NoVillagerInternals get(){
        return internals;
    }
}