package com.example.coininfoservice.repository;

import com.example.coininfoservice.entity.BoughtAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoughtAssetRepository extends JpaRepository<BoughtAsset, String> {
}
