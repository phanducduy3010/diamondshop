package com.javawebtesting.service.user.impl;

import com.javawebtesting.dao.BillDAO;
import com.javawebtesting.dto.CartDTO;
import com.javawebtesting.entity.Bill;
import com.javawebtesting.entity.BillDetails;
import com.javawebtesting.service.user.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BillServiceImpl implements IBillService {

    @Autowired
    BillDAO billDAO;

    @Override
    public int addBill(Bill bill) {
        return billDAO.addBill(bill);
    }

    @Override
    public void addBillDetails(HashMap<Long, CartDTO> cart) {
        long idBill = billDAO.getIdLatestBill();

        for(Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) {
            BillDetails billDetails = new BillDetails();
            billDetails.setId_bill(idBill);
            billDetails.setId_product(itemCart.getValue().getProduct().getId_product());
            billDetails.setQuantity(itemCart.getValue().getQuantity());
            billDetails.setTotal(itemCart.getValue().getTotalPrice());
            billDAO.addBillDetails(billDetails);
        }
    }
}
