package com.example.coininfoservice.controller;

import com.example.coininfoservice.dto.AssetDTO;
import com.example.coininfoservice.service.impl.CacheService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/asset")
public class AssetController {

    private CacheService cacheService;

    public AssetController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @PostMapping("/getAll")
    public ResponseEntity<List<AssetDTO>> getAllAssets() {
        List<AssetDTO> assets = cacheService.getCachedAssets();
        return new ResponseEntity<>(assets, HttpStatus.OK);
    }

}
