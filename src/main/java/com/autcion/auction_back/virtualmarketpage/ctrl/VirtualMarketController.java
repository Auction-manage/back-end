package com.autcion.auction_back.virtualmarketpage.ctrl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.autcion.auction_back.virtualmarketpage.DTO.VirtualMarketDTO;
import com.autcion.auction_back.virtualmarketpage.service.VirtualMarketService;

@RestController
@RequestMapping("/virtualmarket")
public class VirtualMarketController {

    @Autowired
    private VirtualMarketService virtualMarketService;

    // 전체 가상 마켓 조회
    @GetMapping("/list")
    public ResponseEntity<List<VirtualMarketDTO>> getVirtualMarketlist() {

        System.out.println("debug >>> getVirtualMarketlist");

        List<VirtualMarketDTO> marketList = virtualMarketService.getVirtualMarketlist();

        System.out.println("debug >>> getVirtualMarketlist" + marketList);

        return ResponseEntity.ok(marketList);
    }

    // 가상 마켓 상세 조회
    @GetMapping("/{marketId}")
    public ResponseEntity<VirtualMarketDTO> getVirtualMarket(@PathVariable("marketId") int marketId) {

        System.out.println("debug >>> getVirtualMarket");

        VirtualMarketDTO market = virtualMarketService.getVirtualMarket(marketId);

        System.out.println("debug >>> getVirtualMarket" + market);

        if (market == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(market);
    }

    // 가상 마켓 생성
    @PostMapping("/new")
    public ResponseEntity<VirtualMarketDTO> createVirtualMarket(@RequestBody VirtualMarketDTO marketDTO) {

        System.out.println("debug >>> createVirtualMarket");

        Map<String, Object> userInfo = getUserInfo();

        System.out.println("debug >>> userInfo " + userInfo);

        int userId = (int) userInfo.get("userId");
        String nickname = (String) userInfo.get("nickname");

        marketDTO.setSeller_id(userId);
        marketDTO.setSeller_nickname(nickname);

        System.out.println("debug >>> createVirtualMarket" + marketDTO);

        VirtualMarketDTO createdMarket = virtualMarketService.createVirtualMarket(marketDTO);

        System.out.println("debug >>> createVirtualMarket" + createdMarket);

        return ResponseEntity.ok(createdMarket);
    }

    // 가상 마켓 수정
    @PutMapping("/{marketId}/edit")
    public ResponseEntity<VirtualMarketDTO> updateVirtualMarket(@PathVariable int marketId,
            @RequestBody VirtualMarketDTO marketDTO) {
        marketDTO.setMarket_id(marketId);
        VirtualMarketDTO updatedMarket = virtualMarketService.updateVirtualMarket(marketDTO);
        return ResponseEntity.ok(updatedMarket);
    }

    // 가상 마켓 삭제
    @DeleteMapping("/{marketId}")
    public ResponseEntity<?> deleteVirtualMarket(@PathVariable("marketId") int marketId) {

        System.out.println("debug >>> virtualMarketController deleteVirtualMarket");

        String response = virtualMarketService.deleteVirtualMarket(marketId);

        System.out.println("debug >>> virtualMarketController deleteVirtualMarket" + response);

        return ResponseEntity.ok(response);
    }

    private Map<String, Object> getUserInfo() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Map<String, Object> userInfo = (Map<String, Object>) auth.getPrincipal();

        System.out.println("debug >>>> user_info " + userInfo);

        return userInfo;
    }
}
