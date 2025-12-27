package Library;

import java.util.Base64;

public class CredentialEncoder {

    // Encode text (username / password)
    public static String encode(String value) {
        return Base64.getEncoder().encodeToString(value.getBytes());
    }

    // Decode text back to original
    public static String decode(String encodedValue) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedValue);
        return new String(decodedBytes);
    }

    public static void main(String[] args) {
        String password = "Sample";

        String encoded = encode(password);
        System.out.println("Encoded: " + encoded);

        String decoded = decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
}