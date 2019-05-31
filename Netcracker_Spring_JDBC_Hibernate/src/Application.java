
import com.config.SpringConfig;
import com.model.Book;
import com.model.Customer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.service.api.CrudService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        CrudService crudService = (CrudService) context.getBean("crudService");

        System.out.println("<-----------------------------Task1------------------------------>");
        System.out.println("Customers:");
        crudService.findAllCustomers().forEach(System.out::println);
        System.out.println();
        System.out.println("Shops:");
        crudService.findAllShops().forEach(System.out::println);
        System.out.println();
        System.out.println("Books:");
        crudService.findAllBooks().forEach(System.out::println);
        System.out.println();
        System.out.println("Order:");
        crudService.findAllOrders().forEach(System.out::println);
        System.out.println();

        System.out.println("<-----------------------------Task2------------------------------>");
        System.out.println("Different books' names:");
        crudService.findAllDifferentNamesBooks().forEach(System.out::println);
        System.out.println();
        System.out.println("Different books' prices:");
        crudService.findAllDifferentPricesBooks().forEach(System.out::println);
        System.out.println();
        System.out.println("Different customers' districts:");
        crudService.findAllDifferentDistrictsCustomers().forEach(System.out::println);
        System.out.println();
        System.out.println("Different orders' months:");
        crudService.findAllDifferentMonthsOrders().forEach(System.out::println);
        System.out.println();

        System.out.println("<-----------------------------Task3------------------------------>");
        System.out.println("Customers' names and sales in Nizhegorodskiy district:");
        crudService.findAllNamesAndSalesInNizhegorodskiyDistrictCustomers().forEach(System.out::println);
        System.out.println();
        System.out.println("Shops' names in Sovetskiy or Sormovsky Districts:");
        crudService.findAlNamesInSovetskiyOrSormovskyDistrictsShops().forEach(System.out::println);
        System.out.println();
        System.out.println("Books' names ans prices contains Windows or expensive:");
        crudService.findAllNamesAndPricesBooksWithWindowsBooks().forEach(System.out::println);
        System.out.println();

        System.out.println("<-----------------------------Task4------------------------------>");
        System.out.println("Orders' customers' names and shops' names:");
        crudService.findCustomersNamesAndShopNamesOrders().forEach(System.out::println);
        System.out.println();
        System.out.println("Orders' dates, customers' names, sales, books' names and count:");
        crudService.findAllInfoOrders().forEach(System.out::println);
        System.out.println();

        System.out.println("<-----------------------------Task5------------------------------>");
        System.out.println("Expensive orders:");
        crudService.findExpensiveOrders().forEach(System.out::println);
        System.out.println();
        System.out.println("Old orders in similar districts:");
        crudService.findInSimilarDistrictsOrders().forEach(System.out::println);
        System.out.println();
        System.out.println("Shops, where was order with big sale without Avtozavodskiy district:");
        crudService.findWithBigSalesWithoutAvtozavodskiyDistrictShops().forEach(System.out::println);
        System.out.println();
        System.out.println("More books in similar districts:");
        crudService.findBooksInSimilarDistrictsBooks().forEach(System.out::println);
        System.out.println();
    }
}
