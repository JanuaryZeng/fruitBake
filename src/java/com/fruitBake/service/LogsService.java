package com.fruitBake.service;

import com.fruitBake.domain.Logs;

import java.util.List;

public interface LogsService {

    public void insert(Logs logs);

    public List<Logs> findByNote(String noteId);

}
