package com.piles.setting.business.impl;

import com.piles.common.business.IBusiness;
import com.piles.common.util.ChannelResponseCallBackMap;
import com.piles.setting.entity.GetPileVersionReqeust;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 请求升级包 充电桩  运营管理系统
 */
@Slf4j
@Service("xunDaoGetPileVersionBusiness")
public class XundaoGetPileVersionBusinessImpl implements IBusiness {


    @Override
    public byte[] process(byte[] msg, Channel incoming) {
        String order = "";//TODO 流水号
        //依照报文体规则解析报文
        GetPileVersionReqeust getPileVersionReqeust = GetPileVersionReqeust.packEntityXunDao(msg);
        getPileVersionReqeust.setSerial(order);
        ChannelResponseCallBackMap.callBack(incoming, String.valueOf(order), getPileVersionReqeust);
        return null;
    }
}