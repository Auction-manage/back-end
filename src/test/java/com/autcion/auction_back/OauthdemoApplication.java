package com.autcion.auction_back;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.autcion.auction_back.domain.LoginDto;
import com.autcion.auction_back.domain.RegisterDto;
import com.autcion.auction_back.domain.UserLoginEntity;
import com.autcion.auction_back.service.LoginService;
import com.autcion.auction_back.service.RegisterService;
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

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("회원가입")
	public void testRegister() {
		try {
			RegisterDto registerDto = RegisterDto.builder()
												.loginId("test")
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
	@DisplayName("로그인 테스트")
	public void testLogin() {
		LoginDto loginDto = LoginDto.builder()
									.loginId("test1")
									.password("test1")
									.build();
		System.out.println("LoginDto created: " + loginDto);
		
		Optional<UserLoginEntity> result = loginService.login(loginDto);
		System.out.println("Login result: " + result);

		assertEquals(true, result.isPresent(), "로그인이 실패했습니다. 반환된 결과: " + result);
	}

}
