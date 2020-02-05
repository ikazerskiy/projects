package net.ikazerskiy.projects.service.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class SearchResult<T> implements Serializable {

    private List<T> searchResult = new ArrayList<>();

    public List<T> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<T> searchResult) {
        this.searchResult = searchResult;
    }
}
