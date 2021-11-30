package com.example.coininfoservice.service.impl;

import com.example.coininfoservice.dao.impl.BoughtAssetDao;
import com.example.coininfoservice.dto.AssetDTO;
import com.example.coininfoservice.dto.BoughtAssetDTO;
import com.example.coininfoservice.entity.BoughtAsset;
import com.example.coininfoservice.service.BoughtAssetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoughtAssetServiceImpl implements BoughtAssetService {

    private CacheService cacheService;

    private BoughtAssetDao boughtAssetDao;

    public BoughtAssetServiceImpl(CacheService cacheService, BoughtAssetDao boughtAssetDao) {
        this.cacheService = cacheService;
        this.boughtAssetDao = boughtAssetDao;
    }

    @Override
    public boolean buyAsset(String assetId) {
        List<AssetDTO> assets = cacheService.getCachedAssets();

        Optional<AssetDTO> foundAsset = assets.stream().filter(assetDTO -> {
            return assetId.equals(assetDTO.getAssetId());
        }).findFirst();

        if (foundAsset.isPresent()) {
            BoughtAsset boughtAsset = new BoughtAsset();
            boughtAsset.setAssetId(foundAsset.get().getAssetId());
            boughtAsset.setBoughtPriceUSD(foundAsset.get().getPriceUSD());
            if (boughtAssetDao.readOne(assetId) == null && boughtAssetDao.create(boughtAsset) != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<BoughtAssetDTO> getBoughtAssets() {
        List<BoughtAsset> boughtAssets = boughtAssetDao.readAll();
        List<AssetDTO> assets = cacheService.getCachedAssets();

        List<BoughtAssetDTO> boughtAssetDTOs = boughtAssets.stream().map(boughtAsset -> {

            Optional<AssetDTO> foundAsset = assets.stream().filter(assetDTO -> {
                return boughtAsset.getAssetId().equals(assetDTO.getAssetId());
            }).findFirst();

            if (foundAsset.isPresent()) {
                BoughtAssetDTO dto = new BoughtAssetDTO();
                dto.setAssetId(foundAsset.get().getAssetId());
                dto.setBoughtPriceUSD(boughtAsset.getBoughtPriceUSD());
                dto.setCurrentPriceUSD(foundAsset.get().getPriceUSD());
                return dto;
            }
            return null;

        }).collect(Collectors.toList());

        return boughtAssetDTOs;
    }

}
