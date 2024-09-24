import java.util.LinkedList;
import java.util.Scanner;

record Place(String name, int distance){
    @Override
    public String toString(){
        return String.format("%s (%d)", name, distance);
    }
}

public class LinkedList2 {

    public static void main(String[] args) {

        LinkedList<Place> placesToVisit = new LinkedList<>();

        Place noida = new Place("Noida", 10);
        addPlace(placesToVisit,noida);
        addPlace(placesToVisit, new Place("GZB", 25));
        addPlace(placesToVisit, new Place("Jaipur", 250));
        addPlace(placesToVisit, new Place("Agra", 300));
        addPlace(placesToVisit, new Place("Mathura", 170));
        addPlace(placesToVisit, new Place("Haridwar", 400));
        addPlace(placesToVisit, new Place("Kashmir", 1000));
        placesToVisit.addFirst(new Place("New Delhi", 0));

        System.out.println(placesToVisit);

        var iterator = placesToVisit.listIterator();
        Scanner sc = new Scanner(System.in);
        boolean quitLoop = false;
        boolean forward = true;

        printActions();

        while (!quitLoop){
            if (!iterator.hasPrevious()){
                System.out.println("Originating: " + iterator.next());
                forward = true;
            }
            if (!iterator.hasNext()){
                System.out.println("Final: " + iterator.previous());
                forward = false;
            }
            System.out.print("Enter Value: ");
            String menuItem = sc.nextLine().toUpperCase().substring(0,1);

            switch (menuItem){
                case "F":
                    System.out.println("User wants to go forward");
                    if (!forward){
                        forward = true;
                        if(iterator.hasNext()){
                            iterator.next();
                        }
                    }
                    if (iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                     break;
                case "B":
                    System.out.println("User wants to go Backwards");
                    if (forward){
                        forward = false;
                        if(iterator.hasPrevious()){
                            iterator.previous();
                        }
                    }
                    if (iterator.hasPrevious()){
                        System.out.println(iterator.previous());
                    }
                    break;
                case "M":
                    printActions();
                    break;
                case "L":
                    System.out.println(placesToVisit);
                    break;
                default:
                    quitLoop = true;
                    break;
            }
        }



    }

    private static void addPlace(LinkedList<Place> list, Place place){
        if (list.contains(place)){
            System.out.println("Found duplicate: " + place);
            return;
        }
        for (Place p: list){
            if (p.name().equalsIgnoreCase(place.name())){
                System.out.println("Found duplicate: " + place);
            }
        }

        int matchIndex = 0;
        for (var listPlace: list){
            if(place.distance() < listPlace.distance()){
                list.add(matchIndex, place);
                return;
            }
            matchIndex++;
        }
        list.add(place);
    }

    private static void printActions(){
        String textBlock = """
                Available actions (Select word or letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (M)Menu
                (Q)uit
                """;
        System.out.print(textBlock + " ");
    }
}
