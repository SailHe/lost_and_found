package com.nit.cs161.lost_and_found.utility;

import com.nit.cs161.lost_and_found.constant.general.EnumSearchType;

/**
 * Description: 仅用于搜索的处理<p>
 *
 * @Package: com.nit.cs161.lost_and_found.utility
 * @author: SailHe
 * @date: 2018/7/28 14:24
 */
public class SearchValue {
    private EnumSearchType searchType;
    private String searchValue;

    public EnumSearchType getSearchType() {
        return searchType;
    }

    public void setSearchType(EnumSearchType searchType) {
        this.searchType = searchType;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
}
