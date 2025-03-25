package com.autcion.auction_back.EditPage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeManageMapper {
    
    public int getTradeCount();

    public int getDepositWaitCount();

    public int getDepositCount();

    public int getDeliveryWaitCount();

    public int getDeliveringCount();

    public int getDeliveryEndCount();
    
    public int getCancelCount();

    public int getRefundCount();

    public int getReturnCount();

    public List<Object> getRecentTrade();
}
