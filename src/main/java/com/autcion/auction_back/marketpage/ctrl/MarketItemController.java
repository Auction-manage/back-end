package com.autcion.auction_back.marketpage.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.autcion.auction_back.marketpage.DTO.MarketImageDTO;
import com.autcion.auction_back.marketpage.DTO.MarketItemDTO;
import com.autcion.auction_back.marketpage.service.MarketItemService;

import java.util.List;
import org.springframework.http.HttpHeaders;


@RestController
@RequestMapping("/marketItems")
public class MarketItemController {

    @Autowired
    private MarketItemService marketItemService;

    // 구매 가능 리스트 조회
    @GetMapping
    public ResponseEntity<List<MarketItemDTO>> getTradeCount(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        List<MarketItemDTO> items = marketItemService.getAvailableItems();
        return ResponseEntity.ok(items);
    }

    // 정찰 물품 상세 조회
    @GetMapping("/{itemId}/detail")
    public ResponseEntity<MarketItemDTO> getMarketItemDetail(@PathVariable int itemId) {
        MarketItemDTO item = marketItemService.getMarketItemDetail(itemId);
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(item);
    }

    // 정찰 물품 등록
    @PostMapping("/new")
    public ResponseEntity<MarketItemDTO> createMarketItem(@RequestBody MarketItemDTO itemDTO) {
        MarketItemDTO createdItem = marketItemService.insertMarketItem(itemDTO);
        return ResponseEntity.ok(createdItem);
    }

    // 정찰 물품 수정
    @PutMapping("/{itemId}/edit")
    public ResponseEntity<MarketItemDTO> updateMarketItem(@PathVariable int itemId,
                                                          @RequestBody MarketItemDTO itemDTO) {
        itemDTO.setItem_id(itemId);
        MarketItemDTO updatedItem = marketItemService.updateMarketItem(itemDTO);
        return ResponseEntity.ok(updatedItem);
    }

    // 정찰 물품 삭제
    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteMarketItem(@PathVariable int itemId) {
        marketItemService.deleteMarketItem(itemId);
        return ResponseEntity.noContent().build();
    }

    // 정찰 물품 구매 (status 변경)
    @PostMapping("/{itemId}/purchase")
    public ResponseEntity<Void> purchaseMarketItem(@PathVariable int itemId) {
        marketItemService.purchaseMarketItem(itemId);
        return ResponseEntity.ok().build();
    }

    // --- 정찰 물품 이미지 관리 ---
    // 이미지 저장
    @PostMapping("/{itemId}/images")
    public ResponseEntity<Void> insertMarketImage(@PathVariable int itemId,
                                                  @RequestBody MarketImageDTO imageDTO) {
        imageDTO.setItem_id(itemId);
        marketItemService.insertMarketImage(imageDTO);
        return ResponseEntity.ok().build();
    }

    // 이미지 조회
    @GetMapping("/new")
    public ResponseEntity<List<MarketImageDTO>> getMarketImages(@PathVariable int itemId) {
        List<MarketImageDTO> images = marketItemService.getMarketImagesByItemId(itemId);
        return ResponseEntity.ok(images);
    }

    // 이미지 수정
    @PutMapping("/{itemId}/edit")
    public ResponseEntity<Void> updateMarketImage(@PathVariable long imageId,
                                                  @RequestBody MarketImageDTO imageDTO) {
        imageDTO.setImage_id(imageId);
        marketItemService.updateMarketImage(imageDTO);
        return ResponseEntity.ok().build();
    }

    // 이미지 삭제
    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteMarketImage(@PathVariable long imageId) {
        marketItemService.deleteMarketImage(imageId);
        return ResponseEntity.noContent().build();
    }
}