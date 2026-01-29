package src.it.unipv.posw.careconnectpro.jdbc.bean.persona;

import java.util.List;

import it.unipv.posw.careconnectpro.jdbc.bean.persona.PersonaDB;
import it.unipv.posw.careconnectpro.model.persona.Persona;

public interface IPersonaDAO {

    boolean insertPersona(it.unipv.posw.careconnectpro.jdbc.bean.persona.PersonaDB p);
    it.unipv.posw.careconnectpro.jdbc.bean.persona.PersonaDB selectPersonaByCf(String cf);
    it.unipv.posw.careconnectpro.jdbc.bean.persona.PersonaDB selectPersonaAttivaByCf(String cf);
	boolean deletePersona(Persona p);
	List<PersonaDB> selectPazienti();
}
