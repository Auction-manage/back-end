package com.autcion.auction_back;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.autcion.auction_back.dao.ProfileDao;
import com.autcion.auction_back.domain.AuctionDataDto;
import com.autcion.auction_back.domain.LoginDto;
import com.autcion.auction_back.domain.RegisterDto;
import com.autcion.auction_back.service.LoginService;
import com.autcion.auction_back.service.ProfileService;
import com.autcion.auction_back.service.RegisterService;
import com.autcion.auction_back.service.SaleHistoryService;
import com.autcion.auction_back.service.UserService;

import jakarta.transaction.Transactional;

@SpringBootTest
@ComponentScan(basePackages = "com.autcion.auction_back")
@Transactional
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

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("로그인 테스트")
	public void testLogin() {
		LoginDto loginDto = LoginDto.builder()
									.loginId("test1")
									.password("test1")
									.build();
		System.out.println("LoginDto created: " + loginDto);
		
		String result = loginService.login(loginDto);
		System.out.println("Login result: " + result);

		assertEquals("success", result, "로그인에에 실패했습니다. 반환된 결과: " + result);
	}

	@Test
	@DisplayName("회원가입")
	public void testRegister() {
		try {
			RegisterDto registerDto = RegisterDto.builder()
												.loginId("test")
												.password("test")
												.name("test")
												.nickname("test1")
												.phone("test1")
												.email("test@test1.com")
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
			RegisterDto registerDto = RegisterDto.builder()
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
		String username = "test";
		ProfileDao profile = profileService.profile(username);
		System.out.println("Profile: " + profile);

		assertEquals("test", profile.getName(), "프로필 조회에 실패했습니다. 반환된 결과: " + profile);
	}

	@Test
	@DisplayName("판매 내역 조회")
	public void testSaleHistory() {
		String nickname = "test";
		List<AuctionDataDto> auctionData = saleHistoryService.getAuctionData("3");
		System.out.println("AuctionData: " + auctionData);
		
		assertTrue(auctionData.size() >= 1, "판매 내역 조회에 실패했습니다. 반환된 결과: " + auctionData);
	}
}
