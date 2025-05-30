package com.autcion.auction_back.EditPage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.autcion.auction_back.EditPage.domain.TransactionInfoDTO;

@Mapper
public interface ItemManageMapper {
    
    public List<TransactionInfoDTO> getAllTrade();

    public List<TransactionInfoDTO> getwaitTrade();

    public List<TransactionInfoDTO> getDepositTrade();

    public List<TransactionInfoDTO> getDeliveryWaitTrade();

    public List<TransactionInfoDTO> getDeliveringTrade();

    public List<TransactionInfoDTO> getDeliveryEndTrade();

    public List<TransactionInfoDTO> getcancelTrade();

    public List<TransactionInfoDTO> getrefundTrade();

    public List<TransactionInfoDTO> getreturnTrade();

    public void updateTrade(TransactionInfoDTO param);

}
