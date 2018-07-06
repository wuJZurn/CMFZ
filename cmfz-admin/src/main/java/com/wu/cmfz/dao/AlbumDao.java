package com.wu.cmfz.dao;

import com.wu.cmfz.entity.Album;

import java.util.List;

/**
 * Created by wu on 2018/7/6.
 */
public interface AlbumDao {
    public List<Album> selectAllAlbum();
    public int countAlbum();
    public boolean insertAlbum(Album album);
    public boolean updateAlbum(Album album);
    public boolean deleteAlbum(Album album);
}
