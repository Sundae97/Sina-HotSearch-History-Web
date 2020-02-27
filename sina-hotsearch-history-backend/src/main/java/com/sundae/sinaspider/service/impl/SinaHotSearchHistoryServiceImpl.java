package com.sundae.sinaspider.service.impl;

import com.sundae.sinaspider.dao.SinaHotSearchHistoryDao;
import com.sundae.sinaspider.domain.HotSearch;
import com.sundae.sinaspider.domain.HotSearchDetail;
import com.sundae.sinaspider.domain.HotSearchDetailPOJO;
import com.sundae.sinaspider.dto.GeneralListResponse;
import com.sundae.sinaspider.service.HotSearchHistoryService;
import com.sundae.sinaspider.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinaHotSearchHistoryServiceImpl implements HotSearchHistoryService {

    @Autowired
    private SinaHotSearchHistoryDao hotSearchHistoryDao;

    @Override
    public GeneralListResponse<List<HotSearchDetailPOJO>> getHotSearchDetailList(long time) {
        HotSearch hotSearch =
                hotSearchHistoryDao.getHotSearchByTime(DateUtil.timeToDateString(time));
        List<HotSearchDetailPOJO> hotSearchDetailList =
                hotSearchHistoryDao.getHotSearchDetailAndBlogByHotSearchId(hotSearch.getId());
        GeneralListResponse<List<HotSearchDetailPOJO>> generalListResponse =
                new GeneralListResponse<>();
        if(hotSearchDetailList != null){
            generalListResponse.setSize(hotSearchDetailList.size());
            generalListResponse.setData(hotSearchDetailList);
        }
        //TODO HotSearchDetailPOJO convert to HotSearchDetail and BlogDetail
        return generalListResponse;
    }
}
