package br.com.drogaria.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Produto;
import javax.faces.model.SelectItem;

@ManagedBean(name="MBProd")
@ViewScoped
public class ProdutoBean {

	private ArrayList<SelectItem> produtos = new ArrayList<SelectItem>();
	private Produto produto = new Produto();
	
	@PostConstruct
	public void carregarLista(){
		ProdutoDAO dao = new ProdutoDAO();
		for (Produto p : dao.listar()) {
			produtos.add(new SelectItem(p.getCodigo(),p.getNome()));
		}
	}

	public void salvar(){
		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(produto);
		
	}
	
	public ArrayList<SelectItem> getProdutos() {
		return produtos;
	}


	public void setProdutos(ArrayList<SelectItem> produtos) {
		this.produtos = produtos;
	}


	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
	
}
