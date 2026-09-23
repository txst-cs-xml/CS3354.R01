public class Main {
    public static void main(String[] args) {
        Business bs1 = new Business();
        Business bs2 = new Business();
        bs1.setName("AAA Business");
        bs1.setAddress("5 Race St");
        bs2.setName("AAA Business");
        bs2.setAddress("5 Race St");

        System.out.println(bs1);
        System.out.println(bs2);

        System.out.println(bs1.equals(bs2));


        // Restaurant pizzaStore = new Restaurant();
        // pizzaStore.setName("Pie Society");
        // pizzaStore.setAddress("601 University Blvd");
        // pizzaStore.setRating(5);
        // System.out.println(pizzaStore);

        // String name = bs1 + "****" + bs2;
        // System.out.println(name);



    }
}
