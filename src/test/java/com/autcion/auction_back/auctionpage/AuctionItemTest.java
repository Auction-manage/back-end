package com.autcion.auction_back.auctionpage;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.autcion.auction_back.auctionpage.DAO.AuctionMapper;
import com.autcion.auction_back.auctionpage.DTO.AuctionImageDTO;
import com.autcion.auction_back.auctionpage.DTO.AuctionItemDTO;
import com.autcion.auction_back.auctionpage.service.AuctionItemService;
import com.autcion.auction_back.common.BidsDTO;
import com.autcion.auction_back.common.ConsignmentDTO;

@SpringBootTest
public class AuctionItemTest {

    @Autowired
    private AuctionMapper auctionItemMapper;

    @Autowired
    private AuctionItemService auctionItemService;

    @Test
    @DisplayName("물품(경매) 구매 가능 리스트 조회")
    public void testGetAuctionItems() {

        // List<AuctionItemDTO> items = auctionItemMapper.getAuctionItems();
        // items.forEach(i -> System.out.println("Active Auction Item: " + i));

        List<AuctionItemDTO> auctionItemLists = auctionItemService.getAuctionList();

        System.out.println("debug >>>> auctionItemLists: " + auctionItemLists);


    }

    @Test
    @DisplayName("물품(경매) 상세 정보 조회")
    public void testGetAuctionItemDetail() {
        int itemId = 1; // example
        AuctionItemDTO item = auctionItemMapper.getAuctionItemDetail(itemId);
        System.out.println("Auction Item Detail: " + item);
    }

    @Test
    @DisplayName("물품(경매) 등록")
    public void testInsertAuctionItem() {
        AuctionItemDTO newItem = AuctionItemDTO.builder()
                .seller_id(3)
                .seller_nickname("test")
                .title("Test Auction Item")
                .description("Test Auction Description")
                .start_price(1000.00)
                .current_price(1000.00)
                .status("active")
                .end_time(LocalDateTime.of(2025, 12, 31, 23, 59, 59))
                .build();
        // int result = auctionItemMapper.insertAuctionItem(newItem);
        // System.out.println("Insert Auction Item Result: " + result);
    }

    @Test
    @DisplayName("물품(경매) 상세 정보 수정")
    public void testUpdateAuctionItem() {
        AuctionItemDTO updateItem = AuctionItemDTO.builder()
                .item_id(1) // example
                .title("Updated Auction Title")
                .description("Updated Auction Description")
                .current_price(2000.00)
                .build();
        // int result = auctionItemMapper.updateAuctionItem(updateItem);
        // System.out.println("Update Auction Item Result: " + result);
    }

    @Test
    @DisplayName("물품(경매) 삭제")
    public void testDeleteAuctionItem() {
        int itemId = 1; // example
        // int result = auctionItemMapper.deleteAuctionItem(itemId);
        // System.out.println("Delete Auction Item Result: " + result);
    }

    @Test
    @DisplayName("물품(경매) 입찰")
    public void testPlaceBid() {
        BidsDTO bid = BidsDTO.builder()
                .item_id(9)
                .bidder_id(27)
                .bidder_nickname("test123")
                .bid_price(1500.00)
                .build();
        int result = auctionItemMapper.placeBid(bid);
        System.out.println("Place Bid Result: " + result);
    }

    @Test
    @DisplayName("물품(경매) 구매")
    public void testPurchaseAuctionItem() {
        int itemId = 2; // example
        int result = auctionItemMapper.purchaseAuctionItem(itemId);
        System.out.println("Purchase Auction Item (status -> inactive) Result: " + result);
    }

    @Test
    @DisplayName("물품(경매) 위탁 판매 등록")
    public void testRegisterConsignmentSale() {
        ConsignmentDTO consignment = ConsignmentDTO.builder()
                .transaction_id(1000)
                .buyer_id(27)
                .buyer_nickname("test123")
                .buyer_address("test123")
                .build();
        int result = auctionItemMapper.registerConsignmentSale(consignment);
        System.out.println("Register Consignment Sale Result: " + result);
    }

    @Test
    @DisplayName("물품(경매) 위탁 구매 신청")
    public void testApplyConsignmentPurchase() {
        ConsignmentDTO consignment = ConsignmentDTO.builder()
                .consignment_id(1) // example
                .build();
        int result = auctionItemMapper.applyConsignmentPurchase(consignment);
        System.out.println("Apply Consignment Purchase (status -> completed) Result: " + result);
    }

    @Test
    @DisplayName("물품(경매) 이미지 저장")
    public void testInsertAuctionImage() {
        AuctionImageDTO image = AuctionImageDTO.builder()
                .item_id(2)
                .image_url("http://example.com/auction_item_image.jpg")
                .build();
        int result = auctionItemMapper.insertAuctionImage(image);
        System.out.println("Insert Auction Image Result: " + result);
    }

    @Test
    @DisplayName("물품(경매) 이미지 조회")
    public void testGetAuctionImagesByItemId() {
        int itemId = 2;
        List<AuctionImageDTO> images = auctionItemMapper.getAuctionImagesByItemId(itemId);
        images.forEach(img -> System.out.println("Auction Image: " + img));
    }

    @Test
    @DisplayName("물품(경매) 이미지 수정")
    public void testUpdateAuctionImage() {
        AuctionImageDTO image = AuctionImageDTO.builder()
                .image_id(1) // example
                .image_url("http://example.com/updated_auction_image.jpg")
                .build();
        int result = auctionItemMapper.updateAuctionImage(image);
        System.out.println("Update Auction Image Result: " + result);
    }

    @Test
    @DisplayName("물품(경매) 이미지 삭제")
    public void testDeleteAuctionImage() {
        long imageId = 1; // example
        int result = auctionItemMapper.deleteAuctionImage(imageId);
        System.out.println("Delete Auction Image Result: " + result);
    }
}
