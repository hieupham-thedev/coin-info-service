package com.example.coininfoservice.dao.impl;

import com.example.coininfoservice.dao.GenericDao;
import com.example.coininfoservice.entity.BoughtAsset;
import org.springframework.stereotype.Component;

@Component
public class BoughtAssetDao extends GenericDao {
    public BoughtAssetDao() {
        super(BoughtAsset.class);
    }
}
