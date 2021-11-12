package http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ParallelHttpLoader extends HttpLoader {

    @Override
    protected void loadUrlsToStream(CopyOnWriteArrayList<URL> urls, OutputStream outputStream) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(urls.size());
        List<Callable<byte[]>> taskList = new ArrayList<>();
        for(URL url: urls){
            taskList.add(() -> {
                ByteArrayOutputStream tmpStream = new ByteArrayOutputStream();
                ParallelHttpLoader.this.loadUrl(url, tmpStream);
                return tmpStream.toByteArray();
            });
        }
        try {
            List<Future<byte[]>> result = executorService.invokeAll(taskList);
            for(Future<byte[]> future: result){
                outputStream.write(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}
