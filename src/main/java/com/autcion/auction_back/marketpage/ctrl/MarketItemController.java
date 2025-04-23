package com.autcion.auction_back.marketpage.ctrl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autcion.auction_back.marketpage.DTO.MarketImageDTO;
import com.autcion.auction_back.marketpage.DTO.MarketItemDTO;
import com.autcion.auction_back.marketpage.service.MarketItemService;

@RestController
@RequestMapping("/virtualmarket/{marketId}")
public class MarketItemController {

    @Autowired
    private MarketItemService marketItemService;

    // 구매 가능 리스트 조회
    @GetMapping("/list")
    public ResponseEntity<List<MarketItemDTO>> marketItemList(@PathVariable("marketId") int marketId) {

        System.out.println("debug >>> marketItemController marketItemList marketId: " + marketId);   

        List<MarketItemDTO> items = marketItemService.marketItemList(marketId);

        System.out.println("debug >>> marketItemController marketItemList items: " + items);

        return ResponseEntity.ok(items);
    }

    // 정찰 물품 상세 조회
    @GetMapping("/detail/{itemId}")
    public ResponseEntity<MarketItemDTO> getMarketItemDetail(@PathVariable("itemId") int itemId) {

        System.out.println("debug >>> marketItemController getMarketItemDetail " + itemId);

        MarketItemDTO item = marketItemService.getMarketItemDetail(itemId);

        System.out.println("debug >>> marketItemController getMarketItemDetail item: " + item);

        if (item == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(item);
    }

    // 정찰 물품 등록
    @PostMapping("/new")
    public ResponseEntity<MarketItemDTO> createMarketItem(@PathVariable("marketId") int marketId, @RequestBody MarketItemDTO itemDTO) {

        System.out.println("debug >>> marketItemController createMarketItem marketId: " + marketId);
        System.out.println("debug >>> marketItemController createMarketItem itemDTO: " + itemDTO);

        itemDTO.setMarket_id(marketId);
        
        MarketItemDTO createdItem = marketItemService.createMarketItem(itemDTO);

        System.out.println("debug >>> marketItemController createMarketItem createdItem: " + createdItem);

        if (createdItem == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(createdItem);
    }

    // 정찰 물품 수정
    @PutMapping("/edit/{itemId}")
    public ResponseEntity<MarketItemDTO> updateMarketItem(@PathVariable("itemId") int itemId,
            @RequestBody MarketItemDTO itemDTO) {

        System.out.println("debug >>> marketItemController updateMarketItem itemDTO: " + itemDTO);

        Map<String, Object> userInfo = getUserInfo();

        int userId = (int) userInfo.get("user_id");

        itemDTO.setItem_id(itemId);

        MarketItemDTO updatedItem = marketItemService.updateMarketItem(itemDTO);

        return ResponseEntity.ok(updatedItem);
    }

    // 정찰 물품 삭제
    @DeleteMapping("/remove/{itemId}")
    public ResponseEntity<Void> deleteMarketItem(@PathVariable("itemId") int itemId) {

        System.out.println("debug >>> marketItemController deleteMarketItem itemId: " + itemId);

        String response = marketItemService.deleteMarketItem(itemId);

        System.out.println("debug >>> marketItemController deleteMarketItem itemId: " + response);

        if (response.equals("success")) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }

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

    // 이미지 조회 - URL 수정
    @GetMapping("/{itemId}/images")
    public ResponseEntity<List<MarketImageDTO>> getMarketImages(@PathVariable int itemId) {
        List<MarketImageDTO> images = marketItemService.getMarketImagesByItemId(itemId);
        return ResponseEntity.ok(images);
    }

    // 이미지 수정 - URL 수정
    @PutMapping("/{itemId}/edit/image")
    public ResponseEntity<Void> updateMarketImage(@PathVariable long imageId,
            @RequestBody MarketImageDTO imageDTO) {
        imageDTO.setImage_id(imageId);
        marketItemService.updateMarketImage(imageDTO);
        return ResponseEntity.ok().build();
    }

    // 이미지 삭제 - URL 수정
    @DeleteMapping("/{itemId}/image")
    public ResponseEntity<Void> deleteMarketImage(@PathVariable long imageId) {
        marketItemService.deleteMarketImage(imageId);
        return ResponseEntity.noContent().build();
    }

    private Map<String, Object> getUserInfo() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();

        System.out.println("debug >>>> user_info " + userInfo);

        return userInfo;
    }
}