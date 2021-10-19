package com.bootcamp.BootcampTelemed.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.ArrayList;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class ControlerToDo {
    List<String> todoList = new ArrayList<String>();
    @GetMapping("/save")
    public void saveToDoList(@RequestParam String text,
                              HttpServletResponse response) throws IOException {
        System.out.println("Dobio sam to do list: " + text);
        todoList.add(text);
        response.getWriter().println("<html>");
        response.getWriter().println("Thank you! <br/><br/>");
        response.getWriter().println("To do items <br/>");
        for (String i : todoList)
            response.getWriter().println(i + "<br/>");
        response.getWriter().println( "</html>");
    }

    @GetMapping("/listall")
    void listAll(HttpServletResponse response) throws IOException {
        for(String i : todoList)
            response.getWriter().println(i);
    }
}

