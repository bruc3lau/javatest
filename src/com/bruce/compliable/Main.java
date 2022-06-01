import java.sql.Time;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // String join = CompletableFuture.supplyAsync(() -> {
        // return "hello";
        // }).join();
        // System.out.println(join);

        // CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
        // try {
        // TimeUnit.SECONDS.sleep(1);
        // } catch (Exception e) {
        // // TODO: handle exception
        // }
        // return "hello";
        // });
        // System.out.println(cf.join());

        // ExecutorService threadPool = Executors.newFixedThreadPool(2);
        // CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
        // try {
        // TimeUnit.SECONDS.sleep(1);
        // } catch (Exception e) {
        // // TODO: handle exception
        // }
        // return 1;
        // }, threadPool).thenApply(a -> {
        // System.out.println(a);
        // return a + 2;
        // }).thenApply(a -> {
        // int i = a / 0;
        // return a + 3;
        // }).handle((f, e) -> {
        // System.out.println(f + "====" + e);
        // return f;
        // }).whenComplete((v, e) -> {
        // System.out.println(Thread.currentThread().getName());
        // System.out.println("result:" + v + e);
        // }).exceptionally(a -> {
        // return 1;
        // });

        // System.out.println(cf.join());
        // threadPool.shutdown();

        // System.out.println(CompletableFuture.supplyAsync(() -> 1).join());
        // System.out.println(CompletableFuture.supplyAsync(() -> 1).thenRun(() -> {
        // }).join());
        // System.out.println(CompletableFuture.supplyAsync(() -> 1).thenAccept(f -> {
        // int a = 1;
        // }).join());

        // CompletableFuture.supplyAsync(() -> {

        // });
    }
}
