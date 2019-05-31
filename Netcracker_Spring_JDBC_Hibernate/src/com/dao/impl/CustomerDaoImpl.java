package com.dao.impl;

import com.dao.api.CustomerDao;
import com.model.Customer;
import javafx.util.Pair;
import jdk.nashorn.internal.codegen.ObjectClassGenerator;
import lombok.Data;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Repository("customerDao")
@Transactional
public class CustomerDaoImpl extends DaoImpl<Customer> implements CustomerDao {
    @Override
    public List<String> findAllDifferentDistricts() {
        return getSession().createQuery("SELECT DISTINCT district FROM " + Customer.class.getName()).list();
    }
    @Override
    public List<Map<String, Object>> findAllNamesAndSalesInNizhegorodskiyDistrict() {
        String nizhegorodskiyDistrict = "Nizhegorodskiy";
        List<Map<String, Object>> result = new ArrayList<>();
        List<Customer> customers = getSession().createQuery("FROM " + Customer.class.getName() +
                " WHERE district = :district").setString("district", nizhegorodskiyDistrict).list();
        customers.forEach(customer -> result.add(new HashMap<String, Object>() {{
            put("last_name", customer.getLastName());
            put("sale", customer.getSale());
            }}));
        return result;
    }
}
