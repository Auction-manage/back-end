package com.autcion.auction_back.EditPage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemManageMapper {
    
    public List<Object> getAllTrade();

    public List<Object> getwaitTrade();

    public List<Object> getDepositTrade();

    public List<Object> getDeliveryWaitTrade();

    public List<Object> getDeliveringTrade();

    public List<Object> getDeliveryEndTrade();

    public List<Object> getcancelTrade();

    public List<Object> getrefundTrade();

    public List<Object> getreturnTrade();
}
