package com.jonaskaad.sevendwarfs;

import java.util.ArrayList;

import static com.jonaskaad.sevendwarfs.DwarfEnum.*;

public class HappyDwarf implements DwarfInterface{

    String name;
    DwarfEnum type;
    DwarfFacade facade = DwarfFacade.getInstance();

    public HappyDwarf() {
        name = "Happy";
        type = DwarfEnum.Happy;
    }

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
            reaction += "Happy is happy that everyone is gathered and savors the moment.\n";
        }
        else {
            switch (dwarfType) {
                case Grumpy -> {
                    reaction += "Happy seems to calm down Grumpy so they relax together.\n";
                    if (facade.checkDwarfNotInList(dwarfs, Sleepy)) {
                        reaction += "Grumpy eventually gets bored and decides to smash some plates.\n"
                                + "He accidentally wakes up Sleepy!\n";
                        dwarfs.add(facade.createDwarf(Sleepy));
                    } else if (facade.checkDwarfNotInList(dwarfs, Sneezy)) {
                        reaction += "Grumpy eventually decides to jump around a bit.\n"
                                + "This causes Sneezy to come in and tell him to stop!\n";
                        dwarfs.add(facade.createDwarf(Sneezy));
                    }
                }
                case Sneezy -> {
                    reaction += "Happy is happy to see Sneezy, which makes Sneezy very excited\n";
                    if (facade.checkDwarfNotInList(dwarfs, Sleepy)) {
                        reaction += "Sneezy gets so excited that he sneezes way too loud, waking up Sleepy\n"
                                + "Sneezy gets embarrassed and flees for a moment\n";
                        dwarfs.remove(dwarfs.size()-1);
                        dwarfs.add(facade.createDwarf(Sleepy));
                    } else if ((facade.checkDwarfNotInList(dwarfs, Grumpy))) {
                        reaction += "Sneezy suddenly gets an itch which causes him to sneeze very loudly!\n"
                                + "This causes Grumpy to come running down the stairs yelling!\n";
                        dwarfs.add(facade.createDwarf(Grumpy));
                    }
                }
                case Sleepy -> {
                    reaction += "Happy watches Sleepy sleep and tries very carefully to not wake him up.\n";
                    if (facade.checkDwarfNotInList(dwarfs, Sneezy)) {
                        reaction += "He accidentally trips over Sleepy's shoes, which causes Sneezy to come running.\n";
                        dwarfs.add(facade.createDwarf(Sneezy));
                    } else if (dwarfs.size() <= 3 && facade.checkDwarfNotInList(dwarfs, Grumpy)) {
                        reaction += "However, the silences is broken when Grumpy comes stumbling down the stairs!";
                        dwarfs.add(facade.createDwarf(Grumpy));
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
