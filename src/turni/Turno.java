package turni;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
	
	private int idTurno;
	private String idDipendente;
	private short pianoAssegnato;
	private LocalDate dataTurno;
	private LocalTime oraInizio;
	private LocalTime oraFine;
	
	
	public Turno(int idTurno, String idDipendente, short pianoAssegnato, LocalDate dataTurno, LocalTime oraInizio,
			LocalTime oraFine) {
		super();
		this.idTurno = idTurno;
		this.idDipendente = idDipendente;
		this.pianoAssegnato = pianoAssegnato;
		this.dataTurno = dataTurno;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
	}


	public int getIdTurno() {
		return idTurno;
	}


	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}


	public String getIdDipendente() {
		return idDipendente;
	}


	public void setIdDipendente(String idDipendente) {
		this.idDipendente = idDipendente;
	}


	public short getPianoAssegnato() {
		return pianoAssegnato;
	}


	public void setPianoAssegnato(short pianoAssegnato) {
		this.pianoAssegnato = pianoAssegnato;
	}


	public LocalDate getDataTurno() {
		return dataTurno;
	}


	public void setDataTurno(LocalDate dataTurno) {
		this.dataTurno = dataTurno;
	}


	public LocalTime getOraInizio() {
		return oraInizio;
	}


	public void setOraInizio(LocalTime oraInizio) {
		this.oraInizio = oraInizio;
	}


	public LocalTime getOraFine() {
		return oraFine;
	}


	public void setOraFine(LocalTime oraFine) {
		this.oraFine = oraFine;
	}
	
	
	
	
	

}
