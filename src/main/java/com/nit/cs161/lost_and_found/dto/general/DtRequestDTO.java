package com.nit.cs161.lost_and_found.dto.general;


import java.util.List;

public class DtRequestDTO {
    public Integer draw;
    public Integer start;
    public Integer length;
    public String search;
    public List<String> multiSearchKeyList;
    public List<String> multiSearchValueList;

    public DtRequestDTO() {
    }

    public DtRequestDTO(Integer draw, Integer start, Integer length, String search) {
        this.draw = draw;
        this.start = start;
        this.length = length;
        this.search = search;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public List<String> getMultiSearchKeyList() {
        return multiSearchKeyList;
    }

    public void setMultiSearchKeyList(List<String> multiSearchKeyList) {
        this.multiSearchKeyList = multiSearchKeyList;
    }

    public List<String> getMultiSearchValueList() {
        return multiSearchValueList;
    }

    public void setMultiSearchValueList(List<String> multiSearchValueList) {
        this.multiSearchValueList = multiSearchValueList;
    }
}
