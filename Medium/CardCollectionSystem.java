import java.util.*;

class CardCollection {
    private final Map<String, List<String>> cardMap;

    public CardCollection() {
        cardMap = new HashMap<>();
    }

    public void addCard(String symbol, String cardName) {
        cardMap.putIfAbsent(symbol, new ArrayList<>());
        cardMap.get(symbol).add(cardName);
        System.out.println("Card " + cardName + " of " + symbol + " added successfully!");
    }

    public void searchCardsBySymbol(String symbol) {
        if (cardMap.containsKey(symbol)) {
            System.out.println("Cards in " + symbol + ": " + cardMap.get(symbol));
        } else {
            System.out.println("No cards found for symbol: " + symbol);
        }
    }
}

public class CardCollectionSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardCollection collection = new CardCollection();

        // Adding all 52 standard playing cards
        String[] symbols = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] values = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        
        for (String symbol : symbols) {
            for (String value : values) {
                collection.addCard(symbol, value);
            }
        }

        while (true) {
            System.out.println("\n1. Add a Card");
            System.out.println("2. Search Cards by Symbol");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Card Symbol (Hearts, Spades, etc.): ");
                    String symbol = scanner.nextLine();
                    System.out.print("Enter Card Name (Ace, King, etc.): ");
                    String name = scanner.nextLine();
                    collection.addCard(symbol, name);
                    break;
                case 2:
                    System.out.print("Enter Symbol to Search: ");
                    String searchSymbol = scanner.nextLine();
                    collection.searchCardsBySymbol(searchSymbol);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}