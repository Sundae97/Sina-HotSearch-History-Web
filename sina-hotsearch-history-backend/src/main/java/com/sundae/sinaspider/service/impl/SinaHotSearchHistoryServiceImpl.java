package com.sundae.sinaspider.service.impl;

import com.sundae.sinaspider.constants.IResponseStatusCode;
import com.sundae.sinaspider.dao.SinaHotSearchHistoryDao;
import com.sundae.sinaspider.domain.BlogDetail;
import com.sundae.sinaspider.domain.HotSearch;
import com.sundae.sinaspider.domain.HotSearchDetail;
import com.sundae.sinaspider.domain.HotSearchDetailPOJO;
import com.sundae.sinaspider.dto.GeneralListResponse;
import com.sundae.sinaspider.dto.GeneralResponse;
import com.sundae.sinaspider.service.HotSearchHistoryService;
import com.sundae.sinaspider.util.DateUtil;
import com.sundae.sinaspider.util.HotSearchDomainUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class SinaHotSearchHistoryServiceImpl implements HotSearchHistoryService {

    @Autowired
    private SinaHotSearchHistoryDao hotSearchHistoryDao;

    @Override
    public Map<Integer, HotSearchDetail> getHotSearchDetailListByTime(long time) {
        Map<Integer, HotSearchDetail> resultMap = new TreeMap<>();

        HotSearch hotSearch =
                hotSearchHistoryDao.getHotSearchByTime(DateUtil.timeToDateString(time));
        if(hotSearch == null){
            return resultMap;
        }
        List<HotSearchDetailPOJO> hotSearchDetailList =
                hotSearchHistoryDao.getHotSearchDetailAndBlogByHotSearchId(hotSearch.getId());
        if(CollectionUtils.isEmpty(hotSearchDetailList)){
            return resultMap;
        }

        hotSearchDetailList.forEach(item -> {
            int rank = item.getRank();
            BlogDetail blogDetail = HotSearchDomainUtil.toBlogDetail(item);
            if(!resultMap.containsKey(rank)){
                HotSearchDetail hotSearchDetail = HotSearchDomainUtil.toHotSearchDetail(item);
                resultMap.put(rank, hotSearchDetail);
            }
            resultMap.get(rank).getBlogDetails().add(blogDetail);
        });

        return resultMap;
    }

    @Override
    public Date getLatestHotSearchTime(){
        HotSearch hotSearch = hotSearchHistoryDao.getLatestHotSearch();
        return hotSearch == null ? null : hotSearch.getTime();
    }
}
