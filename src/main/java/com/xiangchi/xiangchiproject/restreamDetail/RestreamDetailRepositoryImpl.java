package com.xiangchi.xiangchiproject.restreamDetail;

import com.xiangchi.xiangchiproject.common.model.PageParam;
import com.xiangchi.xiangchiproject.restreamDetail.mysql.RestreamDetailMapper;
import com.xiangchi.xiangchiproject.restreamDetail.param.RestreamDetailPageParam;
import com.xiangchi.xiangchiproject.restreamDetail.po.RestreamDetailPo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Repository
public class RestreamDetailRepositoryImpl implements RestreamDetailRepository{

    @Resource
    private RestreamDetailMapper restreamDetailMapper;

    @Override
    public Long insertOne(RestreamDetailPo po) {
        restreamDetailMapper.insert(po);
        return po.getId();
    }

    @Override
    public Long updateOne(RestreamDetailPo po) {
        restreamDetailMapper.update(po);
        return po.getId();
    }

    @Override
    public void deleteOne(Set<Long> ids) {
        restreamDetailMapper.delete(ids);
        return;
    }

    @Override
    public List<RestreamDetailPo> page(RestreamDetailPageParam param) {
        if (param.getPageParam() == null) {
            param.setPageParam(PageParam.builder().pageLen(10).pageNum(0).build());
        }
        return restreamDetailMapper.pageByParam(param);
    }

    @Override
    public Integer count(RestreamDetailPageParam param) {
        return restreamDetailMapper.countByParam(param);
    }
}
