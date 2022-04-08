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
    public void reactToDwarf(DwarfEnum dwarfType, ArrayList<DwarfInterface> dwarfs) {
        switch (dwarfType) {
            case Grumpy -> {
                System.out.println("Sleepy quickly pretends to sleep, since he notices that Grumpy is here.");
                if(facade.checkDwarfNotInList(dwarfs, Sneezy)){
                    System.out.println("Since Grumpy is bored he tries to wake up Sleepy, but ends up waking Sneezy.");
                    System.out.println("Sneezy starts to complain, since he was having a great nap.");
                    dwarfs.add(facade.createDwarf(Sneezy));
                }
                else if(facade.checkDwarfNotInList(dwarfs, Happy)){
                    System.out.println("Grumpy feels bored and starts arguing with the sleeping Sleepy.");
                    System.out.println("Happy notices this from the outside, and rushes in to tell him to stop.");
                    dwarfs.add((facade.createDwarf(Happy)));
                }
            }
            case Happy -> {
                System.out.println("Sleepy is fast asleep in his bed.");
                if(facade.checkDwarfNotInList(dwarfs, Sneezy)){
                    System.out.println("Happy sits down on a chair and waits.");
                    System.out.println("Sneezy notices that Happy is sitting by himself, so he joins him!");
                    dwarfs.add(facade.createDwarf(Sneezy));
                }
                else if(facade.checkDwarfNotInList(dwarfs, Grumpy)){
                    System.out.println("Happy is sitting in the corner waiting for something to happen.");
                    System.out.println("Suddenly Grumpy bursts in and makes a ruckus");
                    dwarfs.add(facade.createDwarf(Grumpy));
                }
            }
            case Sneezy -> {
                System.out.println("Sleepy is happily sleeping in his bed, slowly waking up.");
                System.out.println("But suddenly, Sneezy sneezes so loud that he wakes up Sleepy!");
                if(facade.checkDwarfNotInList(dwarfs, Happy)){
                    System.out.println("This makes Sleepy annoyed, and causes him to yell at Sneezy.");
                    System.out.println("Happy tries to intervene and stop the arguing.");
                    dwarfs.add(facade.createDwarf(Happy));
                }
                else if(facade.checkDwarfNotInList(dwarfs, Grumpy)){
                    System.out.println("Not only is Sleepy woken up, but Grumpy comes running down the stairs yelling!");
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
