package com.example.moviestreamingapp.models;

import java.util.List;

public class AllCategory {

   int categoryID;
   String categoryTitle;
   private List<CategoryItem> categoryItemList=null;

    public AllCategory(int categoryID, String categoryTitle, List<CategoryItem> categoryItemList) {
        this.categoryID = categoryID;
        this.categoryTitle = categoryTitle;
        this.categoryItemList = categoryItemList;
    }

    public List<CategoryItem> getCategoryItemList() {
        return categoryItemList;
    }

    public void setCategoryItemList(List<CategoryItem> categoryItemList) {
        this.categoryItemList = categoryItemList;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
}
