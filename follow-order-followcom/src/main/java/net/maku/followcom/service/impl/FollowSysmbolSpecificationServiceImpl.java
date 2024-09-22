package net.maku.followcom.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.followcom.convert.FollowSysmbolSpecificationConvert;
import net.maku.followcom.entity.FollowSysmbolSpecificationEntity;
import net.maku.followcom.query.FollowSysmbolSpecificationQuery;
import net.maku.followcom.vo.FollowSysmbolSpecificationVO;
import net.maku.followcom.dao.FollowSysmbolSpecificationDao;
import net.maku.followcom.service.FollowSysmbolSpecificationService;
import com.fhs.trans.service.impl.TransService;
import net.maku.framework.common.utils.ExcelUtils;
import net.maku.followcom.vo.FollowSysmbolSpecificationExcelVO;
import net.maku.framework.common.excel.ExcelFinishCallBack;
import org.springframework.web.multipart.MultipartFile;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 品种规格
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class FollowSysmbolSpecificationServiceImpl extends BaseServiceImpl<FollowSysmbolSpecificationDao, FollowSysmbolSpecificationEntity> implements FollowSysmbolSpecificationService {
    private final TransService transService;

    @Override
    public PageResult<FollowSysmbolSpecificationVO> page(FollowSysmbolSpecificationQuery query) {
        IPage<FollowSysmbolSpecificationEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(FollowSysmbolSpecificationConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<FollowSysmbolSpecificationEntity> getWrapper(FollowSysmbolSpecificationQuery query){
        LambdaQueryWrapper<FollowSysmbolSpecificationEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }


    @Override
    public FollowSysmbolSpecificationVO get(Long id) {
        FollowSysmbolSpecificationEntity entity = baseMapper.selectById(id);
        FollowSysmbolSpecificationVO vo = FollowSysmbolSpecificationConvert.INSTANCE.convert(entity);

        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(FollowSysmbolSpecificationVO vo) {
        FollowSysmbolSpecificationEntity entity = FollowSysmbolSpecificationConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(FollowSysmbolSpecificationVO vo) {
        FollowSysmbolSpecificationEntity entity = FollowSysmbolSpecificationConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }


    @Override
    public void export() {
    List<FollowSysmbolSpecificationExcelVO> excelList = FollowSysmbolSpecificationConvert.INSTANCE.convertExcelList(list());
        transService.transBatch(excelList);
        ExcelUtils.excelExport(FollowSysmbolSpecificationExcelVO.class, "品种规格", null, excelList);
    }

}