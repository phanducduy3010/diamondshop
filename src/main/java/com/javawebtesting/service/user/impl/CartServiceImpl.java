package com.javawebtesting.service.user.impl;

import com.javawebtesting.dao.CartDAO;
import com.javawebtesting.dto.CartDTO;
import com.javawebtesting.service.user.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    CartDAO cartDAO;

    @Override
    public HashMap<Long, CartDTO> addCart(long id, HashMap<Long, CartDTO> cart) {
        return cartDAO.addCart(id, cart);
    }

    @Override
    public HashMap<Long, CartDTO> editCart(long id, int quantity, HashMap<Long, CartDTO> cart) {
        return cartDAO.editCart(id, quantity, cart);
    }

    @Override
    public HashMap<Long, CartDTO> deleteCart(long id, HashMap<Long, CartDTO> cart) {
        return cartDAO.deleteCart(id, cart);
    }

    @Override
    public int getTotalProductsInCart(HashMap<Long, CartDTO> cart) {
        return cartDAO.getTotalProductsInCart(cart);
    }

    @Override
    public double getTotalPrice(HashMap<Long, CartDTO> cart) {
        return cartDAO.getTotalPrice(cart);
    }
}
