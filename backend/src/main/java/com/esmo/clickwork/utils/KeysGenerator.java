package com.esmo.clickwork.utils;

import lombok.Getter;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Getter
public class KeysGenerator {

    private final RSAPublicKey publicKey;
    private final RSAPrivateKey privateKey;
    private static KeysGenerator instance;

    private KeysGenerator() {
        KeyPair keyPair;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();

            this.publicKey = (RSAPublicKey) keyPair.getPublic();
            this.privateKey = (RSAPrivateKey) keyPair.getPrivate();
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

    public static KeysGenerator getInstance() {
        if (instance == null) {
            instance = new KeysGenerator();
        }

        return instance;
    }
}
