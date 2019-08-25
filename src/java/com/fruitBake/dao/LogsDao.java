package com.fruitBake.dao;

import com.fruitBake.domain.Logs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogsDao {

    @Insert("insert into logs (noteId,temp,humi,Ltime,Lev) values(#{noteId},#{temp},#{humi},#{Ltime},#{Lev})")
    public void insert(Logs logs);

    @Select("select * from logs where noteid = #{noteId}")
    public List<Logs> findByNote(String noteId);
}
