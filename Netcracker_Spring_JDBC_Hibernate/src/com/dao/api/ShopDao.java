package com.dao.api;

import com.model.Shop;

import java.util.List;

public interface ShopDao extends Dao<Shop> {
    List<String> findAlNamesInSovetskiyOrSormovskiyDistricts();
}
