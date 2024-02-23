package JAVA.Concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class DownloadStatus {

    private AtomicInteger totalBytes = new AtomicInteger();
    public int getTotalBytes() {
        return totalBytes.get();
    }

    public void incrementBytes() {
        totalBytes.incrementAndGet();
    }

}