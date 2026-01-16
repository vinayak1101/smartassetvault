package com.ewm.controller;

import com.ewm.model.Asset;
import com.ewm.model.AssetStore;
import com.ewm.model.UserAccount;

import java.util.List;

public class UserController {

    private final AssetStore store = AssetStore.getInstance();

    public UserAccount getCurrentUser() {
        return store.getCurrentUser();
    }

    public List<Asset> getAssetList() {
        return store.getAllAssets();
    }
}
