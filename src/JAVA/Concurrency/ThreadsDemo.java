package JAVA.Concurrency;

import java.util.*;

public class ThreadsDemo {
    public static void main(String[] args) {

        var status = new DownloadStatus();

        List <Thread> threads = new ArrayList<>();

        for(var i = 0; i < 10; i++){
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);
        }

        for(var thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(status.getTotalBytes());
    }
}


