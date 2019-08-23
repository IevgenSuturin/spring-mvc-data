package com.ysuturin.springmvcdata.dao.repository;

import com.ysuturin.springmvcdata.dao.entities.LineStatisticEntity;

public interface ILineStatisticRepository {
    Iterable<LineStatisticEntity>getAllLineStatistics();
    Iterable<LineStatisticEntity>getLineStatisticsByFile(String fileName);
    Long saveEntity(LineStatisticEntity lineStatisticEntity);
}
