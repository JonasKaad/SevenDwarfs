package com.jonaskaad.dwarfs;

import java.util.ArrayList;

public class DwarfFacade {
    private static DwarfFacade instance = null;

    public static DwarfFacade getInstance() {
        if (instance == null) {
            instance = new DwarfFacade();
        }
        return instance;
    }

    private DwarfFacade() {
    }

    //public enum DWARFS {SLEEPY, HAPPY, GRUMPY, SNEEZY}


    public boolean checkDwarfNotInList(ArrayList<DwarfInterface> dwarfs, DwarfEnum dwarfEnum){
        boolean dwarfNotInList = true;
        for (DwarfInterface d : dwarfs){
            if(d.getType() == dwarfEnum){
                dwarfNotInList = false;
            }
        }
        return dwarfNotInList;
    }


    public DwarfInterface createDwarf(DwarfEnum dwarf) {
        DwarfInterface currentDwarf = null;
        switch (dwarf) {
            case Sleepy -> currentDwarf = new SleepyDwarf();
            case Happy -> currentDwarf = new HappyDwarf();
            case Grumpy -> currentDwarf = new GrumpyDwarf();
            case Sneezy -> currentDwarf = new SneezyDwarf();
            default -> System.out.println("Unknown Dwarf");
        }
        return currentDwarf;
    }

    public DwarfEnum getDwarfType(DwarfInterface dwarf){
        return dwarf.getType();
    }
}
