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
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            
            if (auth == null || auth.getPrincipal().equals("anonymousUser")) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "로그인이 필요합니다."));
            }

            Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();
            Integer userId = (Integer) userInfo.get("userId");

            System.out.println("debug >>>> userId " + userId);

            System.out.println("debug >>>> itemId " + itemId);

            String result = auctionItemService.deleteAuctionItem(userId, itemId);

            if ("Success".equals(result)) {
                return ResponseEntity.ok()
                    .body(Map.of("message", "삭제가 완료되었습니다."));
            } else {
                return ResponseEntity.badRequest()
                    .body(Map.of("message", "삭제에 실패했습니다."));
            }
        } catch (ClassCastException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("message", "인증 정보가 올바르지 않습니다."));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                .body(Map.of("message", "서버 오류가 발생했습니다."));
        }
    }

    // 경매 물품 입찰
    @PostMapping("/bid/{itemId}")
    public ResponseEntity<Void> placeBid(
            @PathVariable("itemId") int itemId,
            @RequestBody BidsDTO bidDTO) {

        bidDTO.setItem_id(itemId);

        auctionItemService.placeBid(bidDTO);

        return ResponseEntity.ok().build();
    }

    // 경매 물품 구매 (상태 변경)
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