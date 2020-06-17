package mn.nonblocking.async.product.service.api;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import mn.nonblocking.async.product.api.Product;

interface ProductCommon {
    String BASE_PATH = "/products";

    @Get
    HttpResponse getProducts();

    @Get("/{id}")
    HttpResponse<Product> getProduct(@PathVariable("id") String id);

    @Post
    HttpResponse createProduct(Product product);
}
