package com.sundae.sinaspider.controller;

import com.sundae.sinaspider.dao.SinaHotSearchHistoryDao;
import com.sundae.sinaspider.domain.HotSearch;
import com.sundae.sinaspider.domain.HotSearchDetailPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    private SinaHotSearchHistoryDao hotSearchHistoryDao;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(){
        return hotSearchHistoryDao.getHotSearchByTime("2020-02-22 17:07:00").toString();
    }

    @RequestMapping(value = "test1", method = RequestMethod.GET)
    public List<HotSearchDetailPOJO> test1(){
        return hotSearchHistoryDao.getHotSearchDetailAndBlogByHotSearchId(630);
    }

}
