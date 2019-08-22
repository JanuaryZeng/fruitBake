package com.fruitBake.service.impl;

import com.fruitBake.dao.NotesDao;
import com.fruitBake.domain.Notes;
import com.fruitBake.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
