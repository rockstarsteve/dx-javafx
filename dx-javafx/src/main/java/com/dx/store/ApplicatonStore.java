package com.dx.store;

import javafx.beans.property.MapProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

import java.util.HashMap;

/**
 * @description:
 * @className: User
 * @author: liwen
 * @date: 2020/8/2 10:17
 */

public class ApplicatonStore {

    private static SimpleStringProperty token = new SimpleStringProperty();
    private static MapProperty<String, String> featureMap;

    public static String getToken() {
        return token.get();
    }

    public static SimpleStringProperty tokenProperty() {
        return token;
    }

    public static void setToken(String token) {
        ApplicatonStore.token.set(token);
    }


    public static MapProperty<String, String> getFeatureMap() {
        if (featureMap == null) {
            ObservableMap<String, String> map = FXCollections.observableMap(new HashMap<>());
            featureMap = new SimpleMapProperty<>(map);
        }
        return featureMap;
    }

    public static void clearPermissionInfo() {
        getFeatureMap().clear();
    }

}


