package com.jonaskaad.sevendwarfs;

import java.util.ArrayList;

public interface DwarfInterface {

    String getDwarfName();

    DwarfEnum getType();

    String reactToDwarf(DwarfEnum dwarfType, ArrayList<DwarfInterface> dwarfs, int numberOfEvents);
}
