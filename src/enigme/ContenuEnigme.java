package enigme;

import java.awt.GraphicsConfiguration;

public class ContenuEnigme {

	private int bonneReponse;
	private boolean ajouterPoint;
	private String title;
	private String question;
	private String cheminSonQuestion;
	private int nbReponses;
	private String[] reponses;
	private int points;

	public ContenuEnigme(String question, String cheminSonQuestion,
			int nbReponses, String[] reponses, int bonneReponse) {
		this.title = "Question numéro ";
		this.question = question;
		this.cheminSonQuestion = cheminSonQuestion;
		this.nbReponses = nbReponses;
		this.reponses = reponses;
		this.bonneReponse = bonneReponse;
	}

	public int getBonneReponse() {
		return bonneReponse;
	}

	public boolean getAjouterPoint() {
		return ajouterPoint;
	}

	public String getTitle() {
		return title;
	}

	public String getQuestion() {
		return question;
	}

	public String getCheminSonQuestion() {
		return cheminSonQuestion;
	}

	public int getNbReponses() {
		return nbReponses;
	}

	public String[] getReponses() {
		return reponses;
	}

	public int getPoints() {
		return points;
	}

}
