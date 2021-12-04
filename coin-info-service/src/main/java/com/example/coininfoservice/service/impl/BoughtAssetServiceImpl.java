package com.example.coininfoservice.service.impl;

import com.example.coininfoservice.dto.AssetDTO;
import com.example.coininfoservice.dto.BoughtAssetDTO;
import com.example.coininfoservice.entity.BoughtAsset;
import com.example.coininfoservice.repository.BoughtAssetRepository;
import com.example.coininfoservice.service.BoughtAssetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoughtAssetServiceImpl implements BoughtAssetService {

    private CacheService cacheService;

    private BoughtAssetRepository boughtAssetRepository;

    public BoughtAssetServiceImpl(CacheService cacheService, BoughtAssetRepository boughtAssetRepository) {
        this.cacheService = cacheService;
        this.boughtAssetRepository = boughtAssetRepository;
    }

    @Override
    public boolean buyAsset(String assetId) {
        List<AssetDTO> assets = cacheService.getCachedAssets();

        Optional<AssetDTO> foundAsset = assets.stream()
                .filter(assetDTO -> assetId.equals(assetDTO.getAssetId()))
                .findFirst();

        if (foundAsset.isPresent()) {
            BoughtAsset boughtAsset = new BoughtAsset();
            boughtAsset.setAssetId(foundAsset.get().getAssetId());
            boughtAsset.setBoughtPriceUSD(foundAsset.get().getPriceUSD());
            if (!boughtAssetRepository.existsById(assetId) && boughtAssetRepository.save(boughtAsset) != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<BoughtAssetDTO> getBoughtAssets() {
        List<BoughtAsset> boughtAssets = boughtAssetRepository.findAll();
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
