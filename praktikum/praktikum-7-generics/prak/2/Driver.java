import java.util.List;

/**
 * Comprehensive Driver class to demonstrate all classes and their methods
 */
public class Driver {
  public static void main(String[] args) {
    System.out.println("=== WAREHOUSE MANAGEMENT SYSTEM - DEMO ===\n");

    demonstrateProductClasses();
    demonstrateContainer();
    demonstrateShelf();
    demonstrateWarehouseManager();
    demonstrateAdvancedIntegration();
  }

  /**
   * Demonstrates all Product subclasses and their methods
   */
  private static void demonstrateProductClasses() {
    System.out.println("1. Products: Electronics, Food, Clothing");
    Electronics laptop = new Electronics("E001", "Laptop", 2.5, 24);
    Food rice = new Food("F001", "Rice", 10.0, "2025-12-31");
    Clothing tshirt = new Clothing("C001", "T-Shirt", 0.2, "M");
    System.out.println("  " + laptop + " | Category: " + laptop.getCategory());
    System.out.println("  " + rice + " | Expiry: " + rice.getExpiryDate());
    System.out.println("  " + tshirt + " | Size: " + tshirt.getSize() + "\n");
  }

  /**
   * Demonstrates Container class and all its methods
   */
  private static void demonstrateContainer() {
    System.out.println("2. Container: add/remove/get items, check full/empty");
    Container<Electronics> container = new Container<>("C001", 3);
    container.addItem(new Electronics("E001", "Laptop", 2.5, 24));
    container.addItem(new Electronics("E002", "Phone", 0.3, 12));
    System.out.println("  " + container + " | Full: " + container.isFull());
    container.removeItem(container.getItems().get(0));
    System.out.println("  After removal: Size=" + container.getCurrentSize() + "\n");
  }

  /**
   * Demonstrates Shelf class and all its methods
   */
  private static void demonstrateShelf() {
    System.out.println("3. Shelf: holds multiple containers");
    Shelf<Product> shelf = new Shelf<>("S001", 3);
    Container<Electronics> c1 = new Container<>("C-E", 5);
    c1.addItem(new Electronics("E001", "Tablet", 0.5, 12));
    Container<Food> c2 = new Container<>("C-F", 5);
    c2.addItem(new Food("F001", "Rice", 10.0, "2025-12-31"));
    shelf.addContainer(c1);
    shelf.addContainer(c2);
    System.out.println("  " + shelf + " | Total items: " + shelf.getTotalItems() + "\n");

    System.out.println("  Items in shelf:");
    for (Container<? extends Product> container : shelf.getContainers()) {
      for (Product item : container.getItems()) {
        System.out.println("    - " + item);
      }
    }
    System.out.println();
  }

  /**
   * Demonstrates all WarehouseManager static methods
   */
  private static void demonstrateWarehouseManager() {
    System.out.println("4. WarehouseManager: findByCategory, calculateTotalWeight, transferItems");
    Container<Product> container = new Container<>("C-PROD", 20);
    container.addItem(new Electronics("E001", "Laptop", 3.0, 24));
    container.addItem(new Food("F001", "Rice", 10.0, "2025-12-31"));
    container.addItem(new Electronics("E002", "Phone", 0.3, 12));

    List<Product> elec = WarehouseManager.findByCategory(container, "Electronics");
    System.out.println("  Found " + elec.size() + " Electronics");
    System.out.printf("  Total weight: %.1fkg\n", WarehouseManager.calculateTotalWeight(container));

    Container<Electronics> src = new Container<>("SRC", 5);
    Container<Electronics> dst = new Container<>("DST", 5);
    src.addItem(new Electronics("E010", "Item1", 1.0, 12));
    src.addItem(new Electronics("E011", "Item2", 1.0, 12));
    int transferred = WarehouseManager.transferItems(src, dst, 1);
    System.out.println("  Transferred: " + transferred + " items");

    System.out.println("  Final sizes - SRC: " + src.getCurrentSize() + " | DST: " + dst.getCurrentSize() + "\n");
  }

  /**
   * Demonstrates advanced integration of all components
   */
  private static void demonstrateAdvancedIntegration() {
    System.out.println("5. Advanced Integration: Complete warehouse with shelves, containers, tracker");

    // Create shelves and containers
    Shelf<Electronics> elecShelf = new Shelf<>("SHELF-ELEC", 5);
    Container<Electronics> highEnd = new Container<>("ELEC-HIGH", 10);
    highEnd.addItem(new Electronics("E001", "Gaming Laptop", 3.0, 24));
    highEnd.addItem(new Electronics("E002", "Workstation", 5.0, 36));
    elecShelf.addContainer(highEnd);

    Shelf<Food> foodShelf = new Shelf<>("SHELF-FOOD", 5);
    Container<Food> grains = new Container<>("FOOD-GRAIN", 10);
    grains.addItem(new Food("F001", "Rice", 25.0, "2025-12-31"));
    grains.addItem(new Food("F002", "Quinoa", 10.0, "2026-01-15"));
    foodShelf.addContainer(grains);

    System.out.println("  Electronics Shelf: " + WarehouseManager.countItemsInShelf(elecShelf) + " items, "
        + String.format("%.1f", WarehouseManager.calculateTotalWeight(highEnd)) + "kg");
    System.out.println("  Food Shelf: " + WarehouseManager.countItemsInShelf(foodShelf) + " items, "
        + String.format("%.1f", WarehouseManager.calculateTotalWeight(grains)) + "kg");
  }
}