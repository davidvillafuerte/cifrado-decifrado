package encriptado.main;

import encriptado.clases.Encriptador;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inicio {

    public static void main(String[] args) {
        try {
            final String claveEncriptacion = "secreto!";
            String datosOriginalesSha1 = "https://medium.com/el-acordeon-del-programador";
            String datosOriginalesMd5 = "https://medium.com/el-acordeon-del-programador";
            Encriptador encriptador = new Encriptador();

            String encriptadoSha1 = encriptador.encriptarSha1(datosOriginalesSha1,claveEncriptacion);
            String encriptadoMd5 = encriptador.encriptarMd5(datosOriginalesMd5,claveEncriptacion);
            System.out.println("Cadena Original SHA-1: " + datosOriginalesSha1);
            System.out.println("Encriptado en SHA-1: " + encriptadoSha1);
            System.out.println("Cadena Original MD5: " + datosOriginalesMd5);
            System.out.println("Encriptado en MD5: " + encriptadoMd5);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException |
                NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(Encriptador.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
}
