package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Shuffling;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zxl on 2018/7/5.
 */
public interface ShufflingDao {
    public int insertPic(Shuffling shuffling);

    public int deletePic(@Param("id") String id);

    public int updatePic(Shuffling shuffling);

    public Shuffling selectPicById(@Param("id")String id);

    public List<Shuffling> selectAllPic(@Param("begin") Integer begin,@Param("end") Integer end);

    public int count();
}
