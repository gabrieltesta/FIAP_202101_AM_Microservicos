package br.com.fiap.am.controller;

import br.com.fiap.am.service.impl.ArquivoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

    @Autowired
    private ArquivoServiceImpl service;

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView view = new ModelAndView("home");
//        List<Intencao> intencoes = service.listaIntencoes();
//        view.addObject("intencoes", intencoes);
        return view;
    }
}
