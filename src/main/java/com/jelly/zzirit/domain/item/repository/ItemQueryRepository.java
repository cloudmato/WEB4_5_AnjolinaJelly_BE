package com.jelly.zzirit.domain.item.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jelly.zzirit.domain.admin.dto.response.AdminItemFetchResponse;
import com.jelly.zzirit.domain.item.dto.request.ItemFilterRequest;
import com.jelly.zzirit.domain.item.dto.response.ItemFetchQueryResponse;
import com.jelly.zzirit.domain.item.entity.Item;

public interface ItemQueryRepository {

	Page<ItemFetchQueryResponse> findItems(
		ItemFilterRequest filter,
		String sort,
		Pageable pageable
	);

	Optional<Item> findItemWithTypeJoin(Long itemId);

	Optional<AdminItemFetchResponse> findAdminItemById(Long itemId);

	Page<AdminItemFetchResponse> findAdminItems(String name, String sort, Pageable pageable);

}
