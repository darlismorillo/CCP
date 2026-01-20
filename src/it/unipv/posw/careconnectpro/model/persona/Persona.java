package it.unipv.posw.careconnectpro.model.persona;

import java.time.LocalDate;

public abstract class Persona {

    private TipoUtente tipoUtente;
    private String codiceFiscale;
	private String nome;
	private String cognome;
	private LocalDate dataNascita, dataInizio;
	private String email;
	private String cellulare;
    private String id;
    private String password;
    private static final int MAX_PASSWORD = 8;

	
	public Persona(String codiceFiscale, String nome, String cognome, LocalDate dataNascita, String email,
			String cellulare, String id, String password, TipoUtente tipoUtente, LocalDate dataInizio) {
		this.codiceFiscale = codiceFiscale;
        this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.email = email;
		this.cellulare = cellulare;
        this.id = id;
        this.setPassword(password);
        this.tipoUtente = tipoUtente;
        this.dataInizio = dataInizio;
	}

	public String getCodiceFiscale() { return codiceFiscale; }
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	public String getCognome() { return cognome; }
	public void setCognome(String cognome) { this.cognome = cognome; }
	public LocalDate getDataNascita() { return dataNascita; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getCellulare() { return cellulare; }
	public void setCellulare(String cellulare) { this.cellulare = cellulare; }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        if (password != null && password.length() > MAX_PASSWORD) {
            throw new IllegalArgumentException( "La password supera gli "+ MAX_PASSWORD +" caratteri massimi consentiti");
        }
    }
    public String getId() {
        return id;
    }
    public TipoUtente getTipoUtente() {
        return tipoUtente;
    }
    public LocalDate getDataInizio() {
        return dataInizio;
    }
}