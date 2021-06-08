package br.com.fiap.am.controller;

import br.com.fiap.am.dto.Arquivo;
import br.com.fiap.am.service.impl.ArquivoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller

public class ListController {

    @Autowired
    ArquivoServiceImpl service;

    @GetMapping("/lista")
    public ModelAndView listaArquivos() {
        ModelAndView view = new ModelAndView("list");
        List<Arquivo> arquivos = service.listaArquivos();
        view.addObject("arquivos", arquivos);
        return view;
    }

    @PostMapping("/arquivo/salvar")
    public String salvarArquivo(Arquivo arquivo, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute(arquivo);
            return "arquivo";
        }
        service.salvarArquivo(arquivo);
        return "redirect:/lista";
    }
}
