package pl.andus.cAPI;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Download {
    public void DownloadFile(URL url, String outputName) throws IOException {
        try (InputStream in = url.openStream();
             ReadableByteChannel rbc = Channels.newChannel(in);
             FileOutputStream fos = new FileOutputStream(outputName)) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }

    public void UpdateCheck(String updateURL, String versionNow) throws IOException {
        URL url = new URL(updateURL);
        URLConnection urlC = url.openConnection();

        BufferedReader reader = new BufferedReader(new InputStreamReader(urlC.getInputStream()));
        String versionUrl = reader.toString();
        if (versionNow.equals(versionUrl)) {
            Logging.info("Versions are the same");
        } else {
            Logging.info("It seems that there is a different newer version (" + versionUrl + ")");
        }
    }
}
