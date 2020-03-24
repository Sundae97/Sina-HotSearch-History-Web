package com.sundae.sinaspider.controller;

import com.sundae.sinaspider.constants.IResponseStatusCode;
import com.sundae.sinaspider.domain.HotSearchDetail;
import com.sundae.sinaspider.dto.GeneralListResponse;
import com.sundae.sinaspider.dto.GeneralResponse;
import com.sundae.sinaspider.service.HotSearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sina")
public class SinaHotSearchApiController {

    @Autowired
    @Qualifier("sinaHotSearchHistoryServiceImpl")
    private HotSearchHistoryService sinaHotSearchHistoryService;

    @RequestMapping(value = "/get_hotsearch_detail_list", method = RequestMethod.GET)
    public GeneralListResponse<Map<Integer, HotSearchDetail>> getHotSearchDetailList(@PathParam("time") long time){
        Map<Integer, HotSearchDetail> resultMap = sinaHotSearchHistoryService.getHotSearchDetailListByTime(time);

        GeneralListResponse<Map<Integer, HotSearchDetail>> generalListResponse = new GeneralListResponse<>();
        if(CollectionUtils.isEmpty(resultMap)){
            generalListResponse.setSuccess(false);
            generalListResponse.setCode(IResponseStatusCode.NONE_HOTSEARCH);
            return generalListResponse;
        }

        generalListResponse.setSuccess(true);
        generalListResponse.setCode(IResponseStatusCode.SUCCESS);
        generalListResponse.setSize(resultMap.size());
        generalListResponse.setData(resultMap);
        return generalListResponse;
    }

    @RequestMapping(value = "/get_latest_hotsearch_time", method = RequestMethod.GET)
    public GeneralResponse<Long> getLatestHotSearchTime(){
        Date date = sinaHotSearchHistoryService.getLatestHotSearchTime();
        return getDateGeneralResponse(date);
    }

    @RequestMapping(value = "/get_min_date", method = RequestMethod.GET)
    public GeneralResponse<Long> getMinDate(){
        Date date = sinaHotSearchHistoryService.getMinDate();
        return getDateGeneralResponse(date);
    }

    private GeneralResponse<Long> getDateGeneralResponse(Date date) {
        GeneralResponse<Long> generalResponse = new GeneralResponse<>();
        if(date == null){
            generalResponse.setSuccess(false);
            generalResponse.setCode(IResponseStatusCode.NONE_HOTSEARCH);
            return generalResponse;
        }
        generalResponse.setSuccess(true);
        generalResponse.setCode(IResponseStatusCode.SUCCESS);
        generalResponse.setData(date.getTime());
        return generalResponse;
    }

}
