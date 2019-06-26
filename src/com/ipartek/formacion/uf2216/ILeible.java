package com.ipartek.formacion.uf2216;

import java.util.List;

public interface ILeible<P> {

	List<P> getTodasRevistas();

	boolean nuevaRevista(P pojo);

}
