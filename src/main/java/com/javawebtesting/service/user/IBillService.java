package com.javawebtesting.service.user;

import com.javawebtesting.dto.CartDTO;
import com.javawebtesting.entity.Bill;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface IBillService {
    public int addBill(Bill bill);
    public void addBillDetails(HashMap<Long, CartDTO> cart);
}
