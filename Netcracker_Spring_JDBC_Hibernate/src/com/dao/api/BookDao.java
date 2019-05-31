package com.dao.api;

import com.model.Book;

import java.util.List;
import java.util.Map;

public interface BookDao extends Dao<Book> {
    List<String> findAllDifferentNames();
    List<Integer> findAllDifferentPrices();
    List<Map<String, Object>> findAllNamesAndPricesBooksWithWindows();
}
