import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class Dreamy {
    private Base64.Encoder encoder = Base64.getEncoder();
    private String id = null;
    private String pw = null;
    private String uri = "https://dreamy.jejunu.ac.kr";
    private URL url = null;
    private String line = null;

    public Dreamy(String id, String pw){
        this.id = this.encoder.encodeToString(id.getBytes());
        this.pw = this.encoder.encodeToString(pw.getBytes());
    }


    public HttpsURLConnection login() throws IOException {
        String body = "/frame/sysUser.do?next=";
        String param = "&tmpu=" + this.id + "&tmpw=" + this.pw + "&mobile=n&app=null&z=Y&userid=&password=";url = new URL(this.uri + body);
        url = new URL(uri + body + param);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

        return conn;
    }

    public void getSooup(HttpsURLConnection conn) throws IOException {
        String body = "/susj/su/sta_su_8331r.jejunu" ;
        url = new URL(this.uri + body);

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
        while((line = br.readLine()) != null ){
            System.out.println(line);
        }
    }
}