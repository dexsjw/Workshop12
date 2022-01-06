package nus.iss.workshop12.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import nus.iss.workshop12.exception.RandomNumberException;
import nus.iss.workshop12.model.Generate;

@Controller
public class GenerateController {

    private Logger logger = LoggerFactory.getLogger(GenerateController.class);

    @GetMapping("/generate")
    public String showGenerateForm(Model model) {
        Generate generate = new Generate();
        model.addAttribute("generate", generate);       // this "generate" ties to th
        return "generate";                              // this "generate" ties to model -> generate object
    }

    @PostMapping("/generate")
    public String generateNumbers(@ModelAttribute Generate generate, Model model) {
        logger.info("From the form " + generate.getNumberVal());
        int numberRandomNumbers = generate.getNumberVal();
        if (numberRandomNumbers > 10) {
            //throw new RandomNumberException();
            model.addAttribute("errorMessage", "Number exceeded 10!");
            return "error";
        }
        String[] imgNumbers = {
            "Number_1.jpg", "Number_2.jpg", "Number_3.jpg", "Number_4.jpg", "Number_5.jpg",
            "Number_6.jpg", "Number_7.jpg", "Number_8.jpg", "Number_9.jpg", "Number_10.jpg"
        };
        List<String> selectedImg = new ArrayList<>();
        Random randNum = new Random();
        Set<Integer> uniqueGeneratedRandNumSet = new LinkedHashSet<Integer>();
        while (uniqueGeneratedRandNumSet.size() < numberRandomNumbers) {
            Integer resultOfRandNumbers = randNum.nextInt(generate.getNumberVal() + 1);
            uniqueGeneratedRandNumSet.add(resultOfRandNumbers);
        }
        
        Iterator<Integer> it = uniqueGeneratedRandNumSet.iterator();
        Integer currentElem = null;
        while (it.hasNext()) {
            currentElem = it.next();
            logger.info("currenElem: " + currentElem);
            selectedImg.add(imgNumbers[currentElem.intValue()]);
        }
        model.addAttribute("randNumsResult", selectedImg.toArray());
        return "result";
    }

}
