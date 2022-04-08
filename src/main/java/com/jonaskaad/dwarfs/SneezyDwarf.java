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
    public String reactToDwarf(DwarfEnum dwarfType, ArrayList<DwarfInterface> dwarfs, int numberOfEvents) {
        String reaction = "";
        // If last in list:

        if(numberOfEvents == 3){
            reaction += "Sneezy has finally gotten his sneezing under control and relaxes a bit.\n";
        }
        else {
            switch (dwarfType) {
                case Grumpy -> {
                    if (dwarfs.size() == 2) {
                        reaction += "Sneezy lets out a huge sneeze!\n";
                    }
                    reaction += "Sneezy apologizes to Grumpy immediately!\n";

                    if (facade.checkDwarfNotInList(dwarfs, Happy)) {
                        reaction += "Happy feels bad for Sneezy and comes in to help deescalate the situation!\n"
                                + "Grumpy goes outside for some fresh air.\n";
                        dwarfs.remove(dwarfs.size()-1);
                        dwarfs.add(facade.createDwarf(Happy));

                    }
                     else if (facade.checkDwarfNotInList(dwarfs, Sleepy)) {
                        reaction += "All the yelling from the argument wakes up Sleepy!\n";
                        dwarfs.add(facade.createDwarf(Sleepy));
                    }
                }
                case Happy -> {
                    reaction += "Sneezy and Happy starts dancing around together!\n";
                    if (facade.checkDwarfNotInList(dwarfs, Sleepy)) {
                        reaction += "This wakes up Sleepy for moment, who then goes back to sleep.\n";
                        dwarfs.add(facade.createDwarf(Sleepy));
                    }
                    else if (facade.checkDwarfNotInList(dwarfs, Grumpy)) {
                        reaction += "Grumpy decides to join them!\n";
                        dwarfs.add(facade.createDwarf(Grumpy));
                    }
                }
                case Sleepy -> {
                    reaction += "Sneezy immediately apologizes for waking up Sleepy!\n";
                    if (facade.checkDwarfNotInList(dwarfs, Grumpy)) {
                        reaction += "Grumpy notices that an argument is taking place and wants to join in!\n";
                        dwarfs.add(facade.createDwarf(Grumpy));
                    } else if (facade.checkDwarfNotInList(dwarfs, Happy)) {
                        reaction += "Happy comes into the room and tries to stop them from complaining!\n";
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
