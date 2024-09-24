package Generic;

import java.util.ArrayList;
import java.util.List;

public class Layer <T extends Mappable>{

    private List<T> layerElemets;

    public Layer(T[] layerElemets) {
        this.layerElemets = new ArrayList<T>(List.of(layerElemets));
    }

    public void addElements(T... elements){
        layerElemets.addAll(List.of(elements));
    }

    public void renderLayer(){
        for (T element : layerElemets){
            element.render();
        }
    }
}
