package factory;

import domain.Covid19Pacient;
import domain.Medicament;
import domain.SymptomFactory;

public class Main {

	public static void main(String[] args) {
		Covid19Pacient p1=new Covid19Pacient("aitor", 35, new SymptomFactory());
		PacientSymptomGUI pgui = new PacientSymptomGUI(p1);
		Medicament m=new Medicament("Ibuprofeno", new SymptomFactory());
		MedicalGUI mgui = new MedicalGUI(m);

	}

}
