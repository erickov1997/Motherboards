/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ittol.beans;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Erick
 */
public class Utilities {

    private final String DIGEST_ALGORITHM = "SHA-256";
    private final String CHARSET = "UTF-8";
    private final String HASH_ALGORITHM = "MD5";

    public String DigestSHA256(String data) throws UnsupportedEncodingException {
        StringBuilder toHexString = new StringBuilder();

        try {
            MessageDigest md = MessageDigest.getInstance(DIGEST_ALGORITHM);
            byte[] hash = md.digest(data.getBytes(CHARSET));
            for (int i = 0; i < hash.length; i++) {
                String tempHex = Integer.toHexString(0xff & hash[i]);
                if (tempHex.length() == 1) {
                    toHexString.append('0');
                }
                toHexString.append(tempHex);
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toHexString.toString();
    }

    public String DigestMD5(String data) {
        MessageDigest md = null;
        byte[] hashInBytes = null;
        StringBuilder sb = new StringBuilder();

        try {
            md = MessageDigest.getInstance(HASH_ALGORITHM);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            hashInBytes = md.digest(data.getBytes(CHARSET));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public String HexHash(String data) {
        byte[] rawData = data.getBytes();
        StringBuilder hexText = new StringBuilder();
        String initialHex;
        int initHexLength;

        for (int i = 0; i < rawData.length; i++) {
            int positiveValue = rawData[i] & 0x000000FF;
            initialHex = Integer.toHexString(positiveValue);
            initHexLength = initialHex.length();
            while (initHexLength++ < 2) {
                hexText.append("0");
            }
            hexText.append(initialHex);
        }
        return hexText.toString();
    }

    public String Base64Hash(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String password = "1234";
        Utilities u = new Utilities();
        System.out.println("SHA-256: " + u.DigestSHA256(password));
        System.out.println("SHA-256+Base64: " + u.Base64Hash(u.DigestSHA256(password)));
        System.out.println("SHA-256+Hex: " + u.HexHash(u.DigestSHA256(password)));
        System.out.println("MD5: " + u.DigestMD5(password));
        System.out.println("XXX: " + DatatypeConverter.printBase64Binary(u.DigestSHA256(password).getBytes()));
    }

}
