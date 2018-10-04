package hello;

import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * 注意模拟浏览器客户端User-Agent
 * 多媒体文件使用字符编码为ISO-8859-1
 */

public class MyTest {

    @Test
    public void test() {

        String url = "http://img4.cache.netease.com/photo/0001/2014-09-30/A7CK9R1D00AN0001.jpg";
        String path = "D:\\tmp\\si\\si.jpg";

        download(url, path);

    }

    private void download(String _url, String path) {
        try {
            URL url = new URL(_url);
            URLConnection con = url.openConnection();
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");

            con.setConnectTimeout(5000);
            InputStream is = con.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.ISO_8859_1));
            File sf = new File(path);
            OutputStream os = new FileOutputStream(sf);
            OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.ISO_8859_1);
            // 长度不可太大，否则图片扭曲变形
            int len = 5;
            char[] cbuf = new char[len];
            int off = 0;
            while (br.read(cbuf, off, len) != -1) {
                osw.write(cbuf, off, len);
            }

            osw.close();
            os.close();
            br.close();
            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
