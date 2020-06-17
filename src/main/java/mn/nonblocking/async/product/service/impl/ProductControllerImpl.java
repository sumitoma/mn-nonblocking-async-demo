package mn.nonblocking.async.product.service.impl;

import io.micronaut.http.HttpResponse;
import mn.nonblocking.async.product.api.Product;
import mn.nonblocking.async.product.api.ProductService;
import mn.nonblocking.async.product.service.api.ProductController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Optional;

public class ProductControllerImpl implements ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductControllerImpl.class);

    private final ProductService productService;

    @Inject
    ProductControllerImpl(ProductService productService){
        this.productService = productService;
    }

    @Override
    public HttpResponse getProducts() {
        return null;
    }

    @Override
    public HttpResponse<Product> getProduct(String productId){
        logger.trace("returning product details");
        Optional<Product> product = productService.getProduct(productId);
        if(product.isPresent())
            return HttpResponse.ok(product.get());
        else
            return HttpResponse.notFound();
    }

    @Override
    public HttpResponse createProduct(Product product) {
        return null;
    }

}
