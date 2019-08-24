package com.fruitBake.dao;

import com.fruitBake.domain.Logs;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsDao {

    @Insert("insert into logs (noteId,temp,humi,Ltime,Lev) values(#{noteId},#{temp},#{humi},#{Ltime},#{Lev})")
    public void insert(Logs logs);

}
