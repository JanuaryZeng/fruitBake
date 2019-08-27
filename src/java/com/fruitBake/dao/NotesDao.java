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
            "values (#{Oname}, #{Fname}, #{startTime}, #{endTime}, #{Uname});")
    public void insert(Notes notes);

    @Select("select * from notes where Uname = #{Uname}")
    public List<Notes> findOneByUname(String Uname);

    @Select("select * from notes where Oname = #{Oname}")
    public List<Notes> findOneByOname(String Oname);

    @Select("select * from notes where Oname = #{Oname}")
    public List<Notes> byOname(String Oname);


    @Select("select * from notes where Uname = #{Uname}")
    public List<Notes> byUname(String Uname);

    @Update("update notes set endTime = #{endTime} where noteId = #{noteid}")
    public void alterEndTime(@Param("noteid") String noteid, @Param("endTime") String endTime);

    @Select("select * from notes where Nstatus = 1 and endTime > (select current_timestamp());")
    public List<Notes> findByStatus();

    @Select("select * from notes where Nstatus = 1 and endTime <= (select current_timestamp());")
    public List<Notes> findByTime();

    @Update("update notes set Nstatus = 0 where Nstatus = 1")
    public void updateStatus();

    @Update("update notes set Nstatus = 1 where noteId = #{noteId}")
    public void alterStatus(String noteId);

    @Select("select Fname,count(Fname) num from notes group by Fname")
    public List<FruitCount> fruitCount();

    @Select("select * from notes where endTime > (select current_timestamp());")
    public List<Notes> currentWork();
}
