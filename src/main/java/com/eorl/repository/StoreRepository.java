package com.eorl.repository;

import com.eorl.domain.store.Store;
import com.eorl.domain.store.dto.StoreResponseDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends  JpaRepository<Store, Long> {

    List<Store> findByStoreName(String storeName);

}
