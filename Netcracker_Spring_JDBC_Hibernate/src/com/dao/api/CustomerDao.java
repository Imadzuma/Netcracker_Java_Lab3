package com.dao.api;

import com.model.Customer;
import javafx.util.Pair;

import java.util.List;
import java.util.Map;

public interface CustomerDao extends Dao<Customer> {
    List<String> findAllDifferentDistricts();
    List<Map<String, Object>> findAllNamesAndSalesInNizhegorodskiyDistrict();
}
