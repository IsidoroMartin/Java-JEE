package model.persistencia.interfaces;

import model.dto.GenericDTO;

public interface CRUD {
	public boolean create(GenericDTO o);
	public GenericDTO read(GenericDTO pk);
	public boolean update(GenericDTO o);
	public boolean delete(GenericDTO o);
	
}
