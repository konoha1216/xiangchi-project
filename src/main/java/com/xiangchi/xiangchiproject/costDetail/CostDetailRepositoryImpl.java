package com.xiangchi.xiangchiproject.costDetail;

import com.xiangchi.xiangchiproject.common.model.PageParam;
import com.xiangchi.xiangchiproject.costDetail.mysql.CostDetailMapper;
import com.xiangchi.xiangchiproject.costDetail.param.CostDetailPageParam;
import com.xiangchi.xiangchiproject.costDetail.po.CostDetailPo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Repository
public class CostDetailRepositoryImpl implements CostDetailRepository{

    @Resource
    private CostDetailMapper costDetailMapper;

    @Override
    public Long insertOne(CostDetailPo po) {
        costDetailMapper.insert(po);
        return po.getId();
    }

    @Override
    public Long updateOne(CostDetailPo po) {
        costDetailMapper.update(po);
        return po.getId();
    }

    @Override
    public void deleteOne(Set<Long> ids) {
        costDetailMapper.delete(ids);
        return;
    }

    @Override
    public List<CostDetailPo> page(CostDetailPageParam param) {
        if (param.getPageParam() == null) {
            param.setPageParam(PageParam.builder().pageLen(10).pageNum(0).build());
        }
        return costDetailMapper.pageByParam(param);
    }

    @Override
    public Integer count(CostDetailPageParam param) {
        return costDetailMapper.countByParam(param);
    }
}
