package encriptado.clases;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class Encriptador {

    /**
     *Metodo para usar el algoritmo de cifrado SHA-1
     *
     **/
    private SecretKeySpec crearClaveSha1(String clave)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] claveEncriptacion = clave.getBytes(StandardCharsets.UTF_8);
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        claveEncriptacion = sha.digest(claveEncriptacion);
        claveEncriptacion = Arrays.copyOf(claveEncriptacion,16);
        SecretKeySpec secretkey = new SecretKeySpec(claveEncriptacion, "AES");
        return secretkey;
    }

    /**
     *Metodo para usar el algoritmo de cifrado MD5
     *
     *
     **/
    private SecretKeySpec crearClaveMd5(String clave)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] claveEncriptacion = clave.getBytes(StandardCharsets.UTF_8);
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        claveEncriptacion = md5.digest(claveEncriptacion);
        claveEncriptacion = Arrays.copyOf(claveEncriptacion,16);
        SecretKeySpec secretkey = new SecretKeySpec(claveEncriptacion, "AES");
        return secretkey;
    }

    /**
     *Metodo para Encriptar
     **/
    public String encriptarMd5(String datos,String claveSecreta)
            throws UnsupportedEncodingException, NoSuchAlgorithmException,
            InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException,
            BadPaddingException {
        SecretKeySpec secretkey = this.crearClaveMd5(claveSecreta);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,secretkey);

        byte[] datosEncriptar = datos.getBytes(StandardCharsets.UTF_8);
        byte[] bytesEncriptados = cipher.doFinal(datosEncriptar);
        String encriptado = Base64.getEncoder().encodeToString(bytesEncriptados);
        return encriptado;
    }

    /**
     *Metodo para Encriptar
     **/
    public String encriptarSha1(String datos,String claveSecreta)
            throws UnsupportedEncodingException, NoSuchAlgorithmException,
            InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException,
            BadPaddingException {
        SecretKeySpec secretkey = this.crearClaveSha1(claveSecreta);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,secretkey);

        byte[] datosEncriptar = datos.getBytes(StandardCharsets.UTF_8);
        byte[] bytesEncriptados = cipher.doFinal(datosEncriptar);
        String encriptado = Base64.getEncoder().encodeToString(bytesEncriptados);
        return encriptado;
    }
}
