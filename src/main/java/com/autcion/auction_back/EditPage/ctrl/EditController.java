package com.autcion.auction_back.EditPage.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autcion.auction_back.EditPage.service.EditService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/manage")
public class EditController {

    @Autowired  EditService editService;


    // 관리자 홈 페이지ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    // 전체 거래 수 조회
    @GetMapping("/tradecount")
    public ResponseEntity<Integer> getTradeCount(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        
        System.out.println("client endpoint : /manage/tradecount");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getTradeCount()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 입금대기 거래 수 조회 
    @GetMapping("/DepositWaitcount")
    public ResponseEntity<Integer> getDepositWaitCount(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        
        System.out.println("client endpoint : /manage/DepositWaitcount");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getDepositWaitCount()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 입금완료 거래 수 조회 
    @GetMapping("/Depositcount")
    public ResponseEntity<Integer> getDepositCount(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        
        System.out.println("client endpoint : /manage/Depositcount");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getDepositCount()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 배송 준비 거래 수 조회 
    @GetMapping("/DeliverytWaitcount")
    public ResponseEntity<Integer> getDeliveryWaitCount(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        
        System.out.println("client endpoint : /manage/DeliverytWaitcount");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(resul) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getDeliverytWaitCount()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 배송 중 거래 수 조회 
    @GetMapping("/Deliveringcount")
    public ResponseEntity<Integer> getDeliveringCount(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        
        System.out.println("client endpoint : /manage/Deliveringcount");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getDeliveringCount()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 배송 완료 거래 수 조회 
    @GetMapping("/DeliveryEndcount")
    public ResponseEntity<Integer> getDeliveryEndCount(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        
        System.out.println("client endpoint : /manage/DeliveryEndcount");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getDeliveyEndCount()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 취소 거래 수 조회 
    @GetMapping("/Cancelcount")
    public ResponseEntity<Integer> getCancelCount(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        
        System.out.println("client endpoint : /manage/Cancelcount");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getCancelCount()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 환불 거래 수 조회 
    @GetMapping("/Refundcount")
    public ResponseEntity<Integer> getRefundCount(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        
        System.out.println("client endpoint : /manage/Refundcount");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getRefundCount()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 반품 거래 수 조회 
    @GetMapping("/Returncount")
    public ResponseEntity<Integer> getReturnCount(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        
        System.out.println("client endpoint : /manage/Returncount");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getReturnCount()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 현재 거래내역 5개 조회
    @GetMapping("/recentTrade")
    // Object는 나중에 거래DTO로 변경
    public ResponseEntity<List<Object>> getRecentTrade(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        System.err.println("client endpoing : /manage/recentTrade");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getRecentTrade()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }
    

    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    // 회원관리 페이지ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    // 전체 회원 정보 조회
    @GetMapping("/userList")
    // Object는 나중에 유저DTO로 변경
    public ResponseEntity<List<Object>> getUserList(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        System.err.println("client endpoing : /manage/userList");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getUserList()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 회원 정보 수정
    @PatchMapping("/userList/update")
    public ResponseEntity<Map<String, Object>> updateUserList(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
            @RequestBody UserDTO param  ) {
            
        System.out.println("client endpoint : /manage/userList/update");
        System.out.println("debug >>> updateUserList + " + param);

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            Map<String, Object> response = new HashMap<>();

            if(result) {
                // 관리자 권한이 있으면 작동
                editService.updateUserList(param);
                response.put("status", "success");
                response.put("message", "User List updated successfully");
                return ResponseEntity.ok(response);
            } else {
                // 관리자 권한이 없으면 접근금지
                response.put("error", "Forbidden");
                response.put("message", "Admin access required");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
            }
        } else {
            // 인증 실패 시 401 반환
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Unauthorized");
            errorResponse.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }
    
    // 구매자 등급 목록 조회
    @GetMapping("/rankList1")
    // Object는 나중에 등급DTO로 변경
    public ResponseEntity<List<Object>> getRankList1(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        System.err.println("client endpoing : /manage/rankList1");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getRankList1()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 판매자 등급 목록 조회
    @GetMapping("/rankList2")
    // Object는 나중에 등급DTO로 변경
    public ResponseEntity<List<Object>> getRankList2(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        System.err.println("client endpoing : /manage/rankList2");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getRankList2()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 구매자 등급 정보 수정
    @PatchMapping("/rankList1/update")
    public ResponseEntity<Map<String, Object>> updateRankList1(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
            @RequestBody rankDTO param  ) {
            
        System.out.println("client endpoint : /manage/rankList1/update");
        System.out.println("debug >>> updateRankList1 + " + param);

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            Map<String, Object> response = new HashMap<>();

            if(result) {
                // 관리자 권한이 있으면 작동
                editService.updateRankList1(param);
                response.put("status", "success");
                response.put("message", "Rank List updated successfully");
                return ResponseEntity.ok(response);
            } else {
                // 관리자 권한이 없으면 접근금지
                response.put("error", "Forbidden");
                response.put("message", "Admin access required");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
            }
        } else {
            // 인증 실패 시 401 반환
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Unauthorized");
            errorResponse.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }

    // 구매자 등급 정보 수정
    @PatchMapping("/rankList2/update")
    public ResponseEntity<Map<String, Object>> updateRankList2(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
            @RequestBody rankDTO param  ) {
            
        System.out.println("client endpoint : /manage/rankList2/update");
        System.out.println("debug >>> updateRankList2 + " + param);

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            Map<String, Object> response = new HashMap<>();

            if(result) {
                // 관리자 권한이 있으면 작동
                editService.updateRankList2(param);
                response.put("status", "success");
                response.put("message", "Rank List updated successfully");
                return ResponseEntity.ok(response);
            } else {
                // 관리자 권한이 없으면 접근금지
                response.put("error", "Forbidden");
                response.put("message", "Admin access required");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
            }
        } else {
            // 인증 실패 시 401 반환
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Unauthorized");
            errorResponse.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }

    // 이메일 전송
    @PostMapping("/send-emails")
    public ResponseEntity<Map<String, Object>> sendEmails(
        @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
        @RequestBody EmailDTO params) {
        
        System.out.println("client endpoint : /manage/send-emails");
        System.out.println("debug >>> sendEmails + " + params);

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            Map<String, Object> response = new HashMap<>();

            if(result) {
                // 관리자 권한이 있으면 작동
                editService.sendEmails(params);
                response.put("status", "success");
                response.put("message", "Send Emails successfully");
                return ResponseEntity.ok(response);
            } else {
                // 관리자 권한이 없으면 접근금지
                response.put("error", "Forbidden");
                response.put("message", "Admin access required");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
            }
        } else {
            // 인증 실패 시 401 반환
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Unauthorized");
            errorResponse.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
        
    }


    // 포인트 내역 전체 조회
    @GetMapping("/Allpoints")
    // Object는 나중에 마일리지DTO로 변경
    public ResponseEntity<List<Object>> getAllpoints(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        System.err.println("client endpoing : /manage/getAllpoints");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getAllpoints()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 포인트 추가
    @PostMapping("/insertMileage")
    public ResponseEntity<Map<String, Object>> insertMileage(
        @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
        @RequestBody mileageDTO params) {
        
        System.out.println("client endpoint : /manage/insertMileage");
        System.out.println("debug >>> sendEmails + " + params);

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            Map<String, Object> response = new HashMap<>();

            if(result) {
                // 관리자 권한이 있으면 작동
                editService.insertMileage(params);
                response.put("status", "success");
                response.put("message", "Send Emails successfully");
                return ResponseEntity.ok(response);
            } else {
                // 관리자 권한이 없으면 접근금지
                response.put("error", "Forbidden");
                response.put("message", "Admin access required");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
            }
        } else {
            // 인증 실패 시 401 반환
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Unauthorized");
            errorResponse.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
        
    }

    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    // 거래 페이지 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    // 전체 거래 리스트 조회
    @GetMapping("/AllTrade")
    // Object는 나중에 마일리지DTO로 변경
    public ResponseEntity<List<Object>> getAllTrade(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        System.err.println("client endpoing : /manage/getAllTrade");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getAllTrade()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 입금대기 거래 리스트 조회
    @GetMapping("/waitTrade")
    // Object는 나중에 마일리지DTO로 변경
    public ResponseEntity<List<Object>> getwaitTrade(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        System.err.println("client endpoing : /manage/getwaitTrade");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getwaitTrade()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 입금완료 거래 리스트 조회
    @GetMapping("/DepositTrade")
    // Object는 나중에 마일리지DTO로 변경
    public ResponseEntity<List<Object>> getDepositTrade(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        System.err.println("client endpoing : /manage/getDepositTrade");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getDepositTrade()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 배송준비 거래 리스트 조회
    @GetMapping("/DeliveryWaitTrade")
    // Object는 나중에 마일리지DTO로 변경
    public ResponseEntity<List<Object>> getDeliveryWaitTrade(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        System.err.println("client endpoing : /manage/getDeliveryWaitTrade");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getDeliveryWaitTrade()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 배송 중 거래 리스트 조회
    @GetMapping("/DeliveringTrade")
    // Object는 나중에 마일리지DTO로 변경
    public ResponseEntity<List<Object>> getDeliveringTrade(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        System.err.println("client endpoing : /manage/getDeliveringTrade");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getDeliveringTrade()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 배송 완료 거래 리스트 조회
    @GetMapping("/DeliveryEndTrade")
    // Object는 나중에 마일리지DTO로 변경
    public ResponseEntity<List<Object>> getDeliveryEndTrade(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        System.err.println("client endpoing : /manage/getDeliveryEndTrade");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getDeliveryEndTrade()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 취소 거래 리스트 조회
    @GetMapping("/cancelTrade")
    // Object는 나중에 마일리지DTO로 변경
    public ResponseEntity<List<Object>> getcancelTrade(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        System.err.println("client endpoing : /manage/getcancelTrade");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getcancelTrade()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 환불 거래 리스트 조회
    @GetMapping("/refundTrade")
    // Object는 나중에 마일리지DTO로 변경
    public ResponseEntity<List<Object>> getrefundTrade(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        System.err.println("client endpoing : /manage/getrefundTrade");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getrefundTrade()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 취소 거래 리스트 조회
    @GetMapping("/returnTrade")
    // Object는 나중에 마일리지DTO로 변경
    public ResponseEntity<List<Object>> getreturnTrade(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        System.err.println("client endpoing : /manage/getreturnTrade");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getreturnTrade()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    // 문의사항 페이지 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    // 문의사항 조회
    @GetMapping("/inquries")
    // Object는 나중에 마일리지DTO로 변경
    public ResponseEntity<List<Object>> getinquries(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        System.err.println("client endpoing : /manage/getinquries");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            if(result) {
                // 관리자 권한이 있으면 작동
                return ResponseEntity.ok((editService.getinquries()));
            } else {
                // 관리자 권한이 없으면 접근금지
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        } else {
            // 인증 실패 시 401 반환
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    // 문의사항 정보 수정
    @PatchMapping("/inquries/update")
    public ResponseEntity<Map<String, Object>> updateinquries(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
            @RequestBody rankDTO param  ) {
            
        System.out.println("client endpoint : /manage/inquries/update");
        System.out.println("debug >>> updateinquries + " + param);

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            Map<String, Object> response = new HashMap<>();

            if(result) {
                // 관리자 권한이 있으면 작동
                editService.updateinquries(param);
                response.put("status", "success");
                response.put("message", "Rank List updated successfully");
                return ResponseEntity.ok(response);
            } else {
                // 관리자 권한이 없으면 접근금지
                response.put("error", "Forbidden");
                response.put("message", "Admin access required");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
            }
        } else {
            // 인증 실패 시 401 반환
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Unauthorized");
            errorResponse.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }

    // 공지사항 추가
    @PostMapping("/notice")
    public ResponseEntity<Map<String, Object>> insertnotice(
        @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
        @RequestBody noticeDTO params) {
        
        System.out.println("client endpoint : /manage/notice");
        System.out.println("debug >>> insertnotice + " + params);

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            Map<String, Object> response = new HashMap<>();

            if(result) {
                // 관리자 권한이 있으면 작동
                editService.insertnotice(params);
                response.put("status", "success");
                response.put("message", "Send Emails successfully");
                return ResponseEntity.ok(response);
            } else {
                // 관리자 권한이 없으면 접근금지
                response.put("error", "Forbidden");
                response.put("message", "Admin access required");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
            }
        } else {
            // 인증 실패 시 401 반환
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Unauthorized");
            errorResponse.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
        
    }

    // 공지사항 정보 수정
    @PatchMapping("/notice/update")
    public ResponseEntity<Map<String, Object>> updatenotice(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
            @RequestBody noticeDTO param  ) {
            
        System.out.println("client endpoint : /manage/notice/update");
        System.out.println("debug >>> updatenotice + " + param);

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            Map<String, Object> response = new HashMap<>();

            if(result) {
                // 관리자 권한이 있으면 작동
                editService.updatenotice(param);
                response.put("status", "success");
                response.put("message", "Rank List updated successfully");
                return ResponseEntity.ok(response);
            } else {
                // 관리자 권한이 없으면 접근금지
                response.put("error", "Forbidden");
                response.put("message", "Admin access required");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
            }
        } else {
            // 인증 실패 시 401 반환
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Unauthorized");
            errorResponse.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }

    // 공지사항 삭제
    @DeleteMapping("/notice/delete")
    public ResponseEntity<Map<String, Object>> deletenotice(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
            @RequestBody noticeDTO param  ) {
            
        System.out.println("client endpoint : /manage/notice/delete");
        System.out.println("debug >>> deletenotice + " + param);

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            Map<String, Object> response = new HashMap<>();

            if(result) {
                // 관리자 권한이 있으면 작동
                editService.deletenotice(param);
                response.put("status", "success");
                response.put("message", "Rank List updated successfully");
                return ResponseEntity.ok(response);
            } else {
                // 관리자 권한이 없으면 접근금지
                response.put("error", "Forbidden");
                response.put("message", "Admin access required");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
            }
        } else {
            // 인증 실패 시 401 반환
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Unauthorized");
            errorResponse.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }

    // FAQ 추가
    @PostMapping("/faq")
    public ResponseEntity<Map<String, Object>> insertfaq(
        @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
        @RequestBody faqDTO params) {
        
        System.out.println("client endpoint : /manage/faq");
        System.out.println("debug >>> insertfaq + " + params);

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            Map<String, Object> response = new HashMap<>();

            if(result) {
                // 관리자 권한이 있으면 작동
                editService.insertfaq(params);
                response.put("status", "success");
                response.put("message", "Send Emails successfully");
                return ResponseEntity.ok(response);
            } else {
                // 관리자 권한이 없으면 접근금지
                response.put("error", "Forbidden");
                response.put("message", "Admin access required");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
            }
        } else {
            // 인증 실패 시 401 반환
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Unauthorized");
            errorResponse.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
        
    }

    // FAQ 정보 수정
    @PatchMapping("/faq/update")
    public ResponseEntity<Map<String, Object>> updatefaq(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
            @RequestBody faqDTO param  ) {
            
        System.out.println("client endpoint : /manage/faq/update");
        System.out.println("debug >>> updatefaq + " + param);

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            Map<String, Object> response = new HashMap<>();

            if(result) {
                // 관리자 권한이 있으면 작동
                editService.updatefaq(param);
                response.put("status", "success");
                response.put("message", "Rank List updated successfully");
                return ResponseEntity.ok(response);
            } else {
                // 관리자 권한이 없으면 접근금지
                response.put("error", "Forbidden");
                response.put("message", "Admin access required");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
            }
        } else {
            // 인증 실패 시 401 반환
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Unauthorized");
            errorResponse.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }

    // FAQ 삭제
    @DeleteMapping("/faq/delete")
    public ResponseEntity<Map<String, Object>> deletefaq(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
            @RequestBody faqDTO param  ) {
            
        System.out.println("client endpoint : /manage/faq/delete");
        System.out.println("debug >>> deletefaqe + " + param);

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            Map<String, Object> response = new HashMap<>();

            if(result) {
                // 관리자 권한이 있으면 작동
                editService.deletefaq(param);
                response.put("status", "success");
                response.put("message", "Rank List updated successfully");
                return ResponseEntity.ok(response);
            } else {
                // 관리자 권한이 없으면 접근금지
                response.put("error", "Forbidden");
                response.put("message", "Admin access required");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
            }
        } else {
            // 인증 실패 시 401 반환
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Unauthorized");
            errorResponse.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }
    
    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    // 디자인 관ㄹ ㅣ페이지 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

    // 월별 통계 조회 추가
    @PostMapping("/Monthstatistics")
    public ResponseEntity<Map<String, Object>> insertMonthstatistics(
        @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
        @RequestBody MonthstatisticsDTO params) {
        
        System.out.println("client endpoint : /manage/Monthstatistics");
        System.out.println("debug >>> insertMonthstatistics + " + params);

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            Map<String, Object> response = new HashMap<>();

            if(result) {
                // 관리자 권한이 있으면 작동
                editService.insertMonthstatistics(params);
                response.put("status", "success");
                response.put("message", "Send Emails successfully");
                return ResponseEntity.ok(response);
            } else {
                // 관리자 권한이 없으면 접근금지
                response.put("error", "Forbidden");
                response.put("message", "Admin access required");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
            }
        } else {
            // 인증 실패 시 401 반환
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Unauthorized");
            errorResponse.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
        
    }

    // 일별 통계 조회 추가
    @PostMapping("/Daystatistics")
    public ResponseEntity<Map<String, Object>> insertDaystatistics(
        @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
        @RequestBody DaystatisticsDTO params) {
        
        System.out.println("client endpoint : /manage/Daystatistics");
        System.out.println("debug >>> insertDaystatistics + " + params);

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            Map<String, Object> response = new HashMap<>();

            if(result) {
                // 관리자 권한이 있으면 작동
                editService.insertDaystatistics(params);
                response.put("status", "success");
                response.put("message", "Send Emails successfully");
                return ResponseEntity.ok(response);
            } else {
                // 관리자 권한이 없으면 접근금지
                response.put("error", "Forbidden");
                response.put("message", "Admin access required");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
            }
        } else {
            // 인증 실패 시 401 반환
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Unauthorized");
            errorResponse.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
        
    }

    // 테마 수정
    @PatchMapping("/theme/update")
    public ResponseEntity<Map<String, Object>> updatetheme(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
            @RequestBody themeDTO param  ) {
            
        System.out.println("client endpoint : /manage/theme/update");
        System.out.println("debug >>> updatetheme + " + param);

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            Map<String, Object> response = new HashMap<>();

            if(result) {
                // 관리자 권한이 있으면 작동
                editService.updatetheme(param);
                response.put("status", "success");
                response.put("message", "Rank List updated successfully");
                return ResponseEntity.ok(response);
            } else {
                // 관리자 권한이 없으면 접근금지
                response.put("error", "Forbidden");
                response.put("message", "Admin access required");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
            }
        } else {
            // 인증 실패 시 401 반환
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Unauthorized");
            errorResponse.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }

    // 배너 정보 수정
    @PatchMapping("/banner/update")
    public ResponseEntity<Map<String, Object>> updatebanner(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader,
            @RequestBody bannerDTO param  ) {
            
        System.out.println("client endpoint : /manage/banner/update");
        System.out.println("debug >>> updatebanner + " + param);

        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            
            // 토큰의 "Bearer "부분 제거
            String token = authHeader.substring(7);

            // 토큰에서 user_id 추출
            int user_id = jwtTokenProvider.getUserIdFromToken(token);

            // user_id가 어드민 권한을 가지고 있는지 체크
            Boolean result = editService.checkAdmin(user_id);

            Map<String, Object> response = new HashMap<>();

            if(result) {
                // 관리자 권한이 있으면 작동
                editService.updatebanner(param);
                response.put("status", "success");
                response.put("message", "Rank List updated successfully");
                return ResponseEntity.ok(response);
            } else {
                // 관리자 권한이 없으면 접근금지
                response.put("error", "Forbidden");
                response.put("message", "Admin access required");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
            }
        } else {
            // 인증 실패 시 401 반환
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Unauthorized");
            errorResponse.put("message", "Invalid or missing authorization token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }
    
}