package br.com.cursojsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;

@ViewScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean {

	private String nome;
	
	private String senha;
	
	private String texto;
	
	private HtmlCommandButton commandButton;
	
	private List<String> nomes = new ArrayList<String>();
	
	public String addNome() {
		nomes.add(nome);
		if (nomes.size() > 2) {
			commandButton.setDisabled(true);
			return "paginanavegada?faces-redirect=true";
		}
		
		return "";
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getTexto() {
		return texto;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setCommandButton(HtmlCommandButton commandButton) {
		this.commandButton = commandButton;
	}
	
	public HtmlCommandButton getCommandButton() {
		return commandButton;
	}

	public void setNomes(List<String> nomes) {
		this.nomes = nomes;
	}
	public List<String> getNomes() {
		return nomes;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
