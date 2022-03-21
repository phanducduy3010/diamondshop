package com.javawebtesting.dao;

import com.javawebtesting.entity.Bill;
import com.javawebtesting.entity.BillDetails;
import org.springframework.stereotype.Repository;

@Repository
public class BillDAO extends BaseDAO{

    public int addBill(Bill bill) {
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO bill ");
        sql.append("( ");
        sql.append("   username, phone, display_name, address, total, quantity, note");
        sql.append(") VALUES ( ");
        sql.append("   '" + bill.getUsername() + "', ");
        sql.append("   '" + bill.getPhone() + "', ");
        sql.append("   '" + bill.getDisplay_name() + "', ");
        sql.append("   '" + bill.getAddress() + "', ");
        sql.append("   " + bill.getTotal() + ", ");
        sql.append("   " + bill.getQuantity() + ", ");
        sql.append("   '" + bill.getNote() + "' ");
        sql.append(");");
        int insert = _jdbcTemplate.update(sql.toString());
        return insert;
    }

    public  long getIdLatestBill() {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT MAX(id) FROM bill;");
        long id = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Long.class);
        return id;
    }

    public int addBillDetails(BillDetails billDetails) {
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO billdetails ");
        sql.append("( ");
        sql.append("   id_product, ");
        sql.append("   id_bill, ");
        sql.append("   quantity, ");
        sql.append("   total");
        sql.append(") VALUES ( ");
        sql.append("   " + billDetails.getId_product() + ", ");
        sql.append("   " + billDetails.getId_bill() + ", ");
        sql.append("   " + billDetails.getQuantity()+ ", ");
        sql.append("   " + billDetails.getTotal() + " ");
        sql.append(")");
        int insert = _jdbcTemplate.update(sql.toString());
        return insert;
    }
}
