package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products; // Список товарів у кошику

    // Конструктор
    public Cart() {
        this.products = new ArrayList<>();
    }

    // Додати товар до кошика
    public void addProduct(Product product) {
        products.add(product);
    }

    // Видалити товар з кошика
    public void removeProduct(Product product) {
        products.remove(product);
    }

    // Отримати загальну вартість товарів у кошику
    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    // Отримати список товарів у кошику
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    // Очистити кошик
    public void clear() {
        products.clear();
    }

    // Пошук товару за ID у кошику
    public Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    // Перевизначення методу toString для виведення інформації про кошик
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Кошик містить:\n");
        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }
        sb.append("Загальна вартість: ").append(getTotalPrice());
        return sb.toString();
    }
}