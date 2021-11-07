package com.example.coininfoservice.service.impl;

import com.example.coininfoservice.common.CommonConst;
import com.example.coininfoservice.config.AppConfig;
import com.example.coininfoservice.dto.AssetDTO;
import com.example.coininfoservice.service.AssetService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssetServiceImpl implements AssetService {

    private AppConfig appConfig;

    public AssetServiceImpl(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public List<AssetDTO> getAllAssets() {
        try {
            RestTemplate restTemplate = new RestTemplate();

            String url = appConfig.getCoinApiUrl().concat(CommonConst.API_ALL_ASSETS);

            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
                    .queryParam("apikey", appConfig.getApiKey());

            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
            HttpEntity<?> entity = new HttpEntity<>(headers);

            ResponseEntity<AssetDTO[]> response = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, entity, AssetDTO[].class);

            return Arrays.stream(response.getBody())
                    .filter(assetDTO -> assetDTO.getPriceUSD() != null)
                    .filter(assetDTO -> checkURLAvailability(assetDTO.getIconUrl()))
                    .collect(Collectors.toList());
        } catch (Throwable t) {
            return null;
        }
    }

    private boolean checkURLAvailability(String url) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            if (HttpStatus.OK.equals(response.getStatusCode())) {
                return true;
            } else {
                return false;
            }
        } catch (Throwable t) {
            return false;
        }
    }
}
