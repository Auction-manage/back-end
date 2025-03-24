package com.autcion.auction_back.auctionpage.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.autcion.auction_back.auctionpage.DTO.AuctionImageDTO;
import com.autcion.auction_back.auctionpage.DTO.AuctionItemDTO;
import com.autcion.auction_back.auctionpage.service.AuctionItemService;
import com.autcion.auction_back.common.BidsDTO;
import com.autcion.auction_back.common.ConsignmentDTO;

import java.util.List;

@RestController
@RequestMapping("/auction")
public class AuctionItemController {

    @Autowired
    private AuctionItemService auctionItemService;

    // 경매 물품 구매 가능 리스트 조회
    @GetMapping
    public ResponseEntity<List<AuctionItemDTO>> getActiveAuctionItems() {
        List<AuctionItemDTO> items = auctionItemService.getActiveAuctionItems();
        return ResponseEntity.ok(items);
    }

    // 경매 물품 상세 조회
    @GetMapping("/{itemId}/detail")
    public ResponseEntity<AuctionItemDTO> getAuctionItemDetail(@PathVariable int itemId) {
        AuctionItemDTO item = auctionItemService.getAuctionItemDetail(itemId);
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(item);
    }

    // 경매 물품 등록
    @PostMapping("/new")
    public ResponseEntity<AuctionItemDTO> createAuctionItem(@RequestBody AuctionItemDTO itemDTO) {
        AuctionItemDTO createdItem = auctionItemService.insertAuctionItem(itemDTO);
        return ResponseEntity.ok(createdItem);
    }

    // 경매 물품 상세 정보 수정
    @PutMapping("/{itemId}/edit")
    public ResponseEntity<AuctionItemDTO> updateAuctionItem(@PathVariable int itemId,
                                                            @RequestBody AuctionItemDTO itemDTO) {
        itemDTO.setItem_id(itemId);
        AuctionItemDTO updatedItem = auctionItemService.updateAuctionItem(itemDTO);
        return ResponseEntity.ok(updatedItem);
    }

    // 경매 물품 삭제
    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteAuctionItem(@PathVariable int itemId) {
        auctionItemService.deleteAuctionItem(itemId);
        return ResponseEntity.noContent().build();
    }

    // 경매 물품 입찰
    @PostMapping("/{itemId}/bid")
    public ResponseEntity<Void> placeBid(@PathVariable int itemId, @RequestBody BidsDTO bidDTO) {
        bidDTO.setItem_id(itemId);
        auctionItemService.placeBid(bidDTO);
        return ResponseEntity.ok().build();
    }

    // 경매 물품 구매 (상태 변경)
    @PostMapping("/{itemId}/purchase")
    public ResponseEntity<Void> purchaseAuctionItem(@PathVariable int itemId) {
        auctionItemService.purchaseAuctionItem(itemId);
        return ResponseEntity.ok().build();
    }

    // 위탁 판매 등록
    @PostMapping("/new")
    public ResponseEntity<Void> registerConsignmentSale(@RequestBody ConsignmentDTO consignmentDTO) {
        auctionItemService.registerConsignmentSale(consignmentDTO);
        return ResponseEntity.ok().build();
    }

    // 위탁 구매 신청 (상태 업데이트)
    @PutMapping("/consignment/purchase")
    public ResponseEntity<Void> applyConsignmentPurchase(@RequestBody ConsignmentDTO consignmentDTO) {
        auctionItemService.applyConsignmentPurchase(consignmentDTO);
        return ResponseEntity.ok().build();
    }

    // --- 경매 물품 이미지 관리 ---
    // 이미지 저장
    @PostMapping("/{itemId}/images")
    public ResponseEntity<Void> insertAuctionImage(@PathVariable int itemId,
                                                   @RequestBody AuctionImageDTO imageDTO) {
        imageDTO.setItem_id(itemId);
        auctionItemService.insertAuctionImage(imageDTO);
        return ResponseEntity.ok().build();
    }

    // 이미지 조회
    @GetMapping("/detail/{itemId}/images")
    public ResponseEntity<List<AuctionImageDTO>> getAuctionImages(@PathVariable int itemId) {
        List<AuctionImageDTO> images = auctionItemService.getAuctionImagesByItemId(itemId);
        return ResponseEntity.ok(images);
    }

    // 이미지 수정
    @PutMapping("/{itemId}/edit")
    public ResponseEntity<Void> updateAuctionImage(@PathVariable long imageId,
                                                   @RequestBody AuctionImageDTO imageDTO) {
        imageDTO.setImage_id(imageId);
        auctionItemService.updateAuctionImage(imageDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteAuctionImage(@PathVariable long imageId) {
        auctionItemService.deleteAuctionImage(imageId);
        return ResponseEntity.noContent().build();
    }
}
