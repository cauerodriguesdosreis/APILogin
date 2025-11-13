package com.login.exemplo.DTO;

import com.login.exemplo.Entity.Produto;

public class ProdutoResponseDTO {

    private String name;
    private double price;
    private int quantity;
    private double subtotal;

    public ProdutoResponseDTO(Produto prod) {
        this.name = prod.getName();
        this.price = prod.getPrice();
        this.quantity = prod.getQuantity();
        this.subtotal = prod.getPrice() * prod.getQuantity();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }
}
