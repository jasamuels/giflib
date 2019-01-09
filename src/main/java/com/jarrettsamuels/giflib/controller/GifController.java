package com.jarrettsamuels.giflib.controller;

import com.jarrettsamuels.giflib.data.GifRepository;
import com.jarrettsamuels.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    public String listGifs(ModelMap modelMap){
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("gifs", allGifs);
        return "home";
    }

    // URL => http://localhost:8080/gif/android-explosion
    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap){

        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);

        return "gif-details";
    }

    @RequestMapping("/favorites")
    public String favorites(ModelMap modelMap){
        List<Gif> favorites = gifRepository.getFavorites();
        modelMap.put("favorites", favorites);
        return "favorites";
    }

    @RequestMapping("/search")
    public String search(@RequestParam("q") String search, ModelMap modelMap){
        List<Gif> gifs = gifRepository.searchByName(search);
        modelMap.put("gifs", gifs);
        return "search";
    }
}
