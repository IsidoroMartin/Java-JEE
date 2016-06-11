// default package
// Generated 09-jun-2015 15:28:22 by Hibernate Tools 3.4.0.CR1
package model.dto;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Regions generated by hbm2java
 */
public class Regions extends GenericDTO implements java.io.Serializable {

	private BigDecimal regionId;
	private String regionName;
	private Set countrieses = new HashSet(0);

	public Regions() {
	}

	public Regions(BigDecimal regionId) {
		this.regionId = regionId;
	}

	public Regions(BigDecimal regionId, String regionName, Set countrieses) {
		this.regionId = regionId;
		this.regionName = regionName;
		this.countrieses = countrieses;
	}

	public BigDecimal getRegionId() {
		return this.regionId;
	}

	public void setRegionId(BigDecimal regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Set getCountrieses() {
		return this.countrieses;
	}

	public void setCountrieses(Set countrieses) {
		this.countrieses = countrieses;
	}

	@Override
	public String toString() {
		return "Regions [regionId=" + regionId + ", regionName=" + regionName;
	}
	
}