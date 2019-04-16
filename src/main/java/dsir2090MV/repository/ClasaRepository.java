package dsir2090MV.repository;



import dsir2090MV.main.ClasaException;
import dsir2090MV.model.Corigent;
import dsir2090MV.model.Elev;
import dsir2090MV.model.Medie;
import dsir2090MV.model.Nota;

import java.util.HashMap;
import java.util.List;

public interface ClasaRepository {
	
	public void creazaClasa(List<Elev> elevi, List<Nota> note);
	public HashMap<Elev, HashMap<String, List<Double>>> getClasa();
	public List<Medie> calculeazaMedii() throws ClasaException;
	public void afiseazaClasa();
	public List<Corigent> getCorigenti();
}
