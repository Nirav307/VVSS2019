package dsir2090MV.repository;

import java.util.List;

import dsir2090MV.model.Elev;

public interface EleviRepository {
	public void addElev(Elev e);
	public List<Elev> getElevi();
	public void readElevi(String fisier);
}
