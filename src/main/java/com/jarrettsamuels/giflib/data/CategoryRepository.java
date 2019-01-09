package com.jarrettsamuels.giflib.data;

import com.jarrettsamuels.giflib.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {

    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "Funny"),
            new Category(2, "Weird"),
            new Category(3, "Strange")
    );

    public List<Category> getAllCategories(){
        return ALL_CATEGORIES;
    }

    public Category findById(int id){
        for (Category c: ALL_CATEGORIES) {
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }

}
