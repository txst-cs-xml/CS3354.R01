class Person {
     String name;
 
     Person(String name) {
         this.name = name;
     }
 }
 
 public class PassObjectExample {
     public static void main(String[] args) {
         // Create a Person object
         Person person = new Person("Alice");
 
         // Call the method to modify the object's contents
         modifyObjectState(person);
 
         // Display the modified object's state
         System.out.println("Object Name: " + person.name); // Output: Object Name: Charlie
 
         // Attempt to modify the object reference (not possible)
         modifyObjectReference(person);
 
         // Display the original object reference
         System.out.println("Object Name: " + person.name); // Output: Object Name: Charlie
     }
 
     // Method to modify the object's state (contents)
     public static void modifyObjectState(Person p) {
         p.name = "Charlie"; // Modifying the state of the object through the reference
     }
 
     // Method attempting to modify the object reference (not possible)
     public static void modifyObjectReference(Person p) {
         p = new Person("Bob"); // Creating a new object and assigning it to the local reference 'p'
     }
 }
 