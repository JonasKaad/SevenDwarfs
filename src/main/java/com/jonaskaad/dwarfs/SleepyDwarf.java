package com.jonaskaad.dwarfs;

import java.util.ArrayList;
import static com.jonaskaad.dwarfs.DwarfEnum.*;

public class SleepyDwarf implements DwarfInterface{

    String name;
    DwarfEnum type;

    public SleepyDwarf(){
        name = "Sleepy";
        type = DwarfEnum.Sleepy;
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
            reaction += "Sleepy notices that everyone else has calmed down and goes back to sleep.\n";
        }
        else {
            switch (dwarfType) {
                case Grumpy -> {
                    reaction += "Sleepy quickly pretends to sleep, since he notices that Grumpy is here.\n";
                    if (facade.checkDwarfNotInList(dwarfs, Sneezy)) {
                        reaction += "Since Grumpy is bored he tries to wake up Sleepy, but ends up waking Sneezy.\n"
                                + "Sneezy starts to complain, since he was having a great nap.\n";
                        dwarfs.add(facade.createDwarf(Sneezy));
                    } else if (facade.checkDwarfNotInList(dwarfs, Happy)) {
                        reaction += "Grumpy feels bored and starts arguing with the sleeping Sleepy.\n"
                                + "Happy notices this from the outside, and rushes in to tell him to stop.\n";
                        dwarfs.add((facade.createDwarf(Happy)));
                    }
                }
                case Happy -> {
                    reaction += "Sleepy is fast asleep in his bed.\n";
                    if (facade.checkDwarfNotInList(dwarfs, Sneezy)) {
                        reaction += "Happy sits down on a chair and waits.\n"
                                + "Eventually he gets bored and leaves. Sneezy notices that Sleepy is all alone and joins him! \n";
                        dwarfs.remove(dwarfs.size()-1);
                        dwarfs.add(facade.createDwarf(Sneezy));
                    } else if (facade.checkDwarfNotInList(dwarfs, Grumpy)) {
                        reaction += "Happy is sitting in the corner waiting for something to happen.\n"
                                + "Suddenly Grumpy bursts in and makes a ruckus\n";
                        dwarfs.add(facade.createDwarf(Grumpy));
                    }
                }
                case Sneezy -> {
                    reaction += "Sleepy is happily sleeping in his bed, slowly waking up.\n";
                    if (facade.checkDwarfNotInList(dwarfs, Grumpy)) {
                        reaction += "Sneezy accidentally lets out a huge Sneezy.\n"
                                + "Not only is Sleepy woken up, but Grumpy comes running down the stairs yelling!\n";
                        dwarfs.add(facade.createDwarf(Grumpy));
                    }

                    else if (facade.checkDwarfNotInList(dwarfs, Happy)) {
                        reaction += "Sneezy accidentally lets out a huge sneeze.\n"
                                +"This makes Sleepy annoyed, and causes him to yell at Sneezy.\n"
                                +"Happy tries to intervene and stop the arguing.\n";
                        dwarfs.add(facade.createDwarf(Happy));
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
