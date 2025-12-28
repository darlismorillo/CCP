public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver trovato e caricato con successo!");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver non trovato! Controlla il Classpath.");
            e.printStackTrace();
        }
    }
}
