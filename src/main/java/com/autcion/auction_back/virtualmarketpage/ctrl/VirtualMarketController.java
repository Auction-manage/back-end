package com.autcion.auction_back.virtualmarketpage.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.autcion.auction_back.virtualmarketpage.DTO.VirtualMarketDTO;
import com.autcion.auction_back.virtualmarketpage.service.VirtualMarketService;

import java.util.List;

@RestController
@RequestMapping("/virtualMarkets")
public class VirtualMarketController {

    @Autowired
    private VirtualMarketService virtualMarketService;

    // 가상 마켓 생성
    @PostMapping("/new")
    public ResponseEntity<VirtualMarketDTO> createVirtualMarket(@RequestBody VirtualMarketDTO marketDTO) {
        VirtualMarketDTO createdMarket = virtualMarketService.createVirtualMarket(marketDTO);
        return ResponseEntity.ok(createdMarket);
    }

    // 전체 가상 마켓 조회
    @GetMapping
    public ResponseEntity<List<VirtualMarketDTO>> getAllVirtualMarkets() {
        List<VirtualMarketDTO> markets = virtualMarketService.getAllVirtualMarkets();
        return ResponseEntity.ok(markets);
    }

    // 가상 마켓 상세 조회
    @GetMapping("/{marketId}/detail")
    public ResponseEntity<VirtualMarketDTO> getVirtualMarket(@PathVariable int marketId) {
        VirtualMarketDTO market = virtualMarketService.getVirtualMarketById(marketId);
        if (market == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(market);
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
    public ResponseEntity<Void> deleteVirtualMarket(@PathVariable int marketId) {
        virtualMarketService.deleteVirtualMarket(marketId);
        return ResponseEntity.noContent().build();
    }
}

