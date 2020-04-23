import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Date;

public class Dreamy {
    private Base64.Encoder encoder = Base64.getEncoder();
    private String id = null;
    private String pw = null;
    private String uri = "https://dreamy.jejunu.ac.kr/";
    private URL url = null;
    private String line = null;

    public Dreamy(String id, String pw){
        this.id = this.encoder.encodeToString(id.getBytes());
        this.pw = this.encoder.encodeToString(pw.getBytes());
    }


    public void login() throws IOException {
        String body = "frame/sysUser.do?next=";
        String param = "&tmpu=" + this.id + "&tmpw=" + this.pw + "&mobile=n&app=null&z=Y&userid=&password=";
        url = new URL(uri + body + param);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        System.out.println(conn.getURL());
    }

    public void getInfo() throws IOException {
        String body = "hjju/hj/sta_hj_1010q.jejunu";
        String param = "mode=doValue&student_no=" + this.id + "&_=";
        url = new URL(uri + body);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");
        conn.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(param);
        wr.flush();
        wr.close();

        int responseCode = conn.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(responseCode);
        System.out.println(response.toString());
    }

    public void getSooup() throws IOException {
        String body = "susj/su/sta_su_8331r.jejunu" ;
        url = new URL(this.uri + body);
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
//        while((line = br.readLine()) != null ){
//            System.out.println(line);
//        }
    }
}