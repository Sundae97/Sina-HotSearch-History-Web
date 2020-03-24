package com.sundae.sinaspider.service;

import com.sundae.sinaspider.domain.HotSearchDetail;
import java.util.Date;
import java.util.Map;

public interface HotSearchHistoryService {

    Date getLatestHotSearchTime();

    Map<Integer, HotSearchDetail> getHotSearchDetailListByTime(long time);

    Date getMinDate();
}
