package com.workintech.ecommerce.service.product;

import com.workintech.ecommerce.entity.product.Product;
import com.workintech.ecommerce.repository.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) return productOptional.get();
        //TODO exception handling
        return null;
    }

    @Override
    public Integer getTotalProductNumber() {
        return productRepository.getTotalProductNumber();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> saveAll(List<Product> products) {
        return productRepository.saveAll(products);
    }

    @Override
    public Product delete(Long id) {
        Product product = getProduct(id);
        productRepository.deleteById(id);
        return product;
    }

    @Override
    public List<Product> findByCategoryId(Integer categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<Product> findByRequestParams(Integer categoryId, String sort, String filter) {
        List<Product> productList;

        if (categoryId != null) {
            productList = productRepository.findByCategoryId(categoryId);
        } else {
            productList = productRepository.findAll();
        }

        if (filter != null) {
            productList = productList.stream()
                    .filter(product -> product.getName().toLowerCase().contains(filter.toLowerCase()))
                    .collect(Collectors.toList());
        }

        if (sort != null) {
            String sortBy = sort.split(":")[0];
            String orderBy = sort.split(":")[1];

            Sort.Direction sortDirection = orderBy.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;

            if (sortBy.equalsIgnoreCase("price")) {
                productList.sort((p1, p2) -> {
                    if (sortDirection == Sort.Direction.ASC) {
                        return Double.compare(p1.getPrice(), p2.getPrice());
                    } else {
                        return Double.compare(p2.getPrice(), p1.getPrice());
                    }
                });
            } else if (sortBy.equalsIgnoreCase("rating")) {
                productList.sort((p1, p2) -> {
                    if (sortDirection == Sort.Direction.ASC) {
                        return Double.compare(p1.getRating(), p2.getRating());
                    } else {
                        return Double.compare(p2.getRating(), p1.getRating());
                    }
                });
            }
        }

        return productList;
    }
}
