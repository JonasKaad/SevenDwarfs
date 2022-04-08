package com.jonaskaad.dwarfs;

import java.util.ArrayList;

interface DwarfInterface {

    String getDwarfName();

    DwarfEnum getType();

    void reactToDwarf(DwarfEnum dwarfType, ArrayList<DwarfInterface> dwarfs);
}
