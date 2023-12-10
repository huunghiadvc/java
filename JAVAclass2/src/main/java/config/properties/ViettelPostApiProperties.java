package config.properties;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@Data
public class ViettelPostApiProperties {
    private String baseUrl;
    private String login;
    private String getListPostOffice;
    private String getListService;
    private String username;
    private String password;
    public ViettelPostApiProperties(){
        FileReader reader = null;
        try {
            reader = new FileReader("./src/main/resources/application.properties");
            Properties props = new Properties();
            props.load(reader);
            this.setBaseUrl(props.getProperty("api.path.viettel-post.base-url"));
            this.setLogin(props.getProperty("api.path.viettel-post.login"));
            this.setGetListPostOffice(props.getProperty("api.path.viettel-post.get-list-post-office"));
            this.setUsername(props.getProperty("api.path.viettel-post.username"));
            this.setPassword(props.getProperty("api.path.viettel-post.password"));
            this.setGetListService(props.getProperty("api.path.viettel-post.get-list-service"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
