package pl.coderslab.beans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Controller
public class HelloController {

    @GetMapping("/workers")
    public String workersAction(Model model) {
        Random random = new Random();
        int r = random.nextInt(31);
        String name = "no name";
        Path dir = Paths.get("/home/wojtek/Spring_homework_02/Workers.txt");
        if (!Files.exists(dir)) {
            System.out.println("File not exist.");
            System.exit(0);
        }
        try {
            List<String> strings = Files.readAllLines(dir);

            for (int i = 0; i < strings.size(); i++) {
                String[] split = strings.get(i).split(",");
                if (r == Integer.parseInt(split[0])) {
                    name = split[1];
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("name", name);
        model.addAttribute("number", r);
        return "workers.jsp";
    }

    @GetMapping("/parseint")
    @ResponseBody
    public String parseInt(@RequestParam String string) {
        int number = Integer.parseInt(string);
        return String.valueOf(number + number);
    }
}
