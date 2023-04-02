package desencriptado.clases;

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

public class Desencriptador {

    /**
     *Metodo para usar el algoritmo de desifrar SHA-1
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
     *Metodo para usar el algoritmo de desifrar MD5
     *
     *
     **/
    private SecretKeySpec crearClaveMd5(String clave)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] claveEncriptacion = clave.getBytes(StandardCharsets.UTF_8);
        MessageDigest sha = MessageDigest.getInstance("MD5");
        claveEncriptacion = sha.digest(claveEncriptacion);
        claveEncriptacion = Arrays.copyOf(claveEncriptacion,16);
        SecretKeySpec secretkey = new SecretKeySpec(claveEncriptacion, "AES");
        return secretkey;
    }

    /**
     *Metodo para Decifrar
     **/
    public String desencriptarSha1(String datosEncriptados, String claveSecreta)
            throws UnsupportedEncodingException, NoSuchAlgorithmException,
            InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException,
            BadPaddingException {
        SecretKeySpec secretKey = this.crearClaveSha1(claveSecreta);

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE,secretKey);

        byte[] byteEncriptados = Base64.getDecoder().decode(datosEncriptados);
        byte[] datosDesencriptados = cipher.doFinal(byteEncriptados);
        String datos = new String(datosDesencriptados);
        return datos;
    }

    /**
     *Metodo para Decifrar
     **/
    public String desencriptarMd5(String datosEncriptados, String claveSecreta)
            throws UnsupportedEncodingException, NoSuchAlgorithmException,
            InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException,
            BadPaddingException {
        SecretKeySpec secretKey = this.crearClaveMd5(claveSecreta);

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE,secretKey);

        byte[] byteEncriptados = Base64.getDecoder().decode(datosEncriptados);
        byte[] datosDesencriptados = cipher.doFinal(byteEncriptados);
        String datos = new String(datosDesencriptados);
        return datos;
    }
}
