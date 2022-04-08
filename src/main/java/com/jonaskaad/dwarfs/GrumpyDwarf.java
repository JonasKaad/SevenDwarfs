package com.jonaskaad.dwarfs;

import java.util.ArrayList;
import static com.jonaskaad.dwarfs.DwarfEnum.*;

public class GrumpyDwarf implements DwarfInterface{
    String name;
    DwarfEnum type;

    public GrumpyDwarf(){
        name = "Grumpy";
        type = DwarfEnum.Grumpy;
    }
    DwarfFacade facade = DwarfFacade.getInstance();

    @Override
    public DwarfEnum getType() {
        return type;
    }
    @Override
    public String getDwarfName() {
        return name;
    }

    @Override
    public void reactToDwarf(DwarfEnum dwarfType, ArrayList<DwarfInterface> dwarfs) {
        switch (dwarfType) {
            case Sleepy -> {
                System.out.println("Grumpy gets angry that Sleepy never does his chores and decides to jump around his bed.");
                if(facade.checkDwarfNotInList(dwarfs, Sneezy)){
                    System.out.println("This causes Sneezy to come in and tell him to stop!");
                    dwarfs.add(facade.createDwarf(Sneezy));
                }
                else if(facade.checkDwarfNotInList(dwarfs, Happy)){
                    System.out.println("Happy gets angry that Grumpy is trying to wake up Sleepy and rushes in to stop him.");
                    dwarfs.add(facade.createDwarf(Happy));
                }
            }
            case Happy -> {
                System.out.println("Grumpy likes Happy, so he calms down a little.");
                if(dwarfs.size() == 2 && facade.checkDwarfNotInList(dwarfs, Sleepy)){
                        System.out.println("Grump eventually gets a little bored and decides to start dancing.");
                        System.out.println("He acycidentally wakes up Sleepy.");
                        dwarfs.add(facade.createDwarf(Sleepy));
                }
                else if(facade.checkDwarfNotInList(dwarfs, Sneezy)){
                    System.out.println("Grumpy begins complaining about the food from yesterday.");
                    System.out.println("Sneezy, who was the cook yesterday, scolds Grumpy!");
                    dwarfs.add(facade.createDwarf(Sneezy));
                }
            }
            case Sneezy -> System.out.println("Grumpy laughs at Sneezy and tells him to stop complaining.");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
