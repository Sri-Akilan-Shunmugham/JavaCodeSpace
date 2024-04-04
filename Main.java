import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] transactions = {"notebook", "notebook", "keyboard", "mouse", "mouse"};
        Map<Integer, List<String>> groupedItems = groupTransactions(transactions);
        System.out.println("Output: " + groupedItems);
    }

    public static Map<Integer, List<String>> groupTransactions(String[] transactions) {
        Map<String, Integer> itemOccurrence = new HashMap<>();
        for (String transaction : transactions) {
            itemOccurrence.put(transaction, itemOccurrence.getOrDefault(transaction, 0) + 1);
        }

        Map<Integer, List<String>> groupedItems = new HashMap<>();
        for (Map.Entry<String, Integer> entry : itemOccurrence.entrySet()) {
            int occurrence = entry.getValue();
            String item = entry.getKey();
            groupedItems.computeIfAbsent(occurrence, k -> new ArrayList<>()).add(item);
        }

        return groupedItems;
    }
}
