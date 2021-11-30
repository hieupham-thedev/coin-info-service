package com.example.coininfoservice.service;

import com.example.coininfoservice.dto.BoughtAssetDTO;

import java.util.List;

public interface BoughtAssetService {

    boolean buyAsset(String assetId);

    List<BoughtAssetDTO> getBoughtAssets();
}
