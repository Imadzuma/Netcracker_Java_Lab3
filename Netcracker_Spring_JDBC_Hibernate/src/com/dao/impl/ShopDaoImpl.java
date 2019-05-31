package com.dao.impl;

import com.dao.api.ShopDao;
import com.model.Shop;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@Repository("shopDao")
@Transactional
public class ShopDaoImpl extends DaoImpl<Shop> implements ShopDao {
    @Override
    public List<String> findAlNamesInSovetskiyOrSormovskiyDistricts() {
        String sormovskiyDistrict = "Sormovskiy";
        String sovetskiyDictrict = "Sovetskiy";
        return getSession().createQuery("SELECT name " +
                "FROM " + Shop.class.getName() +
                " WHERE district=:sormovskiyDistrict OR district=:sovetskiyDictrict")
                .setString("sormovskiyDistrict", sormovskiyDistrict)
                .setString("sovetskiyDictrict", sovetskiyDictrict).list();
    }
}
