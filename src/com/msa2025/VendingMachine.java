package com.msa2025;

import java.util.HashMap;
import java.util.Map;

class VendingMachine {
    private int balance;
    private Map<String, Product> products;

    public VendingMachine() {
        this.balance = 0;
        this.products = new HashMap<>();
    }

    public void addProduct(String name, int price, int stock) {
        products.put(name, new Product(name, price, stock));
    }

    public void insertMoney(int amount) {
        balance += amount;
        System.out.println("현재 잔액: " + balance + "원");
    }

    public void purchase(String name) {
        if (!products.containsKey(name)) {
            System.out.println("상품이 존재하지 않습니다.");
            return;
        }
        Product product = products.get(name);
        
        if (product.stock == 0) {
            System.out.println(name + " 품절!");
            return;
        }
        
        if (balance < product.price) {
            System.out.println("잔액 부족! 현재 잔액: " + balance + "원");
            return;
        }

        balance -= product.price;
        product.stock--;
        System.out.println(name + " 구매 완료! 남은 잔액: " + balance + "원");
        System.out.println("남은 재고: " + product.stock);
    }

    public void refund() {
        System.out.println("거스름돈 반환: " + balance + "원");
        balance = 0;
    }
}
