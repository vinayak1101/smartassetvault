package com.ewm.controller;

import com.ewm.model.AssetStore;
import com.ewm.model.UserAccount;
import com.ewm.model.UserModel;

public class RegisterController {

    // Your Register.java calls: registerController.register(user)
    public boolean register(UserModel user) {
        if (user == null) return false;

        // default role if missing
        if (user.getRole() == null || user.getRole().isBlank()) {
            user.setRole("USER");
        }

        UserAccount acc = user.toAccount();
        return AssetStore.getInstance().addUser(acc);
    }
}
