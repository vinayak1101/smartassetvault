package com.ewm.controller;

import com.ewm.model.Asset;
import com.ewm.model.AssetStore;
import com.ewm.model.UserAccount;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AssetController {

    private final AssetStore store = AssetStore.getInstance();

    public List<Asset> getAllAssets() {
        return store.getAllAssets();
    }

    public boolean requestAsset(String assetId) {
        UserAccount current = store.getCurrentUser();
        String requester = (current == null) ? "Unknown" : current.getEmail();
        return store.requestAsset(assetId, requester);
    }

    public boolean returnAsset(String assetId) {
        return store.returnAsset(assetId);
    }

    public boolean addAsset(Asset asset) {
        return store.addAsset(asset);
    }

    public boolean deleteAsset(String assetId) {
        return store.deleteAsset(assetId);
    }

    public boolean approveRequest(String assetId) {
        return store.approveRequest(assetId);
    }

    public String getAssetHistory(String assetId) {
        List<String> history = store.getAssetHistory(assetId);
        if (history == null || history.isEmpty()) return "No history found.";
        return String.join("\n", history);
    }

    // --- Search & Sort ---
    public List<Asset> searchAssetsByTitle(String keyword) {
        return store.getAllAssets().stream()
                .filter(a -> a.getAssetName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Asset> sortAssetsByName(boolean ascending) {
        return store.getAllAssets().stream()
                .sorted(Comparator.comparing(Asset::getAssetName,
                        ascending ? Comparator.naturalOrder() : Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    public List<Asset> sortAssetsById(boolean ascending) {
        return store.getAllAssets().stream()
                .sorted(Comparator.comparing(Asset::getAssetId,
                        ascending ? Comparator.naturalOrder() : Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }
}
