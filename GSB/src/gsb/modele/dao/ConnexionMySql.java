/*
 * Créé le 23 sept. 2014
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.modele.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Isabelle
 * 23 sept. 2014
 * TODO Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
public class ConnexionMySql { // DAO = Data Access Object
	
	static Connection cnx;
	
	public ConnexionMySql(){
		cnx = null;
	}
	
	/**
	 * methode qui permet la connexion à la base de données
	 * le fait que la méthode soit static permet d'éviter d'instancier dans une classe un objet ConnexioMySql
	 * pour utiliser cette méthode écrire : ConnexionMySql.connecterBd()
	 */
	public static void connecterBd(){
		//connexion à la base de donnée à partir de jdbc
		String url = "jdbc:mysql://192.168.43.218:3306/gsbV3"; // url : chaine de connexion
		// try permet d'essayer de lancer la connexion
		try {Class.forName("com.mysql.jdbc.Driver"); 
			cnx = DriverManager.getConnection(url,"admindb","password"); 
		} 
		// si la connexion echoue un message d'erreur est affiché
        catch(Exception e) {  System.out.println("Echec lors de la connexion");  } 

	}
	
	/**
	 * @param laRequete requête SQL de type SELECT
	 * @param unMessage message qui contient en principe le nom de la classe + le nom de la méthode appelée (pour le débogage)
	 * @return un curseur qui contient les lignes obtenues lors de l'exécution de la requête, null sinon
	 * pour utiliser cette méthode écrire : ConnexionMySql.execReqSelection(uneRequete) où uneRequête est de type String
	 */
	public static ResultSet execReqSelection(String laRequete){ 
		connecterBd();
		ResultSet resultatReq = null;
		try {
				Statement requete = cnx.createStatement(); 
				resultatReq =requete.executeQuery(laRequete); 
		} 
		catch(Exception e) {  System.out.println("Erreur requete : "+laRequete);  }
		return resultatReq;	
	}
	
	/**
	 * @param laRequete requête SQL de type INSERT, UPDATE ou DELETE
	 * @return 1 si la MAJ s'est bien déroulée, 0 sinon
	 * pour utiliser cette méthode écrire : ConnexionMySql.execReqMaj(uneRequete) où uneRequête est de type String
	 */
	public static int execReqMaj(String laRequete){
		connecterBd();
		int nbMaj =0;
		try {
		Statement s = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        nbMaj = s.executeUpdate(laRequete);
        s.close();}
		catch (Exception er) {
			System.out.println("echec requête : "+laRequete); }
		return nbMaj;       
	}
	
	/**
	 * attention : tant que la connexion n'est pas fermée, 
	 * les MAJ ne sont pas effectives, on reste en mode déconnecté
	 * pour utiliser cette méthode écrire : ConnexionMySql.fermerConnexionBd()
	 */
	public static void fermerConnexionBd(){
		try{cnx.close();}
		catch(Exception e) {  System.out.println("Erreur sur fermeture connexion");  } 
	}

}
