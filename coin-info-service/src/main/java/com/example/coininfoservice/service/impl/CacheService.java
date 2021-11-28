package com.example.coininfoservice.service.impl;

import com.example.coininfoservice.dto.AssetDTO;
import com.example.coininfoservice.service.AssetService;

import java.util.ArrayList;
import java.util.List;

public class CacheService {

    private List<AssetDTO> cachedAssets;

    private AssetService assetService;

    public CacheService(AssetService assetService) {
        this.assetService = assetService;
        cachedAssets = new ArrayList<>();
    }

    public void cacheAssets() {
        System.out.println("Caching assets ...");
        cachedAssets = assetService.getAllAssets();
    }

    public List<AssetDTO> getCachedAssets() {
        return cachedAssets;
    }
}
