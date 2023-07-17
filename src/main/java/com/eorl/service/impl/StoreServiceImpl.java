package com.eorl.service.impl;

import com.eorl.domain.store.Store;
import com.eorl.domain.store.dto.StoreRequestDto;
import com.eorl.domain.store.dto.StoreRequestDto.StoreBuilder;
import com.eorl.domain.store.dto.StoreResponseDto;
import com.eorl.repository.StoreRepository;
import com.eorl.service.StoreService;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService  {

    private final StoreRepository storeRepository;
    private final EntityManager entityManager;
    @Transactional
    @Override
    public void saveStore(StoreRequestDto storeRequestDto) {
        storeRepository.save(storeRequestDto.StoreRequestDto());
    }

    @Override
    public List<StoreResponseDto> getStoreList(Integer pageNum) {

        List<Store> all = storeRepository.findAll();
        List<StoreResponseDto> storeResponseDtoList = new ArrayList<>();

        for (Store store : all) {
            StoreResponseDto responseDto = getResponseDtoBuilder(store);
            storeResponseDtoList.add(responseDto);
        }

        return storeResponseDtoList;
    }

    @Override
    public StoreResponseDto getStore(Long id) {
        Optional<Store> storeWrapper = storeRepository.findById(id);
        Store store = storeWrapper.get();

        return getResponseDtoBuilder(store);
    }


    @Override
    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }

    @Override
    public List<StoreResponseDto> searchStoreList(String storeName) {
        List<Store> byStoreName = storeRepository.findByStoreName(storeName);
        List<StoreResponseDto> responseDtoList = new ArrayList<>();
        for (Store store : byStoreName) {
            responseDtoList.add(getResponseDtoBuilder(store) );
        }
        return responseDtoList;
    }

    @Override
    public void update(Long id, StoreRequestDto dto) {

        Store store = entityManager.find(Store.class, dto.getStoreId());
        store.setStoreName(dto.getStoreName());
        store.setStoreStatus(dto.getStoreStatus());
        store.setBusinessNumber(dto.getBusinessNumber());
        store.setAddressMain(dto.getAddressMain());
        store.setAddressDetail(dto.getAddressDetail());
        store.setPhoneNumber(dto.getPhoneNumber());
        store.setStoreImageUrl(dto.getStoreImageUrl());
        store.setLocation(dto.getLocation());
        
        //update 후 select시 영속성 컨텍스트에 값이 남아있어 즉시 반영 처리
        entityManager.clear();
        entityManager.flush();
    }

    private static StoreResponseDto getResponseDtoBuilder(Store store) {
        return StoreResponseDto.builder()
                .storeName(store.getStoreName())
                .storeStatus(store.getStoreStatus())
                .businessNumber(store.getBusinessNumber())
                .addressMain(store.getAddressMain())
                .addressDetail(store.getAddressDetail())
                .phoneNumber(store.getPhoneNumber())
                .storeImageUrl(store.getStoreImageUrl())
                .location(store.getLocation())
                .build();
    }
}
