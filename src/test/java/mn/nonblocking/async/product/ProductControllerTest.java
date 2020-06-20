package mn.nonblocking.async.product;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.test.annotation.MicronautTest;
import mn.nonblocking.async.product.api.Product;
import mn.nonblocking.async.product.service.api.ProductClient;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class ProductControllerTest {

    @Inject
    private ProductClient productClient;

    @Test
    void testGetProduct(){
//        HttpResponse<Product> httpResponse = productClient.getProduct("P-001");
//        assertEquals(HttpStatus.OK.getCode(), httpResponse.getStatus().getCode());
//        assertEquals("P-001", httpResponse.body().getId());
    }
}
