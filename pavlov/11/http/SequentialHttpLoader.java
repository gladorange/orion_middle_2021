package http;

import java.io.*;
import java.net.URL;
import java.util.concurrent.CopyOnWriteArrayList;

public class SequentialHttpLoader extends HttpLoader {

    @Override
    protected void loadUrlsToStream(CopyOnWriteArrayList<URL> urls, OutputStream outputStream) throws IOException{
        for(URL url: urls){
            loadUrl(url, outputStream);
        }
    }

}
