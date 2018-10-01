package com.nit.cs161.lost_and_found.dto.json;

/**
 * @Description: 商品规格口味
 * @Author: pcw
 * @Date: 2018/8/9 17:55
 */
public class GoodsAttrJSON {
    private Integer goodsSkuVolume;
    private String goodsSkuTaste;
    private String goodsSkuUnit;

    public Integer getGoodsSkuVolume() {
        return goodsSkuVolume;
    }

    public void setGoodsSkuVolume(Integer goodsSkuVolume) {
        this.goodsSkuVolume = goodsSkuVolume;
    }

    public String getGoodsSkuTaste() {
        return goodsSkuTaste;
    }

    public void setGoodsSkuTaste(String goodsSkuTaste) {
        this.goodsSkuTaste = goodsSkuTaste;
    }

    public String getGoodsSkuUnit() {
        return goodsSkuUnit;
    }

    public void setGoodsSkuUnit(String goodsSkuUnit) {
        this.goodsSkuUnit = goodsSkuUnit;
    }
}
