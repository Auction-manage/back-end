package com.autcion.auction_back.EditPage;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.autcion.auction_back.EditPage.dao.HomeManageMapper;
import com.autcion.auction_back.EditPage.dao.ItemManageMapper;
import com.autcion.auction_back.EditPage.dao.UserManageMapper;
import com.autcion.auction_back.EditPage.dao.DesignManageMapper;
import com.autcion.auction_back.EditPage.dao.SupportManageMapper;
import com.autcion.auction_back.EditPage.dao.AdminAuthenticationMapper;
import com.autcion.auction_back.EditPage.domain.BannerDTO;
import com.autcion.auction_back.EditPage.domain.BuyerRankDTO;
import com.autcion.auction_back.EditPage.domain.FaqDTO;
import com.autcion.auction_back.EditPage.domain.InquiriesDTO;
import com.autcion.auction_back.EditPage.domain.NoticeDTO;
import com.autcion.auction_back.EditPage.domain.SellerRankDTO;
import com.autcion.auction_back.EditPage.domain.ThemeDTO;
import com.autcion.auction_back.EditPage.domain.TransactionInfoDTO;
import com.autcion.auction_back.EditPage.domain.UserDTO;
import com.autcion.auction_back.MainPage.domain.MileageDTO;

@SpringBootTest
public class EditPageTests {

    @Autowired
    private HomeManageMapper homeManageMapper;

    @Autowired
    private ItemManageMapper itemManageMapper;

    @Autowired
    private UserManageMapper userManageMapper;

    @Autowired
    private DesignManageMapper designManageMapper;

    @Autowired
    private SupportManageMapper supportManageMapper;

    @Autowired
    private AdminAuthenticationMapper adminAuthenticationMapper;

    @Test
    @DisplayName("001 : 거래 통계 조회")
    public void getTradeStatistics() {
        System.out.println("거래 건수: " + homeManageMapper.getTradeCount());
        System.out.println("거래 금액: " + homeManageMapper.getTradeMoney());
        System.out.println("입금 대기: " + homeManageMapper.getDepositWaitCount());
        System.out.println("입금 완료: " + homeManageMapper.getDepositCount());
        System.out.println("배송 대기: " + homeManageMapper.getDeliveryWaitCount());
        System.out.println("배송 중: " + homeManageMapper.getDeliveringCount());
        System.out.println("배송 완료: " + homeManageMapper.getDeliveryEndCount());
        System.out.println("취소 건수: " + homeManageMapper.getCancelCount());
        System.out.println("환불 건수: " + homeManageMapper.getRefundCount());
        System.out.println("반품 건수: " + homeManageMapper.getReturnCount());
        System.out.println("debug >>> 거래 통계 조회 성공");
    }

    @Test
    @DisplayName("002 : 최근 거래 조회")
    public void getRecentTrade() {
        List<TransactionInfoDTO> result = homeManageMapper.getRecentTrade();
        for(TransactionInfoDTO trade : result) {
            System.out.println(trade);
        }
        System.out.println("debug >>> 최근 거래 조회 성공");
    }

    @Test
    @DisplayName("003 : 전체 거래 조회")
    public void getAllTrade() {
        List<TransactionInfoDTO> result = itemManageMapper.getAllTrade();
        for(TransactionInfoDTO trade : result) {
            System.out.println(trade);
        }
        System.out.println("debug >>> 전체 거래 조회 성공");
    }

    @Test
    @DisplayName("004 : 거래 상태별 조회")
    public void getTradeByStatus() {
        System.out.println("=== 입금 대기 거래 ===");
        List<TransactionInfoDTO> waitTrade = itemManageMapper.getwaitTrade();
        for(TransactionInfoDTO trade : waitTrade) {
            System.out.println(trade);
        }

        System.out.println("=== 입금 완료 거래 ===");
        List<TransactionInfoDTO> depositTrade = itemManageMapper.getDepositTrade();
        for(TransactionInfoDTO trade : depositTrade) {
            System.out.println(trade);
        }

        System.out.println("debug >>> 거래 상태별 조회 성공");
    }

    @Test
    @DisplayName("005 : 거래 정보 수정")
    public void updateTrade() {
        TransactionInfoDTO trade = TransactionInfoDTO.builder()
                .transaction_id(1)
                .buyer_id(1)
                .seller_id(2)
                .buyer_address1("서울시")
                .buyer_phone("010-1234-5678")
                .seller_phone("010-8765-4321")
                .tracking_number1("123456")
                .build();
        itemManageMapper.updateTrade(trade);
        System.out.println("debug >>> 거래 정보 수정 성공");
    }

    @Test
    @DisplayName("006 : 사용자 목록 조회")
    public void getUserList() {
        List<UserDTO> users = userManageMapper.getUserList();
        for(UserDTO user : users) {
            System.out.println(user);
        }
        System.out.println("debug >>> 사용자 목록 조회 성공");
    }

    @Test
    @DisplayName("007 : 사용자 정보 수정")
    public void updateUserList() {
        UserDTO user = UserDTO.builder()
                .user_id(1)
                .user_name("테스트")
                .user_phone("010-1234-5678")
                .build();
        userManageMapper.updateUserList(user);
        System.out.println("debug >>> 사용자 정보 수정 성공");
    }

    @Test
    @DisplayName("008 : 랭크 목록 조회")
    public void getRankList() {
        System.out.println("=== 구매자 랭크 ===");
        List<BuyerRankDTO> buyerRanks = userManageMapper.getRankList1();
        for(BuyerRankDTO rank : buyerRanks) {
            System.out.println(rank);
        }

        System.out.println("=== 판매자 랭크 ===");
        List<SellerRankDTO> sellerRanks = userManageMapper.getRankList2();
        for(SellerRankDTO rank : sellerRanks) {
            System.out.println(rank);
        }
        System.out.println("debug >>> 랭크 목록 조회 성공");
    }

    @Test
    @DisplayName("009 : 테마 변경")
    public void updateTheme() {
        ThemeDTO theme = ThemeDTO.builder()
                .theme_name("X-mas")
                .theme_info("크리스마스 테마")
                .logoURL("xmas-logo.png")
                .build();
        designManageMapper.updateTheme(theme);
        System.out.println("debug >>> 테마 변경 성공");
    }

    @Test
    @DisplayName("010 : 배너 변경")
    public void updateBanner() {
        BannerDTO banner = BannerDTO.builder()
                .banner_title("X-mas Sale")
                .banner_imageURL("xmas-banner.png")
                .build();
        designManageMapper.updateBanner(banner);
        System.out.println("debug >>> 배너 변경 성공");
    }

    @Test
    @DisplayName("011 : 공지사항 관리")
    public void manageNotice() {
        // 공지사항 추가
        NoticeDTO notice = NoticeDTO.builder()
                .notice_title("테스트 공지")
                .notice_info("테스트 공지 내용")
                .build();
        supportManageMapper.insertNotice(notice);
        System.out.println("debug >>> 공지사항 추가 성공");

        // 공지사항 수정
        notice.setNotice_info("수정된 공지 내용");
        supportManageMapper.updateNotice(notice);
        System.out.println("debug >>> 공지사항 수정 성공");

        // 공지사항 삭제
        supportManageMapper.deleteNotice(notice);
        System.out.println("debug >>> 공지사항 삭제 성공");
    }

    @Test
    @DisplayName("012 : FAQ 관리")
    public void manageFaq() {
        // FAQ 추가
        FaqDTO faq = FaqDTO.builder()
                .faq_title("자주 묻는 질문")
                .faq_info("FAQ 내용")
                .build();
        supportManageMapper.insertFaq(faq);
        System.out.println("debug >>> FAQ 추가 성공");

        // FAQ 수정
        faq.setFaq_info("수정된 FAQ 내용");
        supportManageMapper.updateFaq(faq);
        System.out.println("debug >>> FAQ 수정 성공");

        // FAQ 삭제
        supportManageMapper.deleteFaq(faq);
        System.out.println("debug >>> FAQ 삭제 성공");
    }

    @Test
    @DisplayName("013 : 관리자 권한 확인")
    public void checkAdmin() {
        String result = adminAuthenticationMapper.checkAdmin(1);
        System.out.println("관리자 권한: " + result);
        System.out.println("debug >>> 관리자 권한 확인 성공");
    }
}
