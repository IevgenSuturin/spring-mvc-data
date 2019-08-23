package com.ysuturin.springmvcdata.services;

import com.ysuturin.springmvcdata.dao.dto.LineStatisticDto;

public interface IStatisticInformationService {
    Iterable<LineStatisticDto>getAllLineStatistics();
    Iterable<LineStatisticDto>getLineStatisticsByFile(String fileName);
}
