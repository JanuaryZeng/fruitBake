package com.fruitBake.service;

import com.fruitBake.domain.Notes;

import java.util.List;

public interface NotesService {

    public List<Notes> findAll();

    public List<Notes> findOne(String noteid);

    public void delete(String noteid);

}
