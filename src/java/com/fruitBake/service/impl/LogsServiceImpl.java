package com.fruitBake.service.impl;

import com.fruitBake.dao.LogsDao;
import com.fruitBake.domain.Logs;
import com.fruitBake.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("logsService")
public class LogsServiceImpl implements LogsService {

    @Autowired
    private LogsDao logsDao;

    @Override
    public void insert(Logs logs) {
        logsDao.insert(logs);
    }
}
