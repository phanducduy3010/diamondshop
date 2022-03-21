package com.javawebtesting.service.user;

import com.javawebtesting.dto.CartDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface ICartService {

    public HashMap<Long, CartDTO> addCart(long id, HashMap<Long, CartDTO> cart);

    public HashMap<Long, CartDTO> editCart(long id, int quantity, HashMap<Long, CartDTO> cart);

    public HashMap<Long, CartDTO> deleteCart(long id, HashMap<Long, CartDTO> cart);

    public int getTotalProductsInCart(HashMap<Long, CartDTO> cart);

    public double getTotalPrice(HashMap<Long, CartDTO> cart);
}
