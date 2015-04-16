package sys.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Encriptador {

    Cipher ecipher;
    Cipher dcipher;
    byte[] salt = {-89, -111, -59, 40, 89, 55, -22, 30};
    int iterationCount = 19;

    public Encriptador(SecretKey key) {
        try {
            this.ecipher = Cipher.getInstance("DES");
            this.dcipher = Cipher.getInstance("DES");
            this.ecipher.init(1, key);
            this.dcipher.init(2, key);
        } catch (NoSuchPaddingException e) {
        } catch (NoSuchAlgorithmException e) {
        } catch (InvalidKeyException e) {
        }
    }

    Encriptador(String passPhrase){
        try {
            
            KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), this.salt, this.iterationCount);
            SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);

            this.ecipher = Cipher.getInstance(key.getAlgorithm());
            this.dcipher = Cipher.getInstance(key.getAlgorithm());

            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(this.salt, this.iterationCount);

            this.ecipher.init(1, key, paramSpec);
            this.dcipher.init(2, key, paramSpec);
            
        } catch (InvalidAlgorithmParameterException e) {
        } catch (InvalidKeySpecException e) {
        } catch (NoSuchPaddingException e) {
        } catch (NoSuchAlgorithmException e) {
        } catch (InvalidKeyException e) {
        }
    }

    public String encrypt(String str) {
        try {
            
            byte[] utf8 = str.getBytes("UTF8");
            byte[] enc = this.ecipher.doFinal(utf8);

            return new BASE64Encoder().encode(enc);
        } catch (BadPaddingException e) {
        } catch (IllegalBlockSizeException e) {
        } catch (UnsupportedEncodingException e) {
        } catch (IOException e) {
        }
        return null;
    }

    public String decrypt(String str) {
        try {
            
            byte[] dec = new BASE64Decoder().decodeBuffer(str);
            byte[] utf8 = this.dcipher.doFinal(dec);
            return new String(utf8, "UTF8");
            
        } catch (BadPaddingException e) {
        } catch (IllegalBlockSizeException e) {
        } catch (UnsupportedEncodingException e) {
        } catch (IOException e) {
        }
        return null;
    }

    public static String encriptar(String clave) throws NoSuchAlgorithmException {
        Encriptador encrypter = new Encriptador("TSoft");
        String encrypted = encrypter.encrypt(clave);
        return encrypted;
    }
    public static String desencriptar(String clave) {
        try{
            Encriptador encrypter = new Encriptador("TSoft");
            return encrypter.decrypt(clave);
        }catch (Exception e){
            return null;
        }
    }
    
}
