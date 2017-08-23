package com.raya.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @GetMapping("/tvForm")
    public String loadTvForm(Model model){
        model.addAttribute("tvshow",new TvShow());
        return "tvForm";
    }

    @PostMapping("/tvForm")
    public String processTvForm(@Valid TvShow tvshow, BindingResult result, Model model){
        model.addAttribute("tvshow",tvshow);
        if (result.hasErrors()){
            return "tvForm";
        }

        return "tvShowConfirm";
    }
}
