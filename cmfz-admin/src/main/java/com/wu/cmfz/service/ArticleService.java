package com.wu.cmfz.service;

import com.wu.cmfz.entity.Article;
import com.wu.cmfz.entity.Master;

import java.util.List;
import java.util.Map;

/**
 * Created by wu on 2018/7/8.
 */
public interface ArticleService {
    public Map<String,Object> queryArticle(int totalSize, int pageIndex);
    public boolean addArticle(Article article);
    public boolean modifyArticle(Article article);

}
