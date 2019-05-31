package com.service.api;

import com.model.Book;
import com.model.Customer;
import com.model.Order;
import com.model.Shop;
import javafx.util.Pair;

import java.util.List;
import java.util.Map;

public interface CrudService {
    Book findBook(Integer id);
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(Integer id);
    List<Book> findAllBooks();
    Long countBook();

    Customer findCustomer(Integer id);
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Integer id);
    List<Customer> findAllCustomers();
    Long countCustomer();

    Shop findShop(Integer id);
    void addShop(Shop shop);
    void updateShop(Shop shop);
    void deleteShop(Integer id);
    List<Shop> findAllShops();
    Long countShop();

    Order findOrder(Integer id);
    void addOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(Integer id);
    List<Order> findAllOrders();
    Long countOrder();

    List<String> findAllDifferentNamesBooks();
    List<Integer> findAllDifferentPricesBooks();
    List<String> findAllDifferentDistrictsCustomers();
    List<Integer> findAllDifferentMonthsOrders();
    List<Map<String, Object>> findAllNamesAndSalesInNizhegorodskiyDistrictCustomers();
    List<String> findAlNamesInSovetskiyOrSormovskyDistrictsShops();
    List<Map<String, Object>> findAllNamesAndPricesBooksWithWindowsBooks();
    List<Map<String, Object>> findCustomersNamesAndShopNamesOrders();
    List<Map<String, Object>> findAllInfoOrders();
    List<Map<String, Object>> findExpensiveOrders();
    List<Map<String, Object>> findInSimilarDistrictsOrders();
    List<Shop> findWithBigSalesWithoutAvtozavodskiyDistrictShops();
    List<Book> findBooksInSimilarDistrictsBooks();
}
