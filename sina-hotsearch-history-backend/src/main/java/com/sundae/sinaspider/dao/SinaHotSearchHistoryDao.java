package com.sundae.sinaspider.dao;

import com.sundae.sinaspider.domain.HotSearch;
import com.sundae.sinaspider.domain.HotSearchDetailPOJO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SinaHotSearchHistoryDao {
    HotSearch getHotSearchByTime(String time);

    HotSearch getLatestHotSearch();

    List<HotSearchDetailPOJO> getHotSearchDetailAndBlogByHotSearchId(long hotSearchId);

}
