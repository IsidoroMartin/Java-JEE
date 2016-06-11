package evaluacion.primera.regions.model;
/**
 * Entidad Region del modelo de negocio
 * @author Whiteclown
 *
 */
public class RegionDTO {
	private int id;
	private String name;
	public RegionDTO(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Region id:" + id + ", Region name:" + name;
	}
	
}
