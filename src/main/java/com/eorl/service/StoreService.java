package com.eorl.service;

import com.eorl.domain.store.dto.StoreRequestDto;
import com.eorl.domain.store.dto.StoreResponseDto;
import java.util.List;

public interface StoreService {

    public void saveStore(StoreRequestDto storeRequestDto);

    public List<StoreResponseDto> getStoreList(Integer pageNum);

    public StoreResponseDto getStore(Long id);

    public void deleteStore(Long id);

    public List<StoreResponseDto> searchStoreList(String keyword);

    public void update(Long id, StoreRequestDto dto);
}
