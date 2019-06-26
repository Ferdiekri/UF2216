package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.List;

public class DAORevistaArrayList implements ILeible<Revista> {

	private ArrayList<Revista> lista;
	private static DAORevistaArrayList INSTANCE;

	public static synchronized DAORevistaArrayList getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new DAORevistaArrayList();
		}
		return INSTANCE;
	}

	public DAORevistaArrayList() {
		super();
		this.lista = new ArrayList<Revista>();
	}
	/////////////////////////////////////////////////////////////

	@Override
	public List<Revista> getTodasRevistas() {
		return lista;
	}

	@Override
	public boolean nuevaRevista(Revista pojo) {
		return lista.add(pojo);
	}
}