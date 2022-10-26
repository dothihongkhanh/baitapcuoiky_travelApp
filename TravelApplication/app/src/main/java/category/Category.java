package category;

import java.util.List;

import tour.Tour;

public class Category {
    private String nameCategory;
    private List<Tour> tours;

    public Category(String nameCategory, List<Tour> tours) {
        this.nameCategory = nameCategory;
        this.tours = tours;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }
}
