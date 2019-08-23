package com.ysuturin.springmvcdata.dao.entities;

import com.ysuturin.springmvcdata.dao.dto.LineStatisticDto;

import javax.persistence.*;

@Entity
@Table(name = "LINESTATISTIC")
public class LineStatisticEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lineStatisticSequence")
    @SequenceGenerator(name = "lineStatisticSequence", sequenceName = "statistic_sequence")
    @Column(name = "ID")
    private Long id;
    @Column(name = "MAXWORDLENGTH")
    private Long maxWordLength;
    @Column(name = "MINWORDLENGTH")
    private Long minWordLength;
    @Column(name = "LINELENGTH")
    private Long lineLength;
    @Column(name = "AVGWORDLENGTH")
    private Double avgWordLength;
    @Column(name = "FILENAME")
    private String fileName;

    protected LineStatisticEntity(){}

    public LineStatisticEntity(LineStatisticDto lineStatisticDto){
        id=lineStatisticDto.getLineLength();
        maxWordLength=lineStatisticDto.getMaxWordLength();
        minWordLength=lineStatisticDto.getMinWordLength();
        lineLength=lineStatisticDto.getLineLength();
        avgWordLength=lineStatisticDto.getAvgWordLength();
        fileName=lineStatisticDto.getFileName();
    }

    public LineStatisticEntity(Long maxWordLength, Long minWordLength, Long lineLength, Double avgWordLength, String fileName) {
        this.maxWordLength = maxWordLength;
        this.minWordLength = minWordLength;
        this.lineLength = lineLength;
        this.avgWordLength = avgWordLength;
        this.fileName = fileName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LineStatisticEntity)) return false;

        LineStatisticEntity that = (LineStatisticEntity) o;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
