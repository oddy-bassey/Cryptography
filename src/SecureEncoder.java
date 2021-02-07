import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class SecureEncoder {

    private static final String ALGORITHM = "AES";
    private byte[] keyValue;

    public SecureEncoder(String key) {
        this.keyValue = key.getBytes();
    }

    public String encrypt(String data) throws Exception{
        Key key = generatedKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encValue = cipher.doFinal(data.getBytes());
        String encryptedValue = Base64.getEncoder().encodeToString(encValue);

        return encryptedValue;
    }

    public String decrypt(String encryptedData) throws Exception{
        Key key = generatedKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decValue = cipher.doFinal(decodedValue);
        String decryptedValue = new String(decValue);

        return decryptedValue;
    }

    public Key generatedKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    }

    public static void main(String[] args) throws Exception {

        SecureEncoder secureEncoder = new SecureEncoder("Pay1#se2c3u4r5ed");
        String encData = "ZJZgOb/IITtqac6MwdUKK4eBm4gfnIYQy1SDF9lb41g2wxnq4B8797uafWTgeQjFYdQd6Dk+trSIlXiZKmBhZFjzueyLpACO7QFFmAlasOUnhbeCdQOWPzRpzxJH3dOXsOd0j6TXKD1doQTOTVl76Qz3iq+oibc1F1c9sN98hXo4ld4efB4dpVy96DOrZ1pLKFRblHfZ8/j3GJMI3Ekaw+2DkXkRTy5lnp6SjNvnpOF8MnbPslSg58BDhN39GTeH1ARMzMEOVVfapx4OS5LJBPJi3bIA7w1zpe5Rjj0acjp3RQRD37SyzAB4YGUZ0csFxLr7n8jtxnJQUIXylz7k/HokkgxbbgtlrXqOIdX55qxLCCUxeuoNvoTbb1N8Z/eQTTSuW/vunUpFcxFgDSA+tRBjJp07GWn2/2C8yVMqA1osmh0+WUOM/sgPPb5H9+9R/z+btqFn0nXGyP5Dhaz2gxgIRFooXeDGlaPLzW5rCRPj3+eozS5uCWoQJ6wdZ8opapCnFWHaJcBviiD8B8AO3x9lQt3gCQYJJjU3JY8JvQUdkirh0NxM6khKiieuFOqwdKZtQbgYEcB5YSkb6RiLeyAxAa5ofPSXPIHhiJ72HZkVVF5WUTjN6EPOFkbhT2oUmf/dYOTOSe6fojgfi28K217KW8dg4CQXoVszfSfl5uQQ9JrudXcCFnY4cAmNKjYFK9BGFo8ijp4vXm5BMoLkBqONxEcBKhNc9mgh4tkePVHxrRvRo9jRfuRAL1a3em0IMDmtbGtwHmXnPWS90DL8rPIFHsLc04d0fCY7qnvgOYPTlfHSwr/eogf7+05DkCFAJTgIwgjOp8rh0dUbxyR+JgQQyxAZmAi77jXbvk8NbvefXKpCRyi9LiRqV8d57CvY/ViypJNJiFn4TgEPh3ateVo5ak4MeSGeDlJTXOBSH2m/Vif8Nki2hyXR1HfFQXhC";
        System.out.println("Encrypted data ---> "+encData);
        System.out.println("Decrypted data ---> "+secureEncoder.decrypt(encData));

    }
}
