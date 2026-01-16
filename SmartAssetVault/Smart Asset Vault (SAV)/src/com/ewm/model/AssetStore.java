package com.ewm.model;

import java.util.*;

public class AssetStore {

    private static AssetStore instance;

    private final Map<String, Asset> assets = new HashMap<>();
    private final Map<String, UserAccount> users = new HashMap<>();
    private final Map<String, List<String>> assetHistory = new HashMap<>();

    private UserAccount currentUser;

    private AssetStore() {
        // Sample assets
    }

    public static synchronized AssetStore getInstance() {
        if (instance == null) {
            instance = new AssetStore();
        }
        return instance;
    }

    // --------- Asset Operations ---------
    public synchronized List<Asset> getAllAssets() {
        return new ArrayList<>(assets.values());
    }

    public synchronized boolean addAsset(Asset asset) {
        if (asset == null || assets.containsKey(asset.getAssetId())) return false;
        assets.put(asset.getAssetId(), asset);
        return true;
    }

    public synchronized boolean deleteAsset(String assetId) {
        return assets.remove(assetId) != null;
    }

    public synchronized boolean requestAsset(String assetId, String requester) {
        Asset asset = assets.get(assetId);
        if (asset == null || "Assigned".equalsIgnoreCase(asset.getStatus())) return false;

        asset.setStatus("Assigned");
        asset.setAssignedTo(requester);
        asset.setAssignedDate(java.time.LocalDateTime.now().toString());
        addHistoryEntry(assetId, "Requested by " + requester + " at " + java.time.LocalDateTime.now());
        return true;
    }

    public synchronized boolean returnAsset(String assetId) {
        Asset asset = assets.get(assetId);
        if (asset == null || !"Assigned".equalsIgnoreCase(asset.getStatus())) return false;

        addHistoryEntry(assetId, "Returned by " + asset.getAssignedTo() + " at " + java.time.LocalDateTime.now());
        asset.setStatus("Available");
        asset.setAssignedTo("");
        asset.setAssignedDate("");
        return true;
    }

    public synchronized boolean approveRequest(String assetId) {
        // Optional: mark as approved
        return true;
    }

    // --------- Asset History ---------
    public synchronized void addHistoryEntry(String assetId, String entry) {
        assetHistory.computeIfAbsent(assetId, k -> new ArrayList<>()).add(entry);
    }

    public synchronized List<String> getAssetHistory(String assetId) {
        return assetHistory.getOrDefault(assetId, new ArrayList<>());
    }

    // --------- Users ---------
    public synchronized boolean addUser(UserAccount user) {
        if (user == null || users.containsKey(user.getEmail())) return false;
        users.put(user.getEmail(), user);
        return true;
    }

    public synchronized UserAccount authenticate(String usernameOrEmail, String password) {
        UserAccount user = users.get(usernameOrEmail);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            return user;
        }
        return null;
    }

    public synchronized void logout() {
        currentUser = null;
    }

    public synchronized UserAccount getCurrentUser() {
        return currentUser;
    }
}
