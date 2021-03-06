package model.persistencia.dao.hibernate.beans;
// default package
// Generated 22-ago-2015 18:58:10 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * TipoUsuario generated by hbm2java
 */
public class TipoUsuario extends GenericBean implements java.io.Serializable {

	private int idTipoUsuario;
	private String descTipoUsuario;
	private Set usuarioses = new HashSet(0);

	public TipoUsuario() {
	}

	public TipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public TipoUsuario(int idTipoUsuario, String descTipoUsuario, Set usuarioses) {
		this.idTipoUsuario = idTipoUsuario;
		this.descTipoUsuario = descTipoUsuario;
		this.usuarioses = usuarioses;
	}

	public int getIdTipoUsuario() {
		return this.idTipoUsuario;
	}

	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getDescTipoUsuario() {
		return this.descTipoUsuario;
	}

	public void setDescTipoUsuario(String descTipoUsuario) {
		this.descTipoUsuario = descTipoUsuario;
	}

	public Set getUsuarioses() {
		return this.usuarioses;
	}

	public void setUsuarioses(Set usuarioses) {
		this.usuarioses = usuarioses;
	}

}
