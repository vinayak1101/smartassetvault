package com.ewm.controller;

import com.ewm.model.AssetStore;
import com.ewm.model.UserAccount;
import com.ewm.model.UserModel;

public class LoginController {

    // Your Login.java calls: LoginController.login(username, password)
    public static UserModel login(String usernameOrEmail, String password) {
        UserAccount acc = AssetStore.getInstance().authenticate(usernameOrEmail, password);
        return UserModel.fromAccount(acc);
    }

    public static void logout() {
        AssetStore.getInstance().logout();
    }
}
