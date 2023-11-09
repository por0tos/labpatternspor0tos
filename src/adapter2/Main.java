package adapter2;

import java.util.List;

import domain.Covid19Pacient;
import domain.SymptomFactory;

public class Main {

	public static void main(String[] args) {
		
		SymptomFactory sf = new SymptomFactory();
		Covid19Pacient p1=new Covid19Pacient("Aitor", 35, sf);
		Covid19Pacient p2=new Covid19Pacient("Markel", 27, sf);
		
		p1.addSymptomByName("disnea", 2);
		p1.addSymptomByName("cefalea", 1);
		p1.addSymptomByName("astenia", 3);
		
		p2.addSymptomByName("tos seca", 3);
		p2.addSymptomByName("dolor de garganta", 3);
		p2.addSymptomByName("fiebre", 2);
		
		List<Covid19Pacient> pacients = List.of(p1, p2);
		
		ShowPacientTableGUI gui=new ShowPacientTableGUI(pacients);
		gui.setPreferredSize(
			      new java.awt.Dimension(300, 200));
		gui.setVisible(true);


	}

}
