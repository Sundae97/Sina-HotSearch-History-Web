package com.sundae.sinaspider.util;

import com.sundae.sinaspider.domain.BlogDetail;
import com.sundae.sinaspider.domain.HotSearchDetail;
import com.sundae.sinaspider.domain.HotSearchDetailPOJO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HotSearchDomainUtil {

    public static BlogDetail toBlogDetail(HotSearchDetailPOJO pojo){
        BlogDetail blogDetail = new BlogDetail();
        blogDetail.setId(pojo.getHotsearchBlogDetailId());
        blogDetail.setUserId(pojo.getUserId());
        blogDetail.setScreenName(pojo.getScreenName());
        blogDetail.setUserHeadImgUrl(pojo.getUserHeadImgUrl());
        blogDetail.setBlogId(pojo.getBlogId());
        blogDetail.setText(pojo.getText());

        String picUrls = pojo.getPicUrlsString();
        if(StringUtils.isEmpty(picUrls)){
            blogDetail.setPicUrls(Collections.emptyList());
        }else{
            blogDetail.setPicUrls(Arrays.asList(picUrls.split(",")));
        }

        blogDetail.setRepostsCount(pojo.getRepostsCount());
        blogDetail.setCommentsCount(pojo.getCommentsCount());
        blogDetail.setAttitudesCount(pojo.getAttitudesCount());
        blogDetail.setTime(pojo.getTime());

        return blogDetail;
    }

    public static HotSearchDetail toHotSearchDetail(HotSearchDetailPOJO pojo){
        HotSearchDetail hotSearchDetail = new HotSearchDetail();
        hotSearchDetail.setId(pojo.getHotsearchDetailId());
        hotSearchDetail.setRank(pojo.getRank());
        hotSearchDetail.setDesc(pojo.getDesc());
        hotSearchDetail.setIcon(pojo.getIcon());
        hotSearchDetail.setBlogDetails(new ArrayList<>());
        return hotSearchDetail;
    }

}
