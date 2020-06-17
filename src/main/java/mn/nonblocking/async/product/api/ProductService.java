package mn.nonblocking.async.product.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    private static final Map<String, Product> products = new ConcurrentHashMap();

    static {
        logger.trace("intializing products...");
        products.put("P-001", createProduct("P-001", "Product 1", 12.95));
        products.put("P-002", createProduct("P-002", "Product 2", 22.95));
    }

    public static Product createProduct(String id, String name, Double price){
        return new Product(id, name, price);
    }

    public static Optional<Product> getProduct(String id){
        return Optional.ofNullable(products.get(id));
    }

    public static boolean productExists(String id){
        return products.containsKey(id);
    }

}
