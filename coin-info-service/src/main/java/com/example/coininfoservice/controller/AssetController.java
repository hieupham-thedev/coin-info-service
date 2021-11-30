package com.example.coininfoservice.controller;

import com.example.coininfoservice.dto.AssetDTO;
import com.example.coininfoservice.dto.BoughtAssetDTO;
import com.example.coininfoservice.service.BoughtAssetService;
import com.example.coininfoservice.service.impl.CacheService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/asset")
public class AssetController {

    private CacheService cacheService;

    private BoughtAssetService boughtAssetService;

    public AssetController(CacheService cacheService, BoughtAssetService boughtAssetService) {
        this.cacheService = cacheService;
        this.boughtAssetService = boughtAssetService;
    }

    @PostMapping("/getAll")
    public ResponseEntity<List<AssetDTO>> getAllAssets() {
        List<AssetDTO> assets = cacheService.getCachedAssets();
        return new ResponseEntity<>(assets, HttpStatus.OK);
    }

    @PostMapping("/getBoughtAssets")
    public ResponseEntity<List<BoughtAssetDTO>> getBoughtAssets() {
        List<BoughtAssetDTO> boughtAssets = boughtAssetService.getBoughtAssets();
        return new ResponseEntity<>(boughtAssets, HttpStatus.OK);
    }

    @PostMapping("/buy/{assetId}")
    public ResponseEntity buyAsset(@PathVariable(name = "assetId") String assetId) {
        ResponseEntity response = null;
        try {
            if (boughtAssetService.buyAsset(assetId)) {
                response = new ResponseEntity(HttpStatus.OK);
            } else {
                response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Throwable t) {
            t.printStackTrace();
            response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}
