package desencriptado.main;

import desencriptado.clases.Desencriptador;
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
            String datosOriginalesSha1 = "ix89Y2D8I0Ljbo6e60hEX9RzK6ODY4kDoLXBpJR7/y80YJ+MpDj8Ov+KLHAWNHTW";
            String datosOriginalesMd5 = "tYKNgAuP+mBvoRhxADQ4ju7c6Q9wdCO0WtjQ+7FjxpN8fvPg6rwKUbPuqkTzZmEr";
            Desencriptador desencriptador = new Desencriptador();
            String desencriptadoSha1 = desencriptador.desencriptarSha1(datosOriginalesSha1,claveEncriptacion);
            String desencriptadoMd5 = desencriptador.desencriptarMd5(datosOriginalesMd5,claveEncriptacion);
            System.out.println("EncriptadoSha1 : " + datosOriginalesSha1);
            System.out.println("DesencriptadoSha1 : " + desencriptadoSha1);
            System.out.println("EncriptadoMd5 : " + datosOriginalesMd5);
            System.out.println("DesencriptadoMd5 : " + desencriptadoMd5);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException |
                NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(Encriptador.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
}
