package application.utils;

import application.dto.RequestResponseDTO;
import application.exceptions.NoSuchUserException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by mj on 31/5/16.
 */
public class HttpUtils {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String AUTHORIZATION = "authorization";
    private static final String AUTHENTICATION = "authorization";
    private static final String USER_AGENT_STR = "remote-host";

    private static JacksonUtils jacksonUtils = new JacksonUtils();

    public static RequestResponseDTO postData(String testBackendUrl, String authToken, String requestMethod, Object testClass) throws NoSuchUserException {
        StringBuffer response = new StringBuffer();
        try {
            URL obj = new URL(testBackendUrl);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod(requestMethod);
            if (authToken != null && !authToken.isEmpty()) {
                con.setRequestProperty(AUTHORIZATION, authToken);
            } else {
                throw new NoSuchUserException();
            }
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty(USER_AGENT_STR, USER_AGENT);
            con.getOutputStream().write(jacksonUtils.toJson(testClass).getBytes("UTF-8"));
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response.toString());
//                return response.toString();
            } else {
                System.out.println("GET request not worked");
            }
            String responseStr = response.toString();
            RequestResponseDTO requestResponseDTO = new ObjectMapper().readValue(responseStr, RequestResponseDTO.class);
            return requestResponseDTO;
        } catch (IOException e) {
            System.out.println("Could not process Request : " + e.getMessage());
        }
        return null;
    }

}
