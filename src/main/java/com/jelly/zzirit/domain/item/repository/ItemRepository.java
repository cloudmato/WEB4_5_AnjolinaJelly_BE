package com.jelly.zzirit.domain.item.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import com.jelly.zzirit.domain.item.entity.Item;
import com.jelly.zzirit.global.dto.BaseResponseStatus;
import com.jelly.zzirit.global.exception.custom.InvalidItemException;

import jakarta.persistence.LockModeType;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Query("select i from Item i where i.id = :itemId")
    Optional<Item> findByIdPessimisticLock(Long itemId);

    default Item getById(Long itemId) {
        return findById(itemId).orElseThrow(() -> new InvalidItemException(BaseResponseStatus.ITEM_NOT_FOUND));
    }
}