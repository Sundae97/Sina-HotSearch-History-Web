package com.sundae.sinaspider.service;

import com.sundae.sinaspider.domain.HotSearchDetail;
import com.sundae.sinaspider.domain.HotSearchDetailPOJO;
import com.sundae.sinaspider.dto.GeneralListResponse;

import java.util.List;
import java.util.Map;

public interface HotSearchHistoryService {
    GeneralListResponse<Map<Integer, HotSearchDetail>> getHotSearchDetailList(long time);
}
