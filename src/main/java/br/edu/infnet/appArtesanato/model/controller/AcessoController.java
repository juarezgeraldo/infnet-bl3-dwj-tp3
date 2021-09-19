package br.edu.infnet.appArtesanato.model.controller;

import br.edu.infnet.appArtesanato.model.domain.Usuario;
import br.edu.infnet.appArtesanato.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@SessionAttributes("user")
@Controller
public class AcessoController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private AcessorioService acessorioService;
    @Autowired
    private BolsaService bolsaService;
    @Autowired
    private DecoracaoService decoracaoService;
    @Autowired
    private ArtesanatoService artesanatoService;
    @Autowired
    private EncomendaService encomendaService;

    @GetMapping(value = "/app")
    public String telaApp(Model model) {
        model.addAttribute("qtUsuarios", usuarioService.findAll().size());
        model.addAttribute("qtClientes", clienteService.findAll().size());
        model.addAttribute("qtAcessorios", acessorioService.findAll().size());
        model.addAttribute("qtBolsas", bolsaService.findAll().size());
        model.addAttribute("qtDecoracoes", decoracaoService.findAll().size());
        model.addAttribute("qtArtesanatos", artesanatoService.findAll().size());
        model.addAttribute("qtEncomendas", encomendaService.findAll().size());
        return "home";
    }

    @GetMapping(value = "/")
    public String telaHome() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String telaLogin() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(Model model, @RequestParam String email, @RequestParam String senha) {
        Usuario usuario = usuarioService.validar(email, senha);
        if(usuario != null) {
            model.addAttribute("user", usuario);
            return "index";
        } else {
            model.addAttribute("mensagem", "Autenticação inválida para o usuário "+ email +"!!!");
            return "login";
        }
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session, SessionStatus status) {
        status.setComplete();
        session.removeAttribute("user");
        return "redirect:/";
    }

}