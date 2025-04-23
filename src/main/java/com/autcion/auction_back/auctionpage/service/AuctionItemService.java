package com.autcion.auction_back.auctionpage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autcion.auction_back.auctionpage.DAO.AuctionMapper;
import com.autcion.auction_back.auctionpage.DTO.AuctionImageDTO;
import com.autcion.auction_back.auctionpage.DTO.AuctionItemDTO;
import com.autcion.auction_back.common.BidsDTO;
import com.autcion.auction_back.common.ConsignmentDTO;

@Service
public class AuctionItemService {

    @Autowired
    private AuctionMapper auctionMapper;

    // 경매 리스트 조회
    public List<AuctionItemDTO> getAuctionList() {

        System.out.println("debug >>>> getAuctionLists");

        List<AuctionItemDTO> auctionItems = auctionMapper.getAuctionList();

        System.out.println("debug >>>> auctionService >>>> auctionItems: " + auctionItems);

        // TODO: 구현
        return auctionItems;
    }

    // 경매 상세정보 조회
    public AuctionItemDTO getAuctionItemDetail(int itemId) {
        System.out.println("debug >>>> getAuctionItemDetail itemId: " + itemId);

        AuctionItemDTO item = auctionMapper.getAuctionItemDetail(itemId);

        // TODO: 구현
        return item;
    }

    // 경매물품 추가
    public String newAuctionItem(AuctionItemDTO itemDTO) {
        try {
            System.out.println("debug >>>> updateAuctionItem itemDTO: " + itemDTO);

            int response = auctionMapper.newAuctionItem(itemDTO);

            if (response > 0) {
                return "Success";
            } else {
                throw new RuntimeException("경매 물품 등록 중 오류가 발생했습니다");
            }
        } catch (Exception e) {
            throw new RuntimeException("경매 물품 등록 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 경매물품 수정
    public String updateAuctionItem(AuctionItemDTO itemDTO) {

        System.out.println("debug >>>> updateAuctionItem itemDTO: " + itemDTO);

        int response = auctionMapper.updateAuctionItem(itemDTO);

        System.out.println("debug >>>> updateAuctionItem items: " + response);

        if (response > 0) {
            return "Success";
        } else {
            return "Fail";
        }
    }

    // 경매물품 삭제제
    public String deleteAuctionItem(int user_id, int itemId) {

        System.out.println("debug >>>> deleteAuctionItem user_id: " + user_id);

        int response = auctionMapper.deleteAuctionItem(user_id, itemId);

        System.out.println("debug >>>> deleteAuctionItem response: " + response);

        if (response > 0) {
            return "Success";
        } else {
            return "Fail";
        }

    }

    public String placeBid(BidsDTO bidDTO) {

        System.out.println("debug >>>> placeBid bidDTO: " + bidDTO);

        int response = auctionMapper.placeBid(bidDTO);

        if (response > 0) {
            System.out.println("debug >>>> placeBid success");
            return "Success";
        } else {
            System.out.println("debug >>>> placeBid fail");
            return "Fail";
        }

        // TODO: 구현
    }

    public void purchaseAuctionItem(int itemId) {
        // TODO: 구현
    }

    public void registerConsignmentSale(ConsignmentDTO consignmentDTO) {
        // TODO: 구현
    }

    public void applyConsignmentPurchase(ConsignmentDTO consignmentDTO) {
        // TODO: 구현
    }

    public void insertAuctionImage(AuctionImageDTO imageDTO) {
        // TODO: 구현
    }

    public List<AuctionImageDTO> getAuctionImagesByItemId(int itemId) {
        // TODO: 구현
        return null;
    }

    public void updateAuctionImage(AuctionImageDTO imageDTO) {
        // TODO: 구현
    }

    public void deleteAuctionImage(long imageId) {
        // TODO: 구현
    }
}
