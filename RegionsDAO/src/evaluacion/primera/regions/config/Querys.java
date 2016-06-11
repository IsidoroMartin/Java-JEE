package evaluacion.primera.regions.config;

import evaluacion.primera.regions.model.RegionDTO;

public class Querys {
	public static final String GETALLREGIONS = "select * from regions";
	public static final String GETREGION = "select * from regions where REGION_ID=";
	public static String construirInsertRegion(RegionDTO region){
		return  "INSERT INTO REGIONS VALUES("+region.getId()+",'"+region.getName()+"')";
	}
}
