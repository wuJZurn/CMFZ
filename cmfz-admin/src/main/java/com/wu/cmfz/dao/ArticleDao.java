package com.wu.cmfz.dao;

import com.wu.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wu on 2018/7/6.
 */
public interface ArticleDao {
    public List<Article> selectArticle(@Param("begin") int begin, @Param("showSize") int showSize);
    public int countArticle();
    public boolean insertArticle(Article article);
    public boolean updateArticle(Article article);
    public boolean deleteArticle(Article article);
}
