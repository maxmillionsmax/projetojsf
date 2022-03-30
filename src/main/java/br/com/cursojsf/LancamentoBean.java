package br.com.cursojsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.dao.DaoGeneric;
import br.com.entidades.Lancamento;
import br.com.entidades.Pessoa;
import br.com.repository.IDaoLancamento;

@javax.faces.view.ViewScoped
@Named(value = "lancametoBean")
public class LancamentoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Lancamento lancamento = new Lancamento();
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();

	@Inject
	private DaoGeneric<Lancamento> daoGeneric;
    @Inject
	private IDaoLancamento daoLancamento;

    public String salvar() {

		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		Pessoa pessoaUser = (Pessoa) externalContext.getSessionMap().get("usuarioLogado");

		lancamento.setUsuario(pessoaUser);
		lancamento = daoGeneric.merger(lancamento);
		
		
		carregarlancamentos();
		lancamento = new Lancamento();

		return "";
	}

	@PostConstruct
	private void carregarlancamentos() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		Pessoa pessoaUser = (Pessoa) externalContext.getSessionMap().get("usuarioLogado");
		lancamentos = daoLancamento.consultar(pessoaUser.getId());
	}

	public String novo() {
		
		lancamento = new Lancamento();

		return "";
	}

	public String remove() {
		
		daoGeneric.deletePorId(lancamento);
		lancamento = new Lancamento();
		carregarlancamentos();
		
		return "";
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public DaoGeneric<Lancamento> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Lancamento> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

}
