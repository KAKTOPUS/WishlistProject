package utils;

import properties.FilePropertiesReader;
import java.io.IOException;
import java.util.Map;

public class GetDataPropertiesUtil {
    private Map<String, String> data = null;

    {

        try {
            data = new FilePropertiesReader().getData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getLoginFromProperties() {
        String login = data.get("login");
        return login;
    }

    public String getUrlFromProperties() {
        String url = data.get("url");
        return url;
    }

    public String getPasswordFromProperties() {
        String password = data.get("password");
        return password;
    }

    public String getWrongPasswordFromProperties() {
        String wrongPassword = data.get("wrong_password");
        return wrongPassword;
    }

    public String getGiftUrlFromProperties() {
        String giftUrl = data.get("gift");
        return giftUrl;
    }

    public String getGiftPhotoFromProperties() {
        String giftPhoto = data.get("photo");
        return giftPhoto;
    }

}
