package com.jonaskaad.dwarfs;

import java.util.ArrayList;

import static com.jonaskaad.dwarfs.DwarfEnum.*;

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
    public void reactToDwarf(DwarfEnum dwarfType, ArrayList<DwarfInterface> dwarfs) {
        switch (dwarfType) {
            case Grumpy -> {
                System.out.println("Happy seems to calm down Grumpy so they relax together.");
                if(facade.checkDwarfNotInList(dwarfs, Sleepy)){
                    System.out.println("Grumpy eventually gets bored and decides to smash some plates.");
                    System.out.println("He accidentally wakes up Sleepy!");
                    dwarfs.add(facade.createDwarf(Sleepy));
                }
                else if(facade.checkDwarfNotInList(dwarfs, Sneezy)){
                    System.out.println("Grumpy eventually decides to jump around a bit.");
                    System.out.println("This causes Sneezy to come in and tell him to stop!");
                    dwarfs.add(facade.createDwarf(Sneezy));
                }
            }
            case Sneezy -> {
                System.out.println("Happy is happy to see Sneezy, which makes Sneezy very excited");
                if(facade.checkDwarfNotInList(dwarfs, Sleepy)){
                    System.out.println("Sneezy gets so excited that he sneezes way too loud, waking up Sleepy");
                    dwarfs.add(facade.createDwarf(Sleepy));
                }
                else if((facade.checkDwarfNotInList(dwarfs, Grumpy))){
                    System.out.println("Sneezy suddenly gets an itch which causes him to sneeze very loudly!");
                    System.out.println("This causes Grumpy to come running down the stairs yelling!");
                    dwarfs.add(facade.createDwarf(Grumpy));
                }
            }
            case Sleepy -> {
                System.out.println("Happy watches Sleepy sleep and tries very carefully to not wake him up.");
                if(facade.checkDwarfNotInList(dwarfs, Sneezy)){
                    System.out.println("He accidentally trips over Sleepy's shoes, which causes Sneezy to come running.");
                    dwarfs.add(facade.createDwarf(Sneezy));
                }
                else if(dwarfs.size() <= 3 && facade.checkDwarfNotInList(dwarfs, Grumpy)){
                    System.out.println("Happy thinks that Sleepy has slept for too long, so he yells loudly to wake him.");
                    System.out.println("However, he accidentally disturbs Grumpy, which causes him to come stumbling down the stairs");
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
