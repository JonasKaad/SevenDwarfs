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
    public String reactToDwarf(DwarfEnum dwarfType, ArrayList<DwarfInterface> dwarfs, int numberOfEvents) {
        String reaction = "";
        // If last in list:
        if(numberOfEvents == 3){
            reaction += "Grumpy realizes that he has been grumpy all day, and calms down." + "\n";
        }
        else {
            switch (dwarfType) {
                case Sleepy -> {
                    reaction += "Grumpy gets angry that Sleepy never does his chores and decides to jump around his bed.\n";
                    if (facade.checkDwarfNotInList(dwarfs, Sneezy)) {
                        reaction += "This causes Sneezy to come in and tell him to stop!\n" +
                        "However it also makes Sleepy go back to bed!\n";
                        dwarfs.remove(dwarfs.size()-1);
                        dwarfs.add(facade.createDwarf(Sneezy));
                    } else if (facade.checkDwarfNotInList(dwarfs, Happy)) {
                        reaction += "Happy gets angry that Grumpy is trying to wake up Sleepy and rushes in to stop him.\n";
                        dwarfs.add(facade.createDwarf(Happy));
                    }
                }
                case Happy -> {
                    reaction += "Grumpy likes Happy, so he calms down a little.\n";
                    if (facade.checkDwarfNotInList(dwarfs, Sleepy)) {
                        reaction += "Grumpy eventually gets a little bored and decides to start dancing.\n"
                                + "He accidentally wakes up Sleepy, who goes to sleep again.\n";
                        dwarfs.add(facade.createDwarf(Sleepy));
                    } else if (facade.checkDwarfNotInList(dwarfs, Sneezy)) {
                        reaction += "Grumpy begins complaining about the food from yesterday.\n"
                                + "Sneezy, who was the cook yesterday, scolds Grumpy!\n";
                        dwarfs.add(facade.createDwarf(Sneezy));
                    }
                }
                case Sneezy -> {
                    reaction += "Grumpy yells at Sneezy for sneezing all the time.\n";
                    if (facade.checkDwarfNotInList(dwarfs, Happy)) {
                        reaction += "Happy comes into the room and tells him to stop yelling!\n";
                        dwarfs.add(facade.createDwarf(Happy));
                    } else if (facade.checkDwarfNotInList(dwarfs, Sleepy)) {
                        reaction += "Sleepy wakes up from all the yelling!\n";
                        dwarfs.add(facade.createDwarf(Sleepy));
                    }
                }
            }
        }
        return reaction;
    }

    @Override
    public String toString() {
        return name;
    }
}
