package com.sundae.sinaspider.service.impl;

import com.sundae.sinaspider.dao.SinaHotSearchHistoryDao;
import com.sundae.sinaspider.domain.BlogDetail;
import com.sundae.sinaspider.domain.HotSearch;
import com.sundae.sinaspider.domain.HotSearchDetail;
import com.sundae.sinaspider.domain.HotSearchDetailPOJO;
import com.sundae.sinaspider.dto.GeneralListResponse;
import com.sundae.sinaspider.service.HotSearchHistoryService;
import com.sundae.sinaspider.util.DateUtil;
import com.sundae.sinaspider.util.HotSearchDomainUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class SinaHotSearchHistoryServiceImpl implements HotSearchHistoryService {

    @Autowired
    private SinaHotSearchHistoryDao hotSearchHistoryDao;

    @Override
    public GeneralListResponse<Map<Integer, HotSearchDetail>> getHotSearchDetailList(long time) {
        HotSearch hotSearch =
                hotSearchHistoryDao.getHotSearchByTime(DateUtil.timeToDateString(time));
        List<HotSearchDetailPOJO> hotSearchDetailList =
                hotSearchHistoryDao.getHotSearchDetailAndBlogByHotSearchId(hotSearch.getId());

        GeneralListResponse<Map<Integer, HotSearchDetail>> generalListResponse =
                new GeneralListResponse<>();

        Map<Integer, HotSearchDetail> resultMap = new TreeMap<>();

        if(hotSearchDetailList == null || hotSearchDetailList.size() == 0){
            generalListResponse.setSize(0);
            generalListResponse.setData(resultMap);
            return generalListResponse;
        }

        hotSearchDetailList.stream().forEach(item -> {
            int rank = item.getRank();
            BlogDetail blogDetail = HotSearchDomainUtil.toBlogDetail(item);
            if(!resultMap.containsKey(rank)){
                HotSearchDetail hotSearchDetail = HotSearchDomainUtil.toHotSearchDetail(item);
                resultMap.put(rank, hotSearchDetail);
            }
            resultMap.get(rank).getBlogDetails().add(blogDetail);
        });
        generalListResponse.setSize(resultMap.size());
        generalListResponse.setData(resultMap);
        return generalListResponse;
    }
}
