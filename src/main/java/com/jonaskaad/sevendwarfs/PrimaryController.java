package com.jonaskaad.sevendwarfs;

import com.jonaskaad.sevendwarfs.DwarfEnum;
import com.jonaskaad.sevendwarfs.DwarfFacade;
import com.jonaskaad.sevendwarfs.DwarfInterface;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URISyntaxException;
import java.util.*;

public class PrimaryController {
    @FXML
    private TextArea textArea;
    @FXML
    private Button nextEventButton;
    @FXML
    private ImageView imageView1;
    @FXML
    private ImageView imageView2;
    @FXML
    private ImageView imageView3;
    @FXML
    private ImageView imageView4;

    int counter;
    int[] dwarfSelection;
    Map<DwarfEnum, Image> dwarfMap;

    List<DwarfInterface> listOfAllDwarfs;
    ArrayList<DwarfInterface> dwarfs;
    DwarfFacade facade = DwarfFacade.getInstance();
    String incoming;
    String current;

    @FXML
    public void initialize() {
        nextEventButton.setDisable(false);
        listOfAllDwarfs = new ArrayList<>();
        dwarfs = new ArrayList<>();
        counter = 0;
        dwarfMap = new HashMap<>();
        current = "";
        incoming = "start";
        for (DwarfEnum d : DwarfEnum.values()) {
            listOfAllDwarfs.add(facade.createDwarf(d));
        }

        dwarfSelection = getRandomDwarfs();

        for (DwarfInterface d : listOfAllDwarfs){
            String filename = d.getDwarfName() + ".png";
            try {
                dwarfMap.put(d.getType(), new Image(getClass().getResource(filename).toURI().toString()));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

        dwarfs.add(listOfAllDwarfs.get(dwarfSelection[0]));
        dwarfs.add(listOfAllDwarfs.get(dwarfSelection[1]));

        imageView1.setImage(dwarfMap.get(dwarfs.get(0).getType()));
        imageView2.setImage(dwarfMap.get(dwarfs.get(1).getType()));
        textArea.appendText(dwarfs + "\n");
    }

    @FXML
    protected void getNextEvent() {
        DwarfInterface dwarfThatIsReacting = dwarfs.get(counter);
        DwarfInterface dwarfReactedTo = dwarfs.get(dwarfs.size()-1);

        int before = dwarfs.size();
        incoming = dwarfThatIsReacting.reactToDwarf(dwarfReactedTo.getType(), dwarfs, counter);
        int after = dwarfs.size();

        if(counter < 3){
            counter++;
        }

        if(current.equals(incoming)){
            nextEventButton.setDisable(true);
            textArea.appendText("\n \n \n" + "=== Event Done. Press Reset to try again ===");
        }
        else{
            textArea.appendText(incoming + "\n");
            current = incoming;
            textArea.appendText(dwarfs + "\n");

        }

        for (int i = 0; i < dwarfs.size(); i++) {
            if(i == 0){
                imageView1.setImage(dwarfMap.get(dwarfs.get(i).getType()));
            }
            else if(i == 1){
                imageView2.setImage(dwarfMap.get(dwarfs.get(i).getType()));
            }
            else if(i == 2){
                imageView3.setImage(dwarfMap.get(dwarfs.get(i).getType()));
            }
            else if(i == 3){
                imageView4.setImage(dwarfMap.get(dwarfs.get(i).getType()));
            }
        }

        if(before == after && dwarfs.size() != 4) {
            counter--;
        }
    }

    @FXML
    private void reset(){
        dwarfs.clear();
        imageView1.setImage(null);
        imageView2.setImage(null);
        imageView3.setImage(null);
        imageView4.setImage(null);
        textArea.clear();
        initialize();
        getRandomDwarfs();
    }


    public int[] getRandomDwarfs(){
        Random random = new Random();
        int numberOfDwarfs = listOfAllDwarfs.size();
        int[] randomNumbers = new int[2];
        int firstNumber = random.nextInt(0, numberOfDwarfs);
        int seconderNumber = random.nextInt(0, numberOfDwarfs);
        while(firstNumber == seconderNumber){
            seconderNumber = random.nextInt(0, numberOfDwarfs);
        }

        randomNumbers[0] = firstNumber;
        randomNumbers[1] = seconderNumber;
        return randomNumbers;
    }
}