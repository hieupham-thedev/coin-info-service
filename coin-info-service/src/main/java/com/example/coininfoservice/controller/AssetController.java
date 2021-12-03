package com.example.coininfoservice.controller;

import com.example.coininfoservice.dto.AssetDTO;
import com.example.coininfoservice.dto.BoughtAssetDTO;
import com.example.coininfoservice.service.BoughtAssetService;
import com.example.coininfoservice.service.impl.CacheService;
import com.example.coininfoservice.utils.ExcelExporter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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

    @GetMapping("/exportExcel")
    public void exportToExcel(HttpServletResponse response) {
        try {
            List<AssetDTO> assets = cacheService.getCachedAssets();
            List<String> headerFields = Arrays.asList("Asset ID", "Asset Name", "Is Crypto", "Start Date", "End Date", "Price");
            List<String> dataFields = Arrays.asList("asset_id", "name", "type_is_crypto", "data_start", "data_end", "price_usd");
            ExcelExporter<AssetDTO> assetExcelExporter = new ExcelExporter<>(headerFields, dataFields, assets);
            assetExcelExporter.export(response, "Assets");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
