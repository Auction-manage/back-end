package com.autcion.auction_back.auctionpage.ctrl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autcion.auction_back.auctionpage.DTO.AuctionImageDTO;
import com.autcion.auction_back.auctionpage.DTO.AuctionItemDTO;
import com.autcion.auction_back.auctionpage.service.AuctionItemService;
import com.autcion.auction_back.common.BidsDTO;
import com.autcion.auction_back.common.ConsignmentDTO;

@RestController
@RequestMapping("/auction")
public class AuctionItemController {

    @Autowired
    private AuctionItemService auctionItemService;

    // 경매 물품 구매 가능 리스트 조회
    @GetMapping("/list")
    public ResponseEntity<List<AuctionItemDTO>> getAuctionList() {

        System.out.println("debug >>>> getActiveAuctionItems");

        List<AuctionItemDTO> items = auctionItemService.getAuctionList();

        System.out.println("debug >>>> items: " + items);

        return ResponseEntity.ok(items);
    }

    // 경매 물품 상세 조회
    @GetMapping("/detail/{itemId}")
    public ResponseEntity<AuctionItemDTO> getAuctionItemDetail(@PathVariable("itemId") int itemId) {

        System.out.println("debug >>>> getAuctionItemDetail itemId: " + itemId);

        AuctionItemDTO item = auctionItemService.getAuctionItemDetail(itemId);

        System.out.println("debug >>>> getAuctionItemDetail item detail: " + item);

        if (item == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(item);
    }

    // 경매 물품 등록
    @PostMapping("/new/item")
    public String newAuctionItem(@RequestBody AuctionItemDTO itemDTO) {

        Map<String,Object> userInfo = getUserInfo();

        int userId = (int) userInfo.get("userId");
        String nickname = (String) userInfo.get("nickname");
        
        itemDTO.setSeller_id(userId);
        itemDTO.setSeller_nickname(nickname);

        System.out.println("debug >>>> updateAuctionItem itemId: " + itemDTO);

        String result = auctionItemService.newAuctionItem(itemDTO);

        return result;

    }

    // 경매 물품 상세 정보 수정
    @PutMapping("/edit/{itemId}")
    public ResponseEntity<String> updateAuctionItem(
            @PathVariable("itemId") int itemId,
            @RequestBody AuctionItemDTO itemDTO) {

        System.out.println("debug >>>> updateAuctionItem itemId: " + itemId);

        String updateResult = auctionItemService.updateAuctionItem(itemDTO);

        if ("Success".equals(updateResult)) {
            return ResponseEntity.ok().body("경매 물품이 성공적으로 수정되었습니다.");
        } else {
            return ResponseEntity.badRequest().body("경매 물품 수정에 실패했습니다.");
        }

    }

    // 경매 물품 삭제
    @DeleteMapping("/remove/{itemId}")
    public ResponseEntity<?> deleteAuctionItem(@PathVariable("itemId") int itemId) {
        try {
            Map<String,Object> userInfo = getUserInfo();
            
            int user_id = (int) userInfo.get("userId");

            String result = auctionItemService.deleteAuctionItem(user_id, itemId);

            if ("Success".equals(result)) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("삭제 권한이 없습니다.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body("삭제 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 경매 물품 입찰
    @PostMapping("/bid/{itemId}")
    public ResponseEntity<String> placeBid(
            @PathVariable("itemId") int itemId,
            @RequestParam("bid_price") int bid_price) {

        Map<String,Object> userInfo = getUserInfo();

        int userId = (int) userInfo.get("userId");
        String nickname = (String) userInfo.get("nickname");

        BidsDTO bidDto = new BidsDTO();
        
        bidDto.setItem_id(itemId);
        bidDto.setBidder_id(userId);
        bidDto.setBidder_nickname(nickname);
        bidDto.setBid_price(bid_price);

        System.out.println(bidDto);

        String result = auctionItemService.placeBid(bidDto);

        if ("Success".equals(result)) {
            return ResponseEntity.ok().body("입찰에 성공했습니다.");
        } else {
            return ResponseEntity.badRequest().body("입찰에 실패했습니다.");
        }
    }

    // 경매 물품 구매 (상태 변경) 낙찰찰
    @PostMapping("/purchase/{itemId}")
    public ResponseEntity<Void> purchaseAuctionItem(@PathVariable("itemId") int itemId) {

        auctionItemService.purchaseAuctionItem(itemId);

        return ResponseEntity.ok().build();
    }

    // 위탁 판매 등록
    @PostMapping("/new/consignment")
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
    @PostMapping("/images/{itemId}")
    public ResponseEntity<Void> insertAuctionImage(
            @PathVariable("itemId") int itemId,
            @RequestBody AuctionImageDTO imageDTO) {
        imageDTO.setItem_id(itemId);
        auctionItemService.insertAuctionImage(imageDTO);
        return ResponseEntity.ok().build();
    }

    // 이미지 조회
    @GetMapping("/images/{itemId}")
    public ResponseEntity<List<AuctionImageDTO>> getAuctionImages(@PathVariable("itemId") int itemId) {
        List<AuctionImageDTO> images = auctionItemService.getAuctionImagesByItemId(itemId);
        return ResponseEntity.ok(images);
    }

    // 이미지 수정
    @PutMapping("/images/{imageId}")
    public ResponseEntity<Void> updateAuctionImage(
            @PathVariable("imageId") long imageId,
            @RequestBody AuctionImageDTO imageDTO) {
        imageDTO.setImage_id(imageId);
        auctionItemService.updateAuctionImage(imageDTO);
        return ResponseEntity.ok().build();
    }

    // 이미지 삭제
    @DeleteMapping("/images/{imageId}")
    public ResponseEntity<Void> deleteAuctionImage(@PathVariable("imageId") long imageId) {
        auctionItemService.deleteAuctionImage(imageId);
        return ResponseEntity.noContent().build();
    }

    private Map<String, Object> getUserInfo() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();

        System.out.println("debug >>>> user_info " + userInfo);

        return userInfo;
    }
}
/*
 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
 * 
 * Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();
 * 
 * System.out.println("debug >>>> user_info " + userInfo);
 * 
 * Integer user_id = (Integer) userInfo.get("userId");
 */