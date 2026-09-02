import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // Create an empty ArrayList that stores String objects.
        ArrayList<String> friends = new ArrayList<>();

        // add() appends elements and increases the size of the list.
        friends.add("Cindy");
        friends.add("David");
        friends.add("Maria");
        System.out.println("Friends: " + friends);
        System.out.println("Number of friends: " + friends.size());

        // ArrayList indexes start at 0. get() reads an element.
        String firstFriend = friends.get(0);
        System.out.println("First friend: " + firstFriend);

        // set() replaces the element at an existing index.
        friends.set(1, "Harry");
        System.out.println("After replacing index 1: " + friends);

        // remove() deletes an element and decreases the size of the list.
        friends.remove("Maria");
        System.out.println("After removing Maria: " + friends);

        // A for-each loop visits every element in the ArrayList.
        System.out.println("Friend list:");
        for (String friend : friends) {
            System.out.println("- " + friend);
        }
    }
}
