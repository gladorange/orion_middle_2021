package lection11.task1;
//Homework for lecture 11
//Parallel measurements
//Salmov Evgeniy

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

enum DownloadType{
    SEQUENTIALLY("sequentially"), IN_PARALLEL("in parallel");
    private final String name;
    DownloadType(String name){
        this.name = name;
    }
    public String getName(){ return name;}
}

public class Task1 {

    public static void main(String[] args) {
        List<String> links = getLinks();
        receiveSitesContent(links, DownloadType.IN_PARALLEL);
        receiveSitesContent(links, DownloadType.SEQUENTIALLY);
    }

    private static void receiveSitesContent(List<String> links, DownloadType type) {
        System.out.println("Let's read sites content "+type.getName()+"!");
        long start = System.nanoTime();
        ConcurrentHashMap<String,String> linksContent = (type == DownloadType.SEQUENTIALLY)? getContentSequentially(links) : getContentInParallel(links);
        long bytesReceived = links.stream().mapToLong(s->(linksContent.get(s)).getBytes(StandardCharsets.UTF_8).length).sum();
        System.out.println("Downloading "+ links.size()+" sites "+type.getName()+" took:" + (System.nanoTime() - start) + " ns, total bytes received " + bytesReceived);
        writeToFile(links, linksContent, (type == DownloadType.SEQUENTIALLY)?"sequential.txt":"parallel.txt");
    }

    private static ConcurrentHashMap<String, String> getContentInParallel(List<String> links) {
        ConcurrentHashMap<String,String> linksContentPar = new ConcurrentHashMap<>(links.size(),100.0f, links.size());
        List<Future<Integer>> results = new ArrayList<>();
        try {
            final ExecutorService executorService = Executors.newFixedThreadPool(links.size());
            for (String link: links) {
                results.add(executorService.submit(() -> {
                        StringBuilder sb = new StringBuilder();
                        getContent(link, sb);
                        linksContentPar.put(link, sb.toString());
                        return 1;
                    })
                );
            }
            int finishedCnt = 0;
            for( Future<Integer> result: results) {
                finishedCnt += result.get();
            }
            executorService.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linksContentPar;
    }

    private static ConcurrentHashMap<String,String> getContentSequentially(List<String> links) {
        ConcurrentHashMap<String,String> content = new ConcurrentHashMap<>(links.size(),100.0f, 1);
        for (String link: links) {
            StringBuilder sb =new StringBuilder();
            try {
                getContent(link, sb);
            } catch (Exception e) {
                e.printStackTrace();
            }
            content.put(link, sb.toString());
        }
        return content;
    }

    private static void getContent(String link, StringBuilder receiver) throws IOException {
        URL url = new URL(link);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            receiver.append(inputLine);
        in.close();
    }

    private static void writeToFile(List<String> links, Map<String, String> linksContent, String fileName) {
        try {
            File file = new File(fileName);
            if(file.exists())
                if(!file.delete()){
                    System.out.println("Couldn't delete existing file! Something is wrong");
                    return;
                }
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            for (String link: links) {
                bufferWriter.write("\n\n===== НАЧАЛО САЙТА "+link +" ======\n\n");
                bufferWriter.write(linksContent.get(link));
                bufferWriter.write("\n\n===== КОНЕЦ САЙТА "+link +" ======\n\n");
            }
            bufferWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> getLinks() {
        return new ArrayList<>(
                Arrays.asList(
                        "https://habr.com/ru/company/luxoft/blog/157273/",
                        "http://java-online.ru/java-thread.xhtml",
                        "http://java-online.ru/concurrent-collections.xhtml",
                        "https://docs.oracle.com/javase/tutorial/collections/streams/parallelism.html",
                        "https://dataart.team/ru/articles/mnogopotochnost-v-java-lekfiya-5-atomarnye-peremennye-i-mnogopotochnye-kollekfii/",
                        "https://javarush.ru/quests/lectures/questmultithreading.level06.lecture09",
                        "https://stackoverflow.blog/2021/07/05/best-practices-for-writing-code-comments/",
                        "https://javarush.ru/groups/posts/605-junit",
                        "https://maven.apache.org",
                        "https://javarush.ru/groups/posts/2523-chastjh-4osnovih-maven",
                        "https://habr.com/ru/post/444982/",
                        "https://habr.com/ru/post/77382/",
                        "https://javarush.ru/groups/posts/513-reflection-api-refleksija-temnaja-storona-java",
                        "http://java-online.ru/java-reflection.xhtml",
                        "https://site.mockito.org",
                        "https://java-course.ru/begin/reflection/",
                        "https://habr.com/ru/company/sberbank/blog/416413/",
                        "https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/package-summary.html",
                        "https://docs.oracle.com/javase/tutorial/java/generics/types.html",
                        "https://javarush.ru/groups/posts/845-lambda-vihrazhenija-na-primerakh"
                )
        );
    }
}
