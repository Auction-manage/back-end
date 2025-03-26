package com.autcion.auction_back.EditPage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.autcion.auction_back.EditPage.dao.UserManageMapper;
import com.autcion.auction_back.EditPage.domain.BuyerRankDTO;
import com.autcion.auction_back.EditPage.domain.EmailDTO;
import com.autcion.auction_back.EditPage.domain.SellerRankDTO;
import com.autcion.auction_back.EditPage.domain.UserDTO;
import com.autcion.auction_back.MainPage.domain.MileageDTO;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class UserManageService {

    @Autowired
    private AdminAuthenticationService adminAuthenticationService;

    @Autowired
    private UserManageMapper userManageMapper;

    @Autowired
    private JavaMailSender mailSender; // JavaMailSender 주입

    // 전체 회원 정보 조회 (권한 체크 포함)
    public List<UserDTO> getUserList(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return userManageMapper.getUserList();
    }

    // 회원 정보 수정 (권한 체크 포함)
    public void updateUserList(int userId, UserDTO param) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        userManageMapper.updateUserList(param);
    }

    // 구매자 등급 목록 조회 (권한 체크 포함)
    public List<Object> getRankList1(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return userManageMapper.getRankList1();
    }

    // 판매자 등급 목록 조회 (권한 체크 포함)
    public List<Object> getRankList2(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return userManageMapper.getRankList2();
    }

    // 구매자 등급 정보 수정 (권한 체크 포함)
    public void updateRankList1(int userId, BuyerRankDTO param) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        userManageMapper.updateRankList1(param);
    }

    // 판매자 등급 정보 수정 (권한 체크 포함)
    public void updateRankList2(int userId, SellerRankDTO param) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        userManageMapper.updateRankList2(param);
    }

    // 이메일 전송 (권한 체크 포함)
    public void sendEmails(int userId, EmailDTO params) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        sendEmails(params);
    }

    // 포인트 내역 전체 조회 (권한 체크 포함)
    public List<Object> getAllPoints(int userId) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        return userManageMapper.getAllPoints();
    }

    // 전체 회원 포인트 추가 (권한 체크 포함)
    public void insertMileage(int userId, MileageDTO params) {
        if (!adminAuthenticationService.checkAdmin(userId)) {
            throw new AccessDeniedException("Admin access required");
        }
        
        // 전체 회원 목록 조회
        List<UserDTO> users = userManageMapper.getUserList();
        
        if (users == null || users.isEmpty()) {
            throw new IllegalStateException("포인트를 추가할 회원이 없습니다");
        }

        // 각 회원에게 포인트 추가
        for (UserDTO user : users) {
            // 각 회원의 ID를 MileageDTO에 설정
            params.setUser_id(user.getUser_id());
            userManageMapper.insertMileage(params);
        }
    }

    // 모든 회원에게 이메일 전송
    public void sendEmails(EmailDTO params) {
        // 모든 회원 조회
        List<UserDTO> users = userManageMapper.getUserList();

        if (users == null || users.isEmpty()) {
            throw new IllegalStateException("No users found to send emails to");
        }

        // 각 회원에게 이메일 전송
        for (UserDTO user : users) {
            String email = user.getEmail();
            if (email != null && !email.isEmpty()) {
                try {
                    sendEmailToUser(email, params.getTitle(), params.getContent());
                } catch (MessagingException | MailException e) {
                    System.err.println("Failed to send email to " + email + ": " + e.getMessage());
                }
            }
        }
    }

    // 단일 사용자에게 이메일 전송
    private void sendEmailToUser(String toEmail, String title, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(toEmail);
        helper.setSubject(title);
        helper.setText(content, true); // true: HTML 형식 허용
        helper.setFrom("your-email@gmail.com"); // 발신자 이메일 주소 (application.properties에 설정된 값 사용)

        mailSender.send(message);
        System.out.println("Email sent successfully to " + toEmail);
    }
}