public class PersonTest {
    public static void main(String[] args) {
        // Creating objects
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Bob", 25);
        
        // Accessing attributes
        System.out.println(person1.getName()); // "Alice"
        System.out.println(person2.getAge());  // 25
        
        // Calling methods
        person1.greet(); // "Hello, my name is Alice and I am 30 years old."
        person2.greet(); // "Hello, my name is Bob and I am 25 years old."
    }
}

