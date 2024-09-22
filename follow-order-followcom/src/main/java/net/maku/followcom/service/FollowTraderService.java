package net.maku.followcom.service;

import net.maku.followcom.query.FollowOrderSpliListQuery;
import net.maku.followcom.vo.FollowOrderSendVO;
import net.maku.followcom.vo.FollowOrderSlipPointVO;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.followcom.vo.FollowTraderVO;
import net.maku.followcom.query.FollowTraderQuery;
import net.maku.followcom.entity.FollowTraderEntity;
import java.util.List;

/**
 * mt4账号
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface FollowTraderService extends BaseService<FollowTraderEntity> {

    PageResult<FollowTraderVO> page(FollowTraderQuery query);

    FollowTraderVO get(Long id);


    void save(FollowTraderVO vo);

    void update(FollowTraderVO vo);

    void delete(List<Long> idList);


    void export();


    /**
     * 下单
     * @param vo
     * @return
     */
    boolean orderSend(FollowOrderSendVO vo);

    /**
     * 滑点分析列表
     */
    void orderSlipPoint();

    PageResult<FollowOrderSlipPointVO>  pageSlipPoint(FollowOrderSpliListQuery query);
}