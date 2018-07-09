package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zxl on 2018/7/6.
 */
public interface GuruDao {
    public int insertGuru(Guru guru);

    public int updateGuru(Guru guru);

    public Guru selectGuruById(@Param("guruId") String Id);

    public List<Guru> selectGuruByName(@Param("guruName") String guruName,@Param("begin") Integer begin,@Param("end") Integer end);

    public List<Guru> selectAllGuru(@Param("begin") Integer begin,@Param("end") Integer end);

    public int count();

    public int countt(@Param("guruName")String guruName);

    public int insertBatch(@Param("list") List<Guru> list);

    public List<Guru> selectGuru();

}
