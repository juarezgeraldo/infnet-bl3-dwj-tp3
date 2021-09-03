package br.edu.infnet.appArtesanato.model.controller;

import br.edu.infnet.appArtesanato.model.domain.Usuario;
import br.edu.infnet.appArtesanato.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/usuario/cadastro")
    public String telaCadastro(){
        return "/usuario/cadastro";
    }

    @GetMapping("/usuario/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuarioUser, Usuario usuario) {
        model.addAttribute("lista", usuarioService.obterLista());
        return "/usuario/lista";
    }

    @PostMapping(value = "/usuario/incl")
    public String incluir(Usuario usuario){
        usuarioService.incluir(usuario);
        return "redirect:/";
    }

    @PostMapping(value = "/usuario/incluir")
    public String incluir(Model model, @SessionAttribute("user") Usuario usuarioUser ,Usuario usuario){
        usuarioService.incluir(usuario);
        String mensagem = "O usuário "+ usuario.getNome() +" foi cadastrado com sucesso!!!";
        model.addAttribute("msg", mensagem);
        String idMsg = "sucesso";
        model.addAttribute("idMsg", idMsg);
        if (usuarioUser.getId() != null){
            return telaLista(model, usuarioUser,  usuario);
        }
        return "redirect:/";
    }

    @GetMapping("/usuario/{id}/excluir")
    public String excluir(Model model, @SessionAttribute("user") Usuario usuarioUser, @PathVariable Long id) {
        if (usuarioUser.getId() != id){
            usuarioService.excluir(id);
            String mensagem = "O usuário "+ id +" foi excluído com sucesso!!!";
            model.addAttribute("msg", mensagem);
            String idMsg = "sucesso";
            model.addAttribute("idMsg", idMsg);
        } else{
            String mensagem = "O próprio usuário "+ usuarioUser.getNome() +" NÃO pode se excluir!!!";
            model.addAttribute("msg", mensagem);
            String idMsg = "erro";
            model.addAttribute("idMsg", idMsg);
        }
        return telaLista(model, usuarioUser, null);
    }

}
