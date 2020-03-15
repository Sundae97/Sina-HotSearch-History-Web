package com.sundae.sinaspider.service;

import com.sundae.sinaspider.domain.HotSearchDetail;
import com.sundae.sinaspider.domain.HotSearchDetailPOJO;
import com.sundae.sinaspider.dto.GeneralListResponse;
import com.sundae.sinaspider.dto.GeneralResponse;

import java.util.List;
import java.util.Map;

public interface HotSearchHistoryService {
    GeneralResponse getHotSearchDetailList(long time);
}
