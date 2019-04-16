import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class HttpExample {

    void get() throws Exception {
        // Connection
        String url = "https://www.example.com/";
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

        // Headers
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        // Print response status
        System.out.println("GET status " + connection.getResponseCode());

        // Print response text
        String response;
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        while ((response = reader.readLine()) != null) {
            System.out.println(response);
        }

        reader.close();
    }

    void post() throws Exception {
        // Connection
        String url = "https://www.example.com/";
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

        // Headers
        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        // Post parameters
        String params = "param1=value1&param2=value2";

        // Send post request
        connection.setDoOutput(true);
        DataOutputStream stream = new DataOutputStream(connection.getOutputStream());
        stream.writeBytes(params);
        stream.flush();
        stream.close();

        // Print response status
        System.out.println("POST status " + connection.getResponseCode());

        // Print response text
        String response;
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        while ((response = reader.readLine()) != null) {
            System.out.println(response);
        }

        reader.close();
    }

}