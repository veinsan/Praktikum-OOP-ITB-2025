import java.util.ArrayList;
import java.util.List;

/**
 * Warehouse Manager class with generic methods for managing warehouse
 * operations
 */
public class WarehouseManager {

  /**
   * Generic method to find items in a container that match a specific condition
   * Uses bounded type parameter
   * 
   * Hint:
   * - Iterate through the items in the container.
   * - Check if each item's category matches the specified category.
   * - If it matches, add it to the result list.
   * - Return the result list.
   * 
   * @param <T>       type that extends Product
   * @param container the container to search in
   * @param category  the category to filter by
   * @return list of matching products
   */
  public static <T extends Product> List<T> findByCategory(Container<T> container, String category) {
    // TODO: Implement
    List <T> result = new ArrayList<>();
    for (T item : container.getItems()) {
      if (item.getCategory().equals(category)) {
        result.add(item);
      }
    }
    return result;
  }

  /**
   * Generic method to calculate total weight of items in a container
   * 
   * Hint:
   * - Iterate through the items in the container.
   * - Sum the weight of each item.
   * 
   * @param <T>       type that extends Product
   * @param container the container
   * @return total weight in kg
   */
  public static <T extends Product> double calculateTotalWeight(Container<T> container) {
    // TODO: Implement
    double totalWeight = 0.0;
    for (T item : container.getItems()) {
      totalWeight += item.getWeight();
    }
    return totalWeight;
  }

  /**
   * Generic method to transfer items from one container to another
   * Uses wildcards to allow flexibility
   * 
   * Hint:
   * - Iterate through the items in the source container.
   * - For each item, attempt to add it to the destination container.
   * - If added successfully, remove it from the source container.
   * - Stop when the specified count is reached or source is empty.
   * - Return the number of items actually transferred.
   * 
   * @param <T>         the type of items
   * @param source      source container
   * @param destination destination container
   * @param count       number of items to transfer
   * @return number of items actually transferred
   */
  public static <T> int transferItems(Container<T> source, Container<T> destination, int count) {
      int transferred = 0;
      List<T> copy = new ArrayList<>(source.getItems()); // snapshot dulu biar gak kacau iterasinya

      for (T item : copy) {
          if (transferred >= count) break;
          if (destination.addItem(item)) {
              source.removeItem(item);
              transferred++;
          }
      }
      return transferred;
  }

  /**
   * Generic method to count items in a shelf
   * Uses wildcard with upper bound
   * 
   * Hint:
   * - Use the shelf's method to get total items.
   * 
   * @param <T>   base type
   * @param shelf the shelf to count items from
   * @return total number of items
   */
  public static <T> int countItemsInShelf(Shelf<T> shelf) {
    // TODO: Implement
    int total = 0;
    for (Container<? extends T> container : shelf.getContainers()) {
      total += container.getItems().size();
    }
    return total;
  }

  /**
   * Generic method to find container by ID in a shelf
   * 
   * Hint:
   * - Iterate through the containers in the shelf.
   * - Check if each container's ID matches the specified ID.
   * - If a match is found, return the container.
   * - If no match is found, return null.
   * 
   * @param <T>         base type
   * @param shelf       the shelf to search
   * @param containerId the container ID to find
   * @return the container if found, null otherwise
   */
  public static <T> Container<? extends T> findContainerById(Shelf<T> shelf, String containerId) {
    // TODO: Implement
    for (Container <? extends T> container: shelf.getContainers()) {
      if (container.getContainerId().equals(containerId)) {
        return container;
      }
    }
    return null;
  }
}
