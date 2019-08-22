package com.fruitBake.dao;

import com.fruitBake.domain.Notes;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesDao {

    @Select("select * from notes")
    public List<Notes> findAll();

    @Select("select * from notes where noteid = #{noteid}")
    public List<Notes> findOne(String noteid);

    @Delete("delete from notes where noteid = #{noteid}")
    public void delete(String noteid);

}
