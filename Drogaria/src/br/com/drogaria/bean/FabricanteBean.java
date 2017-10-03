package br.com.drogaria.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.dao.FrabricanteDAO;

@ManagedBean(name="MBFab")
@ViewScoped
public class FabricanteBean {
	private ListDataModel<Fabricante> fabricantes ;
	private Fabricante fabricante = new Fabricante();
	
	@PostConstruct
	public void carregarLista(){
		
		FrabricanteDAO dao = new FrabricanteDAO();
		fabricantes = new ListDataModel<Fabricante>(dao.listar());
	}
	public void init(){
	
	}
	
	public void salvar(){
		FrabricanteDAO dao = new FrabricanteDAO();
		dao.salvar(fabricante);
	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public ListDataModel<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(ListDataModel<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}
	
	

}
