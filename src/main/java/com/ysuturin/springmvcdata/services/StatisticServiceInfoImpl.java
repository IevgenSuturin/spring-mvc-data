package com.ysuturin.springmvcdata.services;

import com.ysuturin.springmvcdata.dao.dto.LineStatisticDto;
import com.ysuturin.springmvcdata.dao.entities.LineStatisticEntity;
import com.ysuturin.springmvcdata.dao.repository.ILineStatisticRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticServiceInfoImpl implements IStatisticInformationService {
    private final ILineStatisticRepository lineStatisticRepository;

    public StatisticServiceInfoImpl(ILineStatisticRepository lineStatisticRepository) {
        this.lineStatisticRepository = lineStatisticRepository;
    }

    @Override
    @Transactional
    public Iterable<LineStatisticDto> getAllLineStatistics() {
        List<LineStatisticDto> result = new ArrayList<>();
        for (LineStatisticEntity entity : lineStatisticRepository.getAllLineStatistics()) {
            result.add(new LineStatisticDto(entity));
        }
        return result;
    }

    @Override
    @Transactional
    public Iterable<LineStatisticDto> getLineStatisticsByFile(String fileName) {
        List<LineStatisticDto> result = new ArrayList<>();
        for (LineStatisticEntity entity : lineStatisticRepository.getLineStatisticsByFile(fileName)) {
            result.add(new LineStatisticDto(entity));
        }
        return result;
    }
}
