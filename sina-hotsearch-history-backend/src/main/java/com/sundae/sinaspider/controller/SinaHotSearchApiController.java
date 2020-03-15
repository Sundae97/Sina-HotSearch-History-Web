package com.sundae.sinaspider.controller;

import com.sundae.sinaspider.dao.SinaHotSearchHistoryDao;
import com.sundae.sinaspider.domain.HotSearchDetail;
import com.sundae.sinaspider.domain.HotSearchDetailPOJO;
import com.sundae.sinaspider.dto.GeneralListResponse;
import com.sundae.sinaspider.dto.GeneralResponse;
import com.sundae.sinaspider.service.HotSearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/sina")
public class SinaHotSearchApiController {

    @Autowired
    @Qualifier("sinaHotSearchHistoryServiceImpl")
    private HotSearchHistoryService sinaHotSearchHistoryService;

    @RequestMapping(value = "/get_hotsearch_detail_list", method = RequestMethod.GET)
    public GeneralResponse getHotSearchDetailList(@PathParam("time") long time){
        return sinaHotSearchHistoryService.getHotSearchDetailList(time);
    }

}
