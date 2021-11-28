package lection13.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;

public class UrlContentReceiver {
    public String receiveURLContents(List<String> links) {
        StringBuilder receiver = new StringBuilder();
        try {
            for (String link: links) {
                URL url = new URL(link);
                if (!isReachable(url))
                    return null;
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    receiver.append(inputLine);
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return receiver.toString();
    }

    private boolean isReachable(URL url) throws IOException {
        HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
        httpUrlConnection.setRequestMethod("HEAD");
        try {
            int responseCode = httpUrlConnection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_OK;
        } catch (UnknownHostException noInternetConnection) {
            return false;
        }
    }
}
