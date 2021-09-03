package br.edu.infnet.appArtesanato.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Encomenda {
    private LocalDateTime data;
    private boolean feira;
    private String observacao;
    private Cliente cliente;
    private Usuario usuario;

    public Encomenda(){
        this.data = LocalDateTime.now();
    }

    public Encomenda(LocalDateTime data, boolean feira, String observacao) {
        this.data = data;
        this.feira = feira;
        this.observacao = observacao;
    }

    public String obterEncomenda() {
        return String.format("Realizada por: %s - Dia: %s - Usuário: %s ===> %s",
                this.cliente.getNome(),
                this.data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                this.usuario.getNome(),
                this.feira ? "Pela Feira" : "Pelo Telefone");
    }

    @Override
    public String toString() {
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        StringBuilder sb = new StringBuilder();
        sb.append(this.data.format(dataFormatada));
        sb.append(";");
        sb.append(this.feira ? "Pela Feira" : "Pelo Telefone");
        sb.append(";");
        sb.append(this.observacao);
        sb.append(";");
        return sb.toString();
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public boolean isFeira() {
        return feira;
    }

    public void setFeira(boolean feira) {
        this.feira = feira;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
