package SockV2;

// 공통 유틸 Class

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import static net.dv8tion.jda.internal.requests.Requester.USER_AGENT;

public class Util {

    /**
     * @param pURL : 요청 URL
     * @param pList : 파라미터 객체 (HashMap<String,String>)
     */
    public static String postRequest(String pURL, HashMap< String, String > pList) {

        String myResult = "";

        try {
            //   URL 설정하고 접속하기
            URL url = new URL(pURL); // URL 설정

            HttpURLConnection http = (HttpURLConnection) url.openConnection(); // 접속
            //--------------------------
            //   전송 모드 설정 - 기본적인 설정
            //--------------------------
            http.setDefaultUseCaches(false);
            http.setDoInput(true); // 서버에서 읽기 모드 지정
            http.setDoOutput(true); // 서버로 쓰기 모드 지정
            http.setRequestMethod("POST"); // 전송 방식은 POST



            //--------------------------
            // 헤더 세팅
            //--------------------------
            // 서버에게 웹에서 <Form>으로 값이 넘어온 것과 같은 방식으로 처리하라는 걸 알려준다
            http.setRequestProperty("content-type", "application/x-www-form-urlencoded");


            //--------------------------
            //   서버로 값 전송
            //--------------------------
            StringBuilder buffer = new StringBuilder();

            //HashMap으로 전달받은 파라미터가 null이 아닌경우 버퍼에 넣어준다
            if (pList != null) {

                Set<String> key = pList.keySet();

                for (String keyName : key) {
                    String valueName = pList.get(keyName);
                    buffer.append(keyName).append("=").append(valueName);
                }
            }

            OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), StandardCharsets.UTF_8);
            PrintWriter writer = new PrintWriter(outStream);
            writer.write(buffer.toString());
            writer.flush();


            //--------------------------
            //   Response Code
            //--------------------------
            //http.getResponseCode();


            //--------------------------
            //   서버에서 전송받기
            //--------------------------
            InputStreamReader tmp = new InputStreamReader(http.getInputStream(), StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(tmp);
            StringBuilder builder = new StringBuilder();
            String str;
            while ((str = reader.readLine()) != null) {
                builder.append(str).append("\n");
            }
            myResult = builder.toString();
            return myResult;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return myResult;
    }

    // HTTP POST request
    public static String sendPost(String targetUrl, String parameters) throws Exception {
        URL url = new URL(targetUrl);
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

        con.setRequestMethod("POST"); // HTTP POST 메소드 설정
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setDoOutput(true); // POST 파라미터 전달을 위한 설정

        // Send post request
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(parameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        return response.toString();
    }

}
