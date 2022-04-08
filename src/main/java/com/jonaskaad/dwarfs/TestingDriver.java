package com.jonaskaad.dwarfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TestingDriver {

    public static int[] getRandomNumbers(){
        Random random = new Random();
        int numberOfDwarfs = 4;
        int[] randomNumbers = new int[2];

        int rand1 = random.nextInt(0, numberOfDwarfs);
        int rand2 = random.nextInt(0, numberOfDwarfs);
        while(rand1 == rand2){
            //System.out.println("oh no   " + rand2);
            rand2 = random.nextInt(0, numberOfDwarfs);
        }

        randomNumbers[0] = rand1;
        randomNumbers[1] = rand2;
        return randomNumbers;
    }

    public static void main(String[] args) {
        DwarfFacade dwarfFacade = DwarfFacade.getInstance();

        DwarfInterface sleepyDwarf = dwarfFacade.createDwarf(DwarfEnum.Sleepy);
        DwarfInterface happyDwarf = dwarfFacade.createDwarf(DwarfEnum.Happy);
        DwarfInterface sneezyDwarf = dwarfFacade.createDwarf(DwarfEnum.Sneezy);
        DwarfInterface grumpyDwarf = dwarfFacade.createDwarf(DwarfEnum.Grumpy);

        DwarfInterface[] allDwarfs = {sleepyDwarf, happyDwarf, sneezyDwarf, grumpyDwarf};


        ArrayList<DwarfInterface> dwarfs = new ArrayList<>();

        int[] randomNumbers = getRandomNumbers();

        System.out.println(Arrays.toString(randomNumbers));

        dwarfs.add(allDwarfs[randomNumbers[0]]);
        dwarfs.add(allDwarfs[randomNumbers[1]]);
        //dwarfs.add(sneezyDwarf);
        //dwarfs.add(sleepyDwarf);


        for (int i = 0; i < dwarfs.size()-1; i++) {

            System.out.println(dwarfs);

            dwarfs.get(dwarfs.size()-2).reactToDwarf(dwarfs.get(dwarfs.size()-1).getType(), dwarfs);
        }

        /*
        System.out.println(dwarfs);

        dwarfs.get(dwarfs.size()-2).reactToDwarf(dwarfs.get(dwarfs.size()-1), dwarfs);

        System.out.println(dwarfs);

        dwarfs.get(dwarfs.size()-2).reactToDwarf(dwarfs.get(dwarfs.size()-1), dwarfs);
        dwarfs.get(dwarfs.size()-2).reactToDwarf(dwarfs.get(dwarfs.size()-1), dwarfs);
        dwarfs.get(dwarfs.size()-2).reactToDwarf(dwarfs.get(dwarfs.size()-1), dwarfs);
*/
    }
}
