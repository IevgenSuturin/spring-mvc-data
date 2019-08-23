package com.ysuturin.springmvcdata.dao.dto;

import com.ysuturin.springmvcdata.dao.entities.LineStatisticEntity;

public class LineStatisticDto {
    private Long id;
    private Long maxWordLength;
    private Long minWordLength;
    private Long lineLength;
    private Double avgWordLength;
    private String fileName;

    public LineStatisticDto(LineStatisticEntity lineStatisticEntity)
    {
        id=lineStatisticEntity.getLineLength();
        maxWordLength=lineStatisticEntity.getMaxWordLength();
        minWordLength=lineStatisticEntity.getMinWordLength();
        lineLength=lineStatisticEntity.getLineLength();
        avgWordLength=lineStatisticEntity.getAvgWordLength();
        fileName=lineStatisticEntity.getFileName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMaxWordLength() {
        return maxWordLength;
    }

    public void setMaxWordLength(Long maxWordLength) {
        this.maxWordLength = maxWordLength;
    }

    public Long getMinWordLength() {
        return minWordLength;
    }

    public void setMinWordLength(Long minWordLength) {
        this.minWordLength = minWordLength;
    }

    public Long getLineLength() {
        return lineLength;
    }

    public void setLineLength(Long lineLength) {
        this.lineLength = lineLength;
    }

    public Double getAvgWordLength() {
        return avgWordLength;
    }

    public void setAvgWordLength(Double avgWordLength) {
        this.avgWordLength = avgWordLength;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
