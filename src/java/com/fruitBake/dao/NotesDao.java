package com.fruitBake.dao;

import com.fruitBake.domain.FruitCount;
import com.fruitBake.domain.Notes;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface NotesDao {

    @Select("select * from notes")
    public List<Notes> findAll();

    @Select("select * from notes where noteid = #{noteid}")
    public List<Notes> findOne(String noteid);

    @Delete("delete from notes where noteid = #{noteid}")
    public void delete(String noteid);

    @Insert("insert into notes " +
            "(Oname, Fname, startTime, endTime, Uname) " +
            "values (#{Oname}, #{Fname}, #{startTime}, #{endTime}, #{Uname});\n")
    public void insert(Notes notes);

    @Select("select * from notes where Oname = #{Oname}")
    public List<Notes> byOname(String Oname);


    @Select("select * from notes where Uname = #{Uname}")
    public List<Notes> byUname(String Uname);

    @Update("update notes set endTime = #{endTime} where where noteid = #{noteid}")
    public void alterEndTime(@Param("noteid") String noteid, @Param("endTime") String endTime);

    @Select("select * from notes where Nstatus = 1")
    public List<Notes> findByStatus();

    @Update("update notes set Nstatus = 0 where Nstatus = 1")
    public void updateStatus();

    @Select("select Fname,count(Fname) num from notes group by Fname")
    public List<FruitCount> fruitCount();

    @Select("select * from notes where endTime > (select current_timestamp());")
    public List<Notes> currentWork();
}
