package br.com.lista.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.lista.entidade.Contato;

@ManagedBean
@SessionScoped
public class ContatoBean {

	private Contato contato = new Contato();
	private List<Contato> contatos = new ArrayList<>();
	
	public void adiciona(ActionEvent actionEvent) {
		if(contato.getNome().equals("") | contato.getTelefone().equals("") | contato.getEmail().equals("")) {
			addMessage("Preencha os dados corretamente!");
		}else {
			contato.setId(contatos.size()+1);
			contatos.add(contato);
			contato = new Contato();
			addMessage("Adicionado com sucesso!");
		}
	}
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	
}
