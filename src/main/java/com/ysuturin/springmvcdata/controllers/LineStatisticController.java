package com.ysuturin.springmvcdata.controllers;

import com.ysuturin.springmvcdata.dao.dto.LineStatisticDto;
import com.ysuturin.springmvcdata.services.IStatisticInformationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lines")
public class LineStatisticController {
    private final IStatisticInformationService statisticInformationService;

    public LineStatisticController(IStatisticInformationService statisticInformationService) {
        this.statisticInformationService = statisticInformationService;
    }

    @GetMapping(produces = {"application/json"})
    public Iterable<LineStatisticDto> getAllStatistics(){
        return statisticInformationService.getAllLineStatistics();
    }

    @GetMapping(produces = {"application/json"}, value = "{fileName}")
    public Iterable<LineStatisticDto> getLineStatisticsByFile(@PathVariable String fileName){
        return statisticInformationService.getLineStatisticsByFile(fileName);
    }
}
