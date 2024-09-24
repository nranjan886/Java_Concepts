package SetandMap;

import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Treeset {
    public static void main(String[] args) {

        List<Contact> emails =  ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");

        Comparator<Contact> mySorted = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(mySorted);
        sorted.addAll(phones);
        sorted.forEach(System.out::println);

        NavigableSet<String> justName = new TreeSet<>();
        phones.forEach(s-> justName.add(s.getName()));
        System.out.println(justName);
    }
}
