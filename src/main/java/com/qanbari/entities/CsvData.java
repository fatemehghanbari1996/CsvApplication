package com.qanbari.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.w3c.dom.Text;

import java.util.Date;

public class CsvData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;
    private String source;
    private String codeListCode;
    private String displayValue;
    private Date fromDate;
    private Date toDate;
    private Text longDescription;
    private int sortingPriority;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCodeListCode() {
        return codeListCode;
    }

    public void setCodeListCode(String codeListCode) {
        this.codeListCode = codeListCode;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Text getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(Text longDescription) {
        this.longDescription = this.longDescription;
    }

    public int getSortingPriority() {
        return sortingPriority;
    }

    public void setSortingPriority() {
        this.sortingPriority = sortingPriority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setFromDate() {
    }

    public void setToDate() {
    }

    public void setSortingPriority(int sortingPriority) {

    }
}



