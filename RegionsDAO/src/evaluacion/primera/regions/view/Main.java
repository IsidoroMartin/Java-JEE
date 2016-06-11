package evaluacion.primera.regions.view;

import java.util.ArrayList;

import evaluacion.primera.regions.model.RegionDTO;
import evaluacion.primera.regions.persistance.RegionDAO;

public class Main {
	public static void main(String[] args) {
		RegionDAO rg = new RegionDAO();
		ArrayList<RegionDTO> regiones = rg.getRegions();
		for (RegionDTO regionDTO : regiones) {
			System.out.println(regionDTO);
		}
		
//		rg.insertRegion(new RegionDTO(7, "Obama"));
		System.out.println(rg.getRegion(565)+"--");
	}
}
