package com.jonaskaad.dwarfs;

import java.util.ArrayList;
import static com.jonaskaad.dwarfs.DwarfEnum.*;

public class SneezyDwarf implements DwarfInterface{

    String name;
    DwarfEnum type;

    public SneezyDwarf() {
        name = "Sneezy";
        type = DwarfEnum.Sneezy;
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
            case Grumpy -> {
                System.out.println("Sneezy apologizes to Grumpy immediately!");
                if(facade.checkDwarfNotInList(dwarfs, Happy)){
                    System.out.println("Happy feels bad for Sneezy and comes in to help deescalate the situation!");
                    dwarfs.add(facade.createDwarf(Happy));
                }
                else if(facade.checkDwarfNotInList(dwarfs, Sleepy)) {
                    System.out.println("All the yelling from the argument wakes up Sleepy!");
                    dwarfs.add(facade.createDwarf(Sleepy));
                }
            }
            case Happy -> {
                System.out.println("Sneezy and Happy starts dancing around together!");
                if(facade.checkDwarfNotInList(dwarfs, Sleepy)){
                    System.out.println("This wakes up Sleepy for moment, who then goes back to sleep.");
                    dwarfs.add(facade.createDwarf(Sleepy));
                }
                else if(facade.checkDwarfNotInList(dwarfs, Grumpy)){
                    System.out.println("Grumpy decides to join them!");
                    dwarfs.add(facade.createDwarf(Grumpy));
                }
            }
            case Sleepy -> {
                System.out.println("Sneezy immediately apologizes for waking up Sleepy!");
                if(facade.checkDwarfNotInList(dwarfs, Grumpy)){
                    System.out.println("Grumpy notices that an argument is taking place and wants to join in!");
                    dwarfs.add(facade.createDwarf(Grumpy));
                }
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }

}
