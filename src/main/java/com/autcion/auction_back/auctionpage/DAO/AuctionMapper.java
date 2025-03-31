package com.autcion.auction_back.auctionpage.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.auctionpage.DTO.AuctionImageDTO;
import com.autcion.auction_back.auctionpage.DTO.AuctionItemDTO;
import com.autcion.auction_back.common.BidsDTO;
import com.autcion.auction_back.common.ConsignmentDTO;

import java.util.List;

@Mapper
public interface AuctionMapper {

    // 1) 물품(경매) 구매 가능 리스트 조회
    public List<AuctionItemDTO> getAuctionList();

    // 2) 물품(경매) 상세 정보 조회
    public AuctionItemDTO getAuctionItemDetail(int itemId);

    // 3) 물품(경매) 등록
    public int newAuctionItem(AuctionItemDTO item);

    // 4) 물품(경매) 상세 정보 수정
    public int updateAuctionItem(AuctionItemDTO itemDTO);

    // 5) 물품(경매) 삭제
    public int deleteAuctionItem(int user_id, int itemId);

    // 6) 물품(경매) 입찰
    int placeBid(BidsDTO bid);

    // 7) 물품(경매) 구매
    // This might mark the auction as completed or insert into auction_history, etc.
    int purchaseAuctionItem(int itemId);

    // 8) 물품(경매) 위탁 판매 등록
    int registerConsignmentSale(ConsignmentDTO consignment);

    // 9) 물품(경매) 위탁 구매 신청
    // Could be an update or insert depending on your logic
    int applyConsignmentPurchase(ConsignmentDTO consignment);

    // ========== Auction Image CRUD ==========
    // 17) 물품(경매) 이미지 저장
    int insertAuctionImage(AuctionImageDTO image);

    // 19) 물품(경매) 이미지 조회
    List<AuctionImageDTO> getAuctionImagesByItemId(int itemId);

    // 21) 물품(경매) 이미지 수정
    int updateAuctionImage(AuctionImageDTO image);

    // 23) 물품(경매) 이미지 삭제
    int deleteAuctionImage(long imageId);
}
