package me.ymir.wa.checkers;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Locale;

public class TurkishChecker implements IChecker {
    @Override
    public boolean isWord(String word) {
        try {
            URL url = new URL("https://sozluk.gov.tr/yazim?ara="+word);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestProperty("User-Agent","WordsAPI");
            con.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            return !br.readLine().startsWith("{\"error\":");
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public Locale getLocale() {
        return Locale.getDefault();
    }
}
