package hello;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class CustomRequestFactory extends SimpleClientHttpRequestFactory {

    protected HttpURLConnection openConnection(URL url, @Nullable Proxy proxy) throws IOException {
        URLConnection urlConnection = (proxy != null ? url.openConnection(proxy) : url.openConnection());
        if (!HttpURLConnection.class.isInstance(urlConnection)) {
            throw new IllegalStateException("HttpURLConnection required for [" + url + "] but got: " + urlConnection);
        }
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
        return (HttpURLConnection) urlConnection;
    }
}
