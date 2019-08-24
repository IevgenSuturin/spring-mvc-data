package com.ysuturin.springmvcdata.services;

import com.ysuturin.springmvcdata.dao.entities.LineStatisticEntity;
import com.ysuturin.springmvcdata.dao.repository.ILineStatisticRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class StatisticManipulationServiceImpl implements IStatisticManipulationService {
    private final ILineStatisticRepository lineStatisticRepository;

    public StatisticManipulationServiceImpl(ILineStatisticRepository lineStatisticRepository) {
        this.lineStatisticRepository = lineStatisticRepository;
    }

    @Override
    @Transactional
    public void makeFileInvestigation(String fileName) {
        try {
            List<String> lines = parseFileForLines(fileName);
            for (String line:lines) {
                LineStatisticEntity entity = CalculateStatisticsForLine(line, fileName);
                lineStatisticRepository.saveEntity(entity);
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    private List<String> parseFileForLines(String fileName) throws FileNotFoundException {
        List<String> lines = new ArrayList<>();

        try(Scanner scanner = new Scanner(new File(fileName))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    lines.add(line);
                }
            }
        }
        return lines;
    }

    private LineStatisticEntity CalculateStatisticsForLine(String line, String fileName){
        List<String> words = new ArrayList<String>( Arrays.asList(line.split(" ")))
                .stream().filter(((Predicate<String>) String::isEmpty).negate())
                .collect(Collectors.toList());
        Long maxWordLength = words.stream().mapToLong(String::length).max().orElse(0);
        Long minWordLength = words.stream().mapToLong(String::length).min().orElse(0);
        Double avgWordLength = words.stream().mapToInt(String::length).average().getAsDouble();
        Long lineLength = Long.valueOf(line.length());
        LineStatisticEntity entity = new LineStatisticEntity(maxWordLength, minWordLength, lineLength, avgWordLength, fileName);
        return entity;
    }
}
