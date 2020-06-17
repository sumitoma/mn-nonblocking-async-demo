package mn.nonblocking.async.product.service.api;

import io.micronaut.http.client.annotation.Client;

@Client(ProductCommon.BASE_PATH)
public interface ProductClient extends ProductCommon{
}
