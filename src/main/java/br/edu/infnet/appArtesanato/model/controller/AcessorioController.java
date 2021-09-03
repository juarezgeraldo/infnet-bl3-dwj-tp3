package br.edu.infnet.appArtesanato.model.controller;

import br.edu.infnet.appArtesanato.model.domain.Acessorio;
import br.edu.infnet.appArtesanato.model.domain.Usuario;
import br.edu.infnet.appArtesanato.model.service.AcessorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AcessorioController {

    @Autowired
    private AcessorioService acessorioService;

    @GetMapping(value = "/acessorio")
    public String telaCadastro() {
        return "/acessorio/cadastro";
    }

    @GetMapping("/acessorio/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("lista", acessorioService.obterLista(usuario));
        return "/acessorio/lista";
    }

    @PostMapping("/acessorio/incluir")
    public String incluir(Model model, Acessorio acessorio, @SessionAttribute("user") Usuario usuario) {
        new Acessorio(acessorio.getNome(), acessorio.getValorBase(), acessorio.isProprio());
        acessorio.setUsuario(usuario);
        acessorioService.incluir(acessorio);
        String mensagem = "O acessório "+ acessorio.getNome() +" foi cadastrado com sucesso!!!";
        model.addAttribute("msg", mensagem);
        return telaLista(model, usuario);
    }

    @GetMapping("/acessorio/{id}/excluir")
    public String excluir(Model model, @SessionAttribute("user") Usuario usuarioUser, @PathVariable Long id) {
        acessorioService.excluir(id);
        String mensagem = "O acessório "+ id +" foi excluído com sucesso!!!";
        model.addAttribute("msg", mensagem);
        return telaLista(model, usuarioUser);
    }

//    @GetMapping("/acessorio/{id}/editar")
//    public String editar(Model model, Acessorio acessorio, @PathVariable Long id) {
//        model.addAttribute("lista", acessorioService.editar(id));
//        new Acessorio(acessorio.getNome(), acessorio.getValorBase(), acessorio.isProprio());
//        acessorioService.editar(acessorio);
//        String mensagem = "O acessório "+ acessorio.getNome() +" foi cadastrado com sucesso!!!";
//        model.addAttribute("msg", mensagem);
//        return telaLista(model);
//        return "acessorio/cadastro";
//    }


}
