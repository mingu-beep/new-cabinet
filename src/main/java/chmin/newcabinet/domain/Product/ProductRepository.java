package chmin.newcabinet.domain.Product;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {

    private static final Map<Long, Product> store = new HashMap<>();
    private static Long sequence = 0L;

    public Product save(Product product) {
        product.setId(++sequence);
        store.put(product.getId(), product);
        return product;
    }

    public Product findById(Long id) {
        return store.get(id);
    }

    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long productId, Product updateParam) {
        Product findProduct = findById(productId);

        findProduct.setProductName(updateParam.getProductName());
        findProduct.setPrice(updateParam.getPrice());
        findProduct.setBoard(updateParam.getBoard());
        findProduct.setDealType(updateParam.getDealType());
        findProduct.setCategory(updateParam.getCategory());
        findProduct.setImage(updateParam.getImage());
        findProduct.setLocation(updateParam.getLocation());
    }

    public void deleteById(Long productId) {
        store.remove(productId);
    }

    public void clearStore() {
        store.clear();
    }
}
