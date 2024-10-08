package com.tiffy;

import com.tiffy.constant.ItemCategory;
import com.tiffy.entity.Item;
import com.tiffy.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
public class TestDataInit {

    private final ItemRepository itemRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initDate() {
        for (int i = 1; i < 200; i++) {
            itemRepository.save(Item.builder()
                    .itemNm("등록 상품" + i)
                    .itemCategory(ItemCategory.FRUIT)
                    .sellerId("seller" + i)
                    .sellerNm("sellerNm" + i)
                    .price(1000 + i)
                    .stockNumber(1)
                    .itemDetail("상품 세부 설명")
                    .build());
        }
    }
}
