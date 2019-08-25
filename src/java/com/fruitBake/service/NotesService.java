package com.fruitBake.service;

import com.fruitBake.domain.FruitCount;
import com.fruitBake.domain.Notes;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface NotesService {

    public List<Notes> findAll();

    public List<Notes> findOne(String noteid);

    public void delete(String noteid);

    public void insert(Notes notes);

    public List<Notes> byOname(String Oname);

    public List<Notes> byUname(String Uname);

    public void alterEndTime(@Param("noteid") String noteid, @Param("endTime") String endTime);

    public List<Notes> findByStatus();

    public void updateStatus();

    public List<FruitCount> fruitCount();

    public List<Notes> currentWork();

}
