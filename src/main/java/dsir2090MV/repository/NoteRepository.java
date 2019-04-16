package dsir2090MV.repository;

import dsir2090MV.main.ClasaException;
import dsir2090MV.model.Nota;

import java.util.List;


public interface NoteRepository {
	
	public void addNota(Nota nota) throws ClasaException;
	public List<Nota> getNote(); 
	public void readNote(String fisier);
	
}
