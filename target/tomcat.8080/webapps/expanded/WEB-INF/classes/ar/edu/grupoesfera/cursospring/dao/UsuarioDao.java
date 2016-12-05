package ar.edu.grupoesfera.cursospring.dao;

import java.util.List;

import ar.edu.grupoesfera.cursospring.dto.ListadoBandasDTO;

public interface UsuarioDao {
	
	List<ListadoBandasDTO> buscarUsuarioBandaPor(String email);

}
