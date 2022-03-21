package com.javawebtesting.dao;

import com.javawebtesting.dto.CartDTO;
import com.javawebtesting.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartDAO extends BaseDAO {

    @Autowired
    ProductDAO productDAO = new ProductDAO();

    public HashMap<Long, CartDTO> addCart(long id, HashMap<Long, CartDTO> cart) {
        CartDTO itemCart = new CartDTO();
        ProductDTO product = productDAO.getProductById(id).get(0);
        if (product != null && cart.containsKey(id)) {
            itemCart = cart.get(id);
            itemCart.setQuantity(itemCart.getQuantity() + 1);
            itemCart.setTotalPrice(itemCart.getQuantity() * itemCart.getProduct().getPrice());
        } else {
            itemCart.setProduct(product);
            itemCart.setQuantity(1);
            itemCart.setTotalPrice(product.getPrice());
        }
        cart.put(id, itemCart);
        return cart;
    }

    public HashMap<Long, CartDTO> editCart(long id, int quantity, HashMap<Long, CartDTO> cart) {
        CartDTO itemCart = new CartDTO();
        if(cart == null) {
            return cart;
        }
        if (cart.containsKey(id)) {
            itemCart = cart.get(id);
            itemCart.setQuantity(quantity);
            itemCart.setTotalPrice(quantity * itemCart.getProduct().getPrice());
        }
        cart.put(id, itemCart);
        return cart;
    }

    public HashMap<Long, CartDTO> deleteCart(long id, HashMap<Long, CartDTO> cart) {
        if(cart == null) {
            return cart;
        }
        if(cart.containsKey(id)){
            cart.remove(id);
        }
        return cart;
    }

    public int getTotalProductsInCart(HashMap<Long, CartDTO> cart) {
        int count = 0;
        for(Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) {
            count += itemCart.getValue().getQuantity();
        }
        return count;
    }

    public double getTotalPrice(HashMap<Long, CartDTO> cart) {
        double price = 0;
        for(Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) {
            price += itemCart.getValue().getTotalPrice();
        }
        return price;
    }
}
