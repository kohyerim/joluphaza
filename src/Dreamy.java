import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

public class Dreamy {
    private Base64.Encoder encoder = Base64.getEncoder();
    private String id = null;
    private String pw = null;
    private String uri = "https://dreamy.jejunu.ac.kr";
    private String body = "";
    private URL url = null;

    public Dreamy(String id, String pw){
        this.id = this.encoder.encodeToString(id.getBytes());
        this.pw = this.encoder.encodeToString(pw.getBytes());
    }


    public void login() throws IOException {
        this.body = "/frame/sysUser.do?next=" + "&tmpu=" + this.id + "&tmpw=" + this.pw + "&app=null&z=Y&userid=&password=";
        url = new URL(this.uri + this.body);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

        //System.out.println(conn);

    }

    public void getHakjuk(){
        this.body = "/hjju/hj/sta_hj_1010q.jejunu";
    }
}