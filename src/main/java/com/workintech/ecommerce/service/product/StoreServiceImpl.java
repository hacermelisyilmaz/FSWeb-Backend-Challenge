package com.workintech.ecommerce.service.product;

import com.workintech.ecommerce.dto.product.StoreResponse;
import com.workintech.ecommerce.entity.product.Store;
import com.workintech.ecommerce.repository.product.StoreRepository;
import com.workintech.ecommerce.util.Converter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;
    @Override
    public Store getStore(Integer id) {
        Optional<Store> storeOptional = storeRepository.findById(id);
        if (storeOptional.isPresent()) return storeOptional.get();
        return null;
        //TODO handle exception
    }
}
