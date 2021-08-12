package administrator;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Generator {
    public static int generateKey(String name) {
        int key = 0;
        var byteArr = name.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < name.length(); i++) {
            key+=byteArr[i]*new Random().nextInt();
        }
        return key;
    }
}
