package com.autcion.auction_back;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.autcion.auction_back.UsersPage.dao.ProfileDao;
import com.autcion.auction_back.UsersPage.domain.AuctionBidsDto;
import com.autcion.auction_back.UsersPage.domain.AuctionDataDto;
import com.autcion.auction_back.UsersPage.domain.AuctionWishListDto;
import com.autcion.auction_back.UsersPage.domain.InquiryDto;
import com.autcion.auction_back.UsersPage.domain.LoginDto;
import com.autcion.auction_back.UsersPage.domain.MarketDataDto;
import com.autcion.auction_back.UsersPage.domain.MarketWishListDto;
import com.autcion.auction_back.UsersPage.domain.MileageDto;
import com.autcion.auction_back.UsersPage.domain.UserDataDto;
import com.autcion.auction_back.UsersPage.service.LoginService;
import com.autcion.auction_back.UsersPage.service.ProfileService;
import com.autcion.auction_back.UsersPage.service.RecoverService;
import com.autcion.auction_back.UsersPage.service.RegisterService;
import com.autcion.auction_back.UsersPage.service.SaleHistoryService;
import com.autcion.auction_back.UsersPage.service.UserService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@ComponentScan(basePackages = {
    "com.autcion.auction_back",
    "com.autcion.auction_back.UsersPage",
    "com.autcion.auction_back.UsersPage.dao",
    "com.autcion.auction_back.UsersPage.service"
})
class OauthdemoApplication{

	@Autowired
	private LoginService loginService;

	@Autowired
	private RegisterService registerService;

	@Autowired
	private UserService userService;

	@Autowired
	private ProfileService profileService;

	@Autowired
	private SaleHistoryService saleHistoryService;

	@Autowired
	private RecoverService recoverService;

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("로그인 테스트")
	public void testLogin() {
		// LoginDto loginDto = LoginDto.builder()
		// 							.loginId("test1")
		// 							.password("test1")
		// 							.build();
		LoginDto loginDto = LoginDto.builder()
									.loginId("pwEncodeTest")
									.password("pwEncodeTest")
									.build();
		
		Map<String, String> result = loginService.login(loginDto);
		System.out.println("Login result: " + result);

		assertEquals("success", result.get("status"), "로그인에에 실패했습니다. 반환된 결과: " + result);
	}

	@Test
	@DisplayName("회원가입")
	public void testRegister() {
		try {
			UserDataDto registerDto = UserDataDto.builder()
												.loginId("test")
												.password("test")
												.name("test")
												.nickname("test1")
												.phone("test1")
												.email("test1@test1.com")
												.address("test")
												.build();
			System.out.println("RegisterDto created: " + registerDto);
			
			String result = registerService.register(registerDto);
			System.out.println("Register result: " + result);
			
			assertEquals("success", result, "회원가입이 실패했습니다. 반환된 결과: " + result);
		} catch (Exception e) {
			System.err.println("회원가입 테스트 중 예외 발생: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	@DisplayName("회원가입 시 아이디 중복일 경우")
	public void testRegisterDuplicate() {
		try {
			UserDataDto registerDto = UserDataDto.builder()
												.loginId("test1")
												.password("test")
												.name("test")
												.nickname("test")
												.phone("test")
												.email("test@test.com")
												.address("test")
												.build();
			System.out.println("RegisterDto created: " + registerDto);
			
			String result = registerService.register(registerDto);
			System.out.println("Register result: " + result);
			
			assertEquals("duplicate_data_error", result, "회원가입이 실패했습니다. 반환된 결과: " + result);
		} catch (Exception e) {
			System.err.println("회원가입 테스트 중 예외 발생: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	@DisplayName("프로필 조회")
	public void testProfile() {
		String username = "test1";
		ProfileDao profile = profileService.profile(username);
		System.out.println("Profile: " + profile);

		assertEquals("test", profile.getName(), "프로필 조회에 실패했습니다. 반환된 결과: " + profile);
	}
	
	@Test
	@DisplayName("프로필 수정")
	public void testUpdateProfile() {
		UserDataDto registerDto = UserDataDto.builder()
				.name("test1234")
				.nickname("test123")
				.email("test1234@test123.com")
				.phone("test1234")
				.address("test1234")
				.build();
				
		UserDataDto result = profileService.updateProfile(registerDto);

		System.out.println("UpdateProfile: " + result);
		
		assertNotNull(result, "프로필 수정에 실패했습니다.");
		assertEquals("test1234", result.getName(), "이름이 일치하지 않습니다.");
	}

/*
	@Test
	@DisplayName("회원 탈퇴")
	public void testDeleteAccount() {
		String userId = "3";
		String result = profileService.deleteAccount(userId);
		System.out.println("DeleteAccount: " + result);
	}
*/

	@Test
	@DisplayName("마일리지 조회")
	public void testCheckMileage() {
		String userId = "11";
		List<MileageDto> mileageData = profileService.checkMileage(userId);
		System.out.println("MileageData: " + mileageData);
	}

	@Test
	@DisplayName("내가 입찰중인 상품품")
	public void testMyBids() {
		String userId = "46";
		List<AuctionBidsDto> myBids = profileService.myBids(userId);

		System.out.println("debug >>>> bids " + myBids.size() + " " + "myBids " + myBids);
	}
	
	@Test
	@DisplayName("찜 목록 조회")
	public void testCheckWishList() {
		String userId = "3";
		List<AuctionWishListDto> auctionData = profileService.checkWishList(userId);
		System.out.println("AuctionData: " + auctionData);
		
		List<MarketWishListDto> marketData = profileService.checkMarketWishList(userId);
		System.out.println("MarketData: " + marketData);
	}
	
	@Test
	@DisplayName("찜 목록 삭제")
	public void testDeleteWishList() {
		String userId = "3";
		String auctionId = "1";
		String type_auction = "auction";
		String type_market = "market";

		String result = profileService.deleteWishlist(userId, auctionId, type_auction);
		System.out.println("DeleteWishList: " + result);

		result = profileService.deleteWishlist(userId, auctionId, type_market);
		System.out.println("DeleteWishList: " + result);

		assertTrue(result.equals("success"), "찜 목록 삭제에 실패했습니다. 반환된 결과: " + result);
	}

	@Test
	@DisplayName("판매 내역 조회")
	public void testSaleHistory() {
		String userId = "3";
		List<AuctionDataDto> auctionData = saleHistoryService.getAuctionData(userId);
		System.out.println("AuctionData: " + auctionData);

		List<MarketDataDto> marketData = saleHistoryService.getMarketData(userId);
		System.out.println("MarketData: " + marketData);
		
		assertTrue(auctionData.size() >= 1, "판매 내역 조회에 실패했습니다. 반환된 결과: " + auctionData);
	}

	@Test
	@DisplayName("아이디 찾기")
	public void testRecoverId() {
		UserDataDto registerDto = UserDataDto.builder()
											.name("test")
											.phone("test")
											.build();
		String result = recoverService.recoverId(registerDto);
		System.out.println("RecoverId: " + result);
	}
	
	@Test
	@DisplayName("비밀번호 찾기")
	public void testRecoverorPwd() {

		UserDataDto registerDto = UserDataDto.builder()
											.loginId("test1")
											.name("test")
											.phone("test")
											.build();

		String result = recoverService.recoverPassword(registerDto);

		System.out.println("UpdatePassword: " + result);

		if(result.equals("success")) {
			UserDataDto registerDto1 = UserDataDto.builder()
													.loginId("test123")
													.password("test")
													.build();

			String result1 = recoverService.updatePassword(registerDto1);
			
			System.out.println("UpdatePassword: " + result1);
		}
	
	}

	@Test
	@DisplayName("문의 조회")
	public void testMyInquiries() {
		String userId = "11";
		List<InquiryDto> inquiries = profileService.myInquiries(userId);
		System.out.println("Inquiries: " + inquiries);

		List<InquiryDto> inquiriesByStatus = profileService.myInquiriesByStatus(userId, "pending");
		System.out.println("InquiriesByStatus: " + inquiriesByStatus);
	}


}
