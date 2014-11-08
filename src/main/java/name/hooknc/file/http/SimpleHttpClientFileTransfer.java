package name.hooknc.file.http;

import name.hooknc.file.FileTransfer;
import name.hooknc.file.TransferFileException;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Component;

@Component
public class SimpleHttpClientFileTransfer implements FileTransfer {

    @Override
    public byte[] transfer(String location) {

        byte[] bytes = null;

        try {

            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(location);
            HttpResponse response = httpclient.execute(httpget);

            bytes = IOUtils.toByteArray(response.getEntity().getContent());

        } catch (Exception e) {

            throw new TransferFileException(e);
        }

        return bytes;
    }
}
