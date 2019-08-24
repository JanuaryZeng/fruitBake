package com.fruitBake.service.impl;

import com.fruitBake.dao.NotesDao;
import com.fruitBake.domain.FruitCount;
import com.fruitBake.domain.Notes;
import com.fruitBake.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("notesService")
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesDao notesDao;

    @Override
    public List<Notes> findAll() {
        return notesDao.findAll();
    }

    @Override
    public List<Notes> findOne(String noteid) {
        return notesDao.findOne(noteid);
    }

    @Override
    public void delete(String noteid) {
        notesDao.delete(noteid);
    }

    @Override
    public void insert(Notes notes) {
        notesDao.insert(notes);
    }

    @Override
    public List<Notes> byOname(String Oname) {
        return notesDao.byOname(Oname);
    }

    @Override
    public List<Notes> byUname(String Uname) {
        return notesDao.byUname(Uname);
    }

    @Override
    public void alterEndTime(String noteid, String endTime) {
        notesDao.alterEndTime(noteid, endTime);
    }

    @Override
    public List<Notes> findByStatus() {
        return notesDao.findByStatus();
    }

    @Override
    public void updateStatus() {
        notesDao.updateStatus();
    }

    @Override
    public List<FruitCount> fruitCount() {
        return notesDao.fruitCount();
    }


}
