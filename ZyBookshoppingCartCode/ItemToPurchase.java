public class ItemToPurchase {
   private String itemName;
   private int itemPrice;
   private int itemQuantity;
   private String itemDescription;
   
   public ItemToPurchase() {
      itemName = "none";
      itemDescription = "none";
      itemPrice = 0;
      itemQuantity = 0;

      return;
   }
   
   public ItemToPurchase(String name, String description, int price, int quantity) {
      itemName = name;
      itemPrice = price;
      itemQuantity = quantity;
      itemDescription = description;
      
      return;
   }
  
   public void setName(String name) {
      itemName = name;
      return;
   }
   
   public void setPrice(int price) {
      itemPrice = price;
      return;
   }
   
   public void setQuantity(int quantity) {
      itemQuantity = quantity;
      return;
   }
   
   public void setDescription(String description) {
      itemDescription = description;
      return;
   }

   public String getName() {
      return itemName;
   }
   
   public int getPrice() {
      return itemPrice;
   }
   
   public int getQuantity() {
      return itemQuantity;
   }

   public String getDescription() {
      return itemDescription;
   }
   
   public void printItemCost() {
      System.out.println(itemName + " " + itemQuantity + " @ $" + itemPrice + " = $" + 
                        (itemPrice * itemQuantity));
   }
   
   public void printItemDescription() {
      System.out.println(itemName + ": " + itemDescription);
   }
   
}
