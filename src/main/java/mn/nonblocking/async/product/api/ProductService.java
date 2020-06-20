package mn.nonblocking.async.product.api;

import io.micronaut.scheduling.TaskExecutors;
import io.netty.channel.EventLoopGroup;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

@Singleton
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    private static final Map<String, Product> products = new ConcurrentHashMap();

    @Inject
    @Named(TaskExecutors.IO)
    ExecutorService ioExec;

    static {
        logger.trace("intializing products...");
        products.put("P-001", createProduct("P-001", "Product 1", 12.95, 200));
        products.put("P-002", createProduct("P-002", "Product 2", 22.95, 300));
        products.put("P-003", createProduct("P-003", "Product 3", 42.95, 200));
        products.put("P-004", createProduct("P-004", "Product 4", 28.95, 600));
        products.put("P-005", createProduct("P-005", "Product 5", 10.95, 1200));
        products.put("P-006", createProduct("P-006", "Product 6", 72.95, 300));
    }

    public static Product createProduct(String id, String name, Double price, int latency){
        simulateLatency(latency);
        return new Product(id, name, price);
    }

    private static void simulateLatency(int latency) {
        try {
            logger.trace("sleeping for {} ms", latency);
            Thread.sleep(latency);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Optional<Product> getProduct(String id){

        Completable.fromAction(()->{
            simulateLatency((int) (10000 * Math.random()));
            logger.trace("Inside Action");
        }).subscribeOn(Schedulers.from(ioExec)).subscribe();

        simulateLatency((int) (1000 * Math.random()));
        return Optional.ofNullable(products.get(id));
    }

    public static boolean productExists(String id){
        return products.containsKey(id);
    }

}
