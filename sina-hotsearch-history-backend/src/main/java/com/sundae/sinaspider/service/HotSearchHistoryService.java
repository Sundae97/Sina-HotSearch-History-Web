package com.sundae.sinaspider.service;

import com.sundae.sinaspider.domain.HotSearchDetailPOJO;
import com.sundae.sinaspider.dto.GeneralListResponse;

import java.util.List;

public interface HotSearchHistoryService {
    GeneralListResponse<List<HotSearchDetailPOJO>> getHotSearchDetailList(long time);
}
