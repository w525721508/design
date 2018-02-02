package design.root.entity;

import java.util.List;

import design.root.base.BaseEntity;

public class ApiDataEntity extends BaseEntity {
    private List<Topic> data;
    private int pageSize;
    private int totalItems;
    private int totalPages;

    public List<Topic> getData() {
        return data;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public String getNextPageUrl() {
        return "?lastCursor=" + data.get(data.size() - 1).getOrder() + "&pageSize=10";
    }
}
