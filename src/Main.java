import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String id = "2017108249";
        String pw = "pw";
        Dreamy dreamy = new Dreamy(id, pw);
        dreamy.login();
        dreamy.getHakjuk();
    }
}
