import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        HttpExample http = new HttpExample();

        // Url and params
        String url = "https://www.example.com";
        ArrayList<Param> params = new ArrayList<Param>();

        // Add params
        params.add(new Param("key1","value1"));
        params.add(new Param("key2","value2"));

        // Send
        http.post(url, params);
        http.get(url, params);
    }
}
