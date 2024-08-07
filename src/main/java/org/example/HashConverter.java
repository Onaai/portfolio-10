package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class HashConverter {

    public static void main(String[] args) {
        // Crear un escáner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el mensaje que deseas convertir a hash:");
        String mensaje = scanner.nextLine();

        // Convertir el mensaje a hash utilizando SHA-256
        String hash = convertirSHA256(mensaje);

        // Imprimir el resultado
        System.out.println("El hash del mensaje es: " + hash);

        scanner.close();
    }

    public static String convertirSHA256(String mensaje) {
        try {
            // Crear una instancia del digestor SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Calcular el hash
            byte[] encodedhash = digest.digest(mensaje.getBytes());

            // Convertir el hash a una representación en hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedhash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
