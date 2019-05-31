package com.dao.impl;

import com.dao.api.OrderDao;
import com.model.Book;
import com.model.Order;
import com.model.Shop;
import jdk.nashorn.internal.codegen.ObjectClassGenerator;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Data
@Repository("orderDao")
@Transactional
public class OrderDaoImpl extends DaoImpl<Order> implements OrderDao {
    @Override
    public List<Integer> findAllDifferentMounts() {
        List<Date> dates = getSession().createQuery("SELECT DISTINCT date FROM " + Order.class.getName()).list();
        List<Integer> months = new ArrayList<>();
        for(Date date : dates) if (months.indexOf(date.getMonth())<0) months.add(date.getMonth());
        return months;
    }
    @Override
    public List<Map<String, Object>> findCustomersNamesAndShopNames() {
        List<Order> orders = getSession().createQuery("FROM " + Order.class.getName()).list();
        List<Map<String, Object>> results = new ArrayList<>();
        orders.forEach(order->results.add(new HashMap<String, Object>() {{
            put("customer_name", order.getCustomer().getLastName());
            put("shop_name", order.getSeller().getName());
        }}));
        return results;
    }
    @Override
    public List<Map<String, Object>> findAllInfo() {
        List<Order> orders = getSession().createQuery("FROM " + Order.class.getName()).list();
        List<Map<String, Object>> results = new ArrayList<>();
        orders.forEach(order->results.add(new HashMap<String, Object>() {{
            put("date", order.getDate());
            put("customer_name", order.getCustomer().getLastName());
            put("sale", order.getCustomer().getSale());
            put("book_name", order.getBook().getName());
            put("count", order.getCount());
        }}));
        return results;
}
    @Override
    public List<Map<String, Object>> findExpensiveOrders() {
        Integer price = 60000;
        List<Order> orders = getSession().createQuery("FROM " + Order.class.getName() +
                " WHERE cost > :price").setInteger("price", price).list();
        List<Map<String, Object>> results = new ArrayList<>();
        orders.forEach(order->results.add(new HashMap<String, Object>() {{
            put("id", order.getId());
            put("customer_name", order.getCustomer().getLastName());
            put("date", order.getDate());
        }}));
        return results;
    }
    @Override
    public List<Map<String, Object>> findInSimilarDistricts() {
        Date date = new Date(2019, 2, 1);
        List<Order> orders = getSession().createQuery("FROM " + Order.class.getName() +
                " WHERE date < :date" +
                " ORDER BY date").setDate("date", date).list();
        List<Map<String, Object>> results = new ArrayList<>();
        orders.stream().filter(order->order.getSeller().getDistrict().equals(order.getCustomer().getDistrict()))
                .forEach(order->results.add(new HashMap<String, Object>() {{
            put("customer_name", order.getCustomer().getLastName());
            put("district", order.getSeller().getDistrict());
            put("date", order.getDate());
        }}));
        return results;
    }
    @Override
    public List<Shop> findWithBigSalesWithoutAvtozavodskiyDistrict() {
        String avtozavodskiyDistrict = "Avtozavodskiy";
        double fromSale = 0.1;
        double toSale = 0.15;
        return getSession().createQuery("SELECT o.seller FROM " +
                Order.class.getName() + " o JOIN o.customer JOIN o.seller " +
                " WHERE o.seller.district NOT IN(:avtozavodskiyDistrict) AND" +
                " o.customer.sale BETWEEN :fromsale AND :tosale")
                .setString("avtozavodskiyDistrict", avtozavodskiyDistrict)
                .setDouble("fromsale", fromSale).setDouble("tosale", toSale).list();
    }
    @Override
    public List<Book> findBooksInSimilarDistricts() {
        int count = 10;
        return getSession().createQuery("SELECT o.book " +
                "FROM " + Order.class.getName() + " o JOIN o.seller JOIN o.book " +
                "WHERE o.seller.district = o.book.storage AND o.book.count >= :count " +
                "ORDER BY o.book.name").setInteger("count", count).list();
    }
}
