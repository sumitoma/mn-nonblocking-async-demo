package mn.nonblocking.async.product.service.api;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.reactivex.Maybe;
import io.reactivex.Single;
import mn.nonblocking.async.product.api.Product;

interface ProductCommon {
    String BASE_PATH = "/products";

    @Get
    HttpResponse getProducts();

    @Get(value = "/{id}", produces = {MediaType.APPLICATION_JSON})
    HttpResponse<Product> getProduct(@PathVariable("id") String id);

    @Post
    HttpResponse createProduct(Product product);
}
