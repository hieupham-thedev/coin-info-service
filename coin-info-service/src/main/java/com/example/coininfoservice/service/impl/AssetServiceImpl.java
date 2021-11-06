package com.example.coininfoservice.service.impl;

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

    @Override
    public List<AssetDTO> getAllAssets() {
        try {
            RestTemplate restTemplate = new RestTemplate();

            String url = "http://rest-sandbox.coinapi.io/v1/assets";

            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
                    .queryParam("apikey", "5F5496AD-F861-444E-AD22-2917DFC69AAF");

            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
            HttpEntity<?> entity = new HttpEntity<>(headers);

            ResponseEntity<AssetDTO[]> response = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, entity, AssetDTO[].class);

            return Arrays.stream(response.getBody()).filter(assetDTO -> assetDTO.getPriceUSD() != null).collect(Collectors.toList());
        } catch (Throwable t) {
            return null;
        }
    }
}
