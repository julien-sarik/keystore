package hello.keystore;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.Base64;

public class App {

    public static void main(String[] args) throws Exception {
        final char[] storePass = "p2".toCharArray();
        final String fileName = "src/main/resources/keystore.jks";
        final String alias = "foo-client";
        final String keyPass = "p1";

        final KeyStore store = KeyStore.getInstance("JKS");
        final InputStream input = new FileInputStream(fileName);
        store.load(input, storePass);

        final Certificate entry = store.getCertificate(alias);
        final Key key = store.getKey(alias, keyPass.toCharArray());
        final String privateKey = Base64.getMimeEncoder().encodeToString(key.getEncoded());
        System.out.println(privateKey);
    }
}
