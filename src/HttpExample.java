import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

class HttpExample {

    void get(String url, ArrayList<Param> params) throws Exception {
        // Build url
        url = url + "?" + buildParams(params);

        // Connection
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

    void post(String url, ArrayList<Param> params) throws Exception {
        // Connection
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

        // Headers
        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        // Send post request
        connection.setDoOutput(true);
        DataOutputStream stream = new DataOutputStream(connection.getOutputStream());
        stream.writeBytes(buildParams(params)); // Add params
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

    // Build params string
    private String buildParams(ArrayList<Param> params){
        StringBuilder stringBuilder = new StringBuilder();

        // Build
        for (Param param : params) {
            stringBuilder.append(param.key);
            stringBuilder.append("=");
            stringBuilder.append(param.value);
            stringBuilder.append("&");
        }
        // remove last '&'
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        return stringBuilder.toString();
    }

}