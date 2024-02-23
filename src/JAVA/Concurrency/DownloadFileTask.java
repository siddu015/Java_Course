package JAVA.Concurrency;


public class DownloadFileTask implements  Runnable{
    private DownloadStatus status;

    public DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading a File:" + Thread.currentThread().getName());

        for(int i = 0; i < 10000; i++) {
            if(Thread.currentThread().isInterrupted()) return;
            status.incrementBytes();
        }

        System.out.println("Download complete:" + Thread.currentThread().getName());

    }
}

