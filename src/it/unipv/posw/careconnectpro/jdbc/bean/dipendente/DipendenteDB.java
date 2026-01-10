package it.unipv.posw.careconnectpro.jdbc.bean.dipendente;

import it.unipv.posw.careconnectpro.model.persona.dipendente.TipoDipendente;

import java.time.LocalDate;

public class DipendenteDB {

		private final String codiceFiscale;
		private final String nome;
		private final  String cognome;
		private final LocalDate dataNascita;
		private final String email;
		private final String numeroTelefonico;
		private final String idDipendente;
		private final String password;
		private final String ruolo;
		private final LocalDate dataInizio;
		
		public DipendenteDB(	String codiceFiscale, 
							String nome, 
							String cognome, 
							LocalDate dataNascita, 
							String email,
							String numeroTelefonico, 
							String idDipendente, 
							String password, 
							String ruolo,
							LocalDate dataInizio) {
			this.codiceFiscale = codiceFiscale;
			this.nome = nome;
			this.cognome = cognome;
			this.dataNascita = dataNascita;
			this.email = email;
			this.numeroTelefonico = numeroTelefonico;
			this.idDipendente = idDipendente;
			this.password = password;
			this.ruolo = ruolo;
			this.dataInizio = dataInizio;
		}

		public String getCodiceFiscale() {	return codiceFiscale;	}
		public String getNome() {	return nome;	}
		public String getCognome() {	return cognome;	}
		public LocalDate getDataNascita() {	return dataNascita;	}
		public String getEmail() {	return email;	}
		public String getNumeroTelefonico() {	return numeroTelefonico;	}
		public String getIdDipendente() {	return idDipendente;	}
		public String getPassword() {	return password;	}
		public String getRuolo() {	return ruolo;	}
		public LocalDate getDataInizio() {	return dataInizio;	}

}

