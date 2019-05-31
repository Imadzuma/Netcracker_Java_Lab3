package com.dao.impl;

import com.dao.api.BookDao;
import com.model.Book;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Repository("bookDao")
@Transactional
public class BookDaoImpl extends DaoImpl<Book> implements BookDao {
    @Override
    public List<String> findAllDifferentNames() {
        return getSession().createQuery("SELECT DISTINCT name FROM " + Book.class.getName()).list();
    }
    @Override
    public List<Integer> findAllDifferentPrices() {
        return getSession().createQuery("SELECT DISTINCT price FROM " + Book.class.getName()).list();
    }

    @Override
    public List<Map<String, Object>> findAllNamesAndPricesBooksWithWindows() {
        Integer price = 2000;
        String windows = "Windows";
        List<Book> books = getSession().createQuery("FROM " + Book.class.getName() +
                " WHERE price > :price OR name LIKE '%" + windows + "%' " +
                " ORDER BY name, price DESC").setInteger("price", price).list();
        List<Map<String, Object>> result = new ArrayList<>();
        books.forEach(book->result.add(new HashMap<String, Object>() {{
            put("name", book.getName());
            put("price", book.getPrice());
        }}));
        return result;
    }
}
