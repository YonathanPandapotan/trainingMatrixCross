package com.usery.training2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MainController {

    @GetMapping("/")
    public String homepage(@RequestParam(name = "name", required = false, defaultValue = "Yonathan") String name, Model model) {

        MatrixCross matrixCross = new MatrixCross(25, 15);
        matrixCross.seedArray();
        matrixCross.markCross();

        model.addAttribute("countZero", matrixCross.getCountZero());
        model.addAttribute("countOne", matrixCross.getCountOne());
        model.addAttribute("array", matrixCross.getArr());
        model.addAttribute("answers", matrixCross.getAnswers());
        return "home_page";
    }

}
