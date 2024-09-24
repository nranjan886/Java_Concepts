package Interface;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Mappable> mappables = new ArrayList<>();

        mappables.add(new Building("Taj Mahal", UsageType.GOVERNMENT));
        mappables.add(new Building("PVR", UsageType.ENTERTAINMENT));
        mappables.add(new Building("Eden Garden", UsageType.SPORTS));

        mappables.add(new UtilityLine("Collage St", UtilityType.FIRED_OPTIC));
        mappables.add(new UtilityLine("Olympic Blvd", UtilityType.WATER));


        for (var m : mappables){
            Mappable.mapIt(m);
        }
    }
}
