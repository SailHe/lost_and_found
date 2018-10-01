package com.nit.cs161.lost_and_found.dto.general;


public class DtResponseDTO {
    private Integer draw;
    private Integer recordsTotal;
    private Integer recordsFiltered;
    private Object data;

    public DtResponseDTO() {
    }

    public DtResponseDTO(Integer draw, Integer recordsTotal, Integer recordsFiltered, Object data) {
        this.draw = draw;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.data = data;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DtResponseDTO [draw=" + draw + ", recordsTotal=" + recordsTotal + ", recordsFiltered="
                + recordsFiltered + ", data=" + data + "]";
    }
}
