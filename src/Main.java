import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Kelas MenuItem
class MenuItem {
    private final String name;
    private final double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
// Kelas Order
class Order {
    private final List<MenuItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

// Kelas Restaurant
class Restaurant {
    private final List<MenuItem> menu;

    public Restaurant() {
        menu = new ArrayList<>();
        // Menambahkan beberapa item ke menu
        menu.add(new MenuItem("Nasi Goreng", 20000));
        menu.add(new MenuItem("Mie Ayam", 15000));
        menu.add(new MenuItem("Sate Ayam", 25000));
    }

    public void displayMenu() {
        System.out.println("Menu Makanan:");
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - Rp " + item.getPrice());
        }
    }

    public Order createOrder() {
        return new Order();
    }

    // Getter untuk menu
    public List<MenuItem> getMenu() {
        return menu;
    }
}

// Kelas utama
class RestaurantApp {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Scanner scanner = new Scanner(System.in);
        Order order = restaurant.createOrder();

        restaurant.displayMenu();
        System.out.println("Silakan pilih item (masukkan nomor, 0 untuk selesai):");

        while (true) {
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            } else if (choice > 0 && choice <= restaurant.getMenu().size()) { // Menggunakan getter getMenu()
                MenuItem selectedItem = restaurant.getMenu().get(choice - 1);
                order.addItem(selectedItem);
                System.out.println(selectedItem.getName() + " telah ditambahkan ke pesanan.");
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        System.out.println("Total pesanan: Rp " + order.calculateTotal());
        scanner.close();
    }
}
