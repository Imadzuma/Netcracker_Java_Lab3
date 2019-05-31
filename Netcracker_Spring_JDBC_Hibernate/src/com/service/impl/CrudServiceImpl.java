package com.service.impl;

import com.dao.api.BookDao;
import com.dao.api.CustomerDao;
import com.dao.api.OrderDao;
import com.dao.api.ShopDao;
import com.model.Book;
import com.model.Customer;
import com.model.Order;
import com.model.Shop;
import com.service.api.CrudService;
import javafx.util.Pair;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Data
@Service("crudService")
@RequiredArgsConstructor
public class CrudServiceImpl implements CrudService {
    @Autowired
    BookDao bookDao;
    @Autowired
    CustomerDao customerDao;
    @Autowired
    OrderDao orderDao;
    @Autowired
    ShopDao shopDao;

    @Override
    public Book findBook(Integer id) {
        return bookDao.find(id);
    }
    @Override
    public void addBook(Book book) {
        bookDao.add(book);
    }
    @Override
    public void updateBook(Book book) {
        bookDao.update(book);
    }
    @Override
    public void deleteBook(Integer id) {
        bookDao.delete(id);
    }
    @Override
    public List<Book> findAllBooks() {
        return bookDao.findAll();
    }
    @Override
    public Long countBook() {
        return bookDao.count();
    }

    @Override
    public Customer findCustomer(Integer id) {
        return customerDao.find(id);
    }
    @Override
    public void addCustomer(Customer customer) {
        customerDao.add(customer);
    }
    @Override
    public void updateCustomer(Customer customer) {
        customerDao.update(customer);
    }
    @Override
    public void deleteCustomer(Integer id) {
        customerDao.delete(id);
    }
    @Override
    public List<Customer> findAllCustomers() {
        return customerDao.findAll();
    }
    @Override
    public Long countCustomer() {
        return customerDao.count();
    }

    @Override
    public Shop findShop(Integer id) {
        return shopDao.find(id);
    }
    @Override
    public void addShop(Shop shop) {
        shopDao.add(shop);
    }
    @Override
    public void updateShop(Shop shop) {
       shopDao.update(shop);
    }
    @Override
    public void deleteShop(Integer id) {
        shopDao.delete(id);
    }
    @Override
    public List<Shop> findAllShops() {
        return shopDao.findAll();
    }
    @Override
    public Long countShop() {
        return shopDao.count();
    }

    @Override
    public Order findOrder(Integer id) {
        return orderDao.find(id);
    }
    @Override
    public void addOrder(Order order) {
        orderDao.add(order);
    }
    @Override
    public void updateOrder(Order order) {
        orderDao.update(order);
    }
    @Override
    public void deleteOrder(Integer id) {
        orderDao.delete(id);
    }
    @Override
    public List<Order> findAllOrders() {
        return orderDao.findAll();
    }
    @Override
    public Long countOrder() {
        return orderDao.count();
    }

    @Override
    public List<String> findAllDifferentNamesBooks() {
        return bookDao.findAllDifferentNames();
    }
    @Override
    public List<Integer> findAllDifferentPricesBooks() {
        return bookDao.findAllDifferentPrices();
    }
    @Override
    public List<String> findAllDifferentDistrictsCustomers() {
        return customerDao.findAllDifferentDistricts();
    }
    @Override
    public List<Integer> findAllDifferentMonthsOrders() {
        return orderDao.findAllDifferentMounts();
    }

    @Override
    public List<Map<String, Object>> findAllNamesAndSalesInNizhegorodskiyDistrictCustomers() {
        return customerDao.findAllNamesAndSalesInNizhegorodskiyDistrict();
    }
    @Override
    public List<String> findAlNamesInSovetskiyOrSormovskyDistrictsShops() {
        return shopDao.findAlNamesInSovetskiyOrSormovskiyDistricts();
    }
    @Override
    public List<Map<String, Object>> findAllNamesAndPricesBooksWithWindowsBooks() {
        return bookDao.findAllNamesAndPricesBooksWithWindows();
    }
    @Override
    public List<Map<String, Object>> findCustomersNamesAndShopNamesOrders() {
        return orderDao.findCustomersNamesAndShopNames();
    }
    @Override
    public List<Map<String, Object>> findAllInfoOrders() {
        return orderDao.findAllInfo();
    }

    @Override
    public List<Map<String, Object>> findExpensiveOrders() {
        return orderDao.findExpensiveOrders();
    }
    @Override
    public List<Map<String, Object>> findInSimilarDistrictsOrders() {
        return orderDao.findInSimilarDistricts();
    }

    @Override
    public List<Shop> findWithBigSalesWithoutAvtozavodskiyDistrictShops() {
        return orderDao.findWithBigSalesWithoutAvtozavodskiyDistrict();
    }

    @Override
    public List<Book> findBooksInSimilarDistrictsBooks() {
        return orderDao.findBooksInSimilarDistricts();
    }

}
