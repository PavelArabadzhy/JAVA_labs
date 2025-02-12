package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Створюємо категорії
        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        // Створюємо товари
        Product product1 = new Product(1, "Ноутбук", 29999.99, "Високопродуктивний ноутбук для роботи", electronics);
        Product product2 = new Product(2, "Смартфон", 15999.50, "Смартфон з високою автономністю", smartphones);
        Product product3 = new Product(3, "Навушники", 2999.00, "Бездротові навушники з шумозаглушенням", accessories);

        // Список усіх товарів
        List<Product> allProducts = new ArrayList<>();
        allProducts.add(product1);
        allProducts.add(product2);
        allProducts.add(product3);

        // Історія замовлень
        List<Order> orderHistory = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        // Кошик
        Cart cart = new Cart();
        while (true) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Видалити товар з кошика");
            System.out.println("4 - Переглянути кошик");
            System.out.println("5 - Зробити замовлення");
            System.out.println("6 - Переглянути історію замовлень");
            System.out.println("7 - Пошук товарів за назвою або категорією");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Список товарів:");
                    for (Product product : allProducts) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int idToAdd = scanner.nextInt();
                    Product productToAdd = findProductById(allProducts, idToAdd);
                    if (productToAdd != null) {
                        cart.addProduct(productToAdd);
                        System.out.println("Товар додано до кошика.");
                    } else {
                        System.out.println("Товар з таким ID не знайдено.");
                    }
                    break;
                case 3:
                    System.out.println("Введіть ID товару для видалення з кошика:");
                    int idToRemove = scanner.nextInt();
                    Product productToRemove = cart.findProductById(idToRemove);
                    if (productToRemove != null) {
                        cart.removeProduct(productToRemove);
                        System.out.println("Товар видалено з кошика.");
                    } else {
                        System.out.println("Товар з таким ID не знайдено у кошику.");
                    }
                    break;
                case 4:
                    System.out.println(cart);
                    break;
                case 5:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній. Додайте товари перед оформленням замовлення.");
                    } else {
                        Order order = new Order(cart);
                        orderHistory.add(order);
                        System.out.println("Замовлення оформлено:");
                        System.out.println(order);
                        cart.clear();
                    }
                    break;
                case 6:
                    if (orderHistory.isEmpty()) {
                        System.out.println("Історія замовлень порожня.");
                    } else {
                        System.out.println("Історія замовлень:");
                        for (Order order : orderHistory) {
                            System.out.println(order);
                        }
                    }
                    break;
                case 7:
                    scanner.nextLine(); // Очищення буфера
                    System.out.println("Введіть назву товару або категорію для пошуку:");
                    String searchQuery = scanner.nextLine();
                    List<Product> searchResults = searchProducts(allProducts, searchQuery);
                    if (searchResults.isEmpty()) {
                        System.out.println("Товари не знайдено.");
                    } else {
                        System.out.println("Результати пошуку:");
                        for (Product product : searchResults) {
                            System.out.println(product);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
                    break;
            }
        }
    }

    // Метод для пошуку товару за ID
    private static Product findProductById(List<Product> products, int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    // Метод для пошуку товарів за назвою або категорією
    private static List<Product> searchProducts(List<Product> products, String query) {
        List<Product> results = new ArrayList<>();

        for (Product product : products) {
            if (product.getName().toLowerCase().contains(query.toLowerCase())) {
                results.add(product);
            } else if (product.getCategory().getName().toLowerCase().contains(query.toLowerCase())) {
                results.add(product);
            }
        }
        return results; // Повертаємо список результатів
    }
}