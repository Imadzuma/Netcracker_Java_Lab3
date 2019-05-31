package com.dao.api;

import com.model.Book;
import com.model.Order;
import com.model.Shop;
import jdk.nashorn.internal.codegen.ObjectClassGenerator;

import java.util.List;
import java.util.Map;

public interface OrderDao extends Dao<Order> {
    List<Integer> findAllDifferentMounts();
    List<Map<String, Object>> findCustomersNamesAndShopNames();
    List<Map<String, Object>> findAllInfo();
    List<Map<String, Object>> findExpensiveOrders();
    List<Map<String, Object>> findInSimilarDistricts();
    List<Shop> findWithBigSalesWithoutAvtozavodskiyDistrict();
    List<Book> findBooksInSimilarDistricts();
}
