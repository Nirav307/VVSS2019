package dsir2090MV.main;

import dsir2090MV.controller.NoteController;
import dsir2090MV.model.Corigent;
import dsir2090MV.model.Medie;
import dsir2090MV.model.Nota;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//functionalitati
//F01.	 adaugarea unei note la o anumita materie (nr. matricol, materie, nota acordata);
//F02.	 calcularea mediilor semestriale pentru fiecare elev (nume, nr. matricol),
//F03.	 afisarea elevilor coringenti, ordonati descrescator dupa numarul de materii la care nu au promovat ?i alfabetic dupa nume.

public class StartApp {

	/**
	 * @param args
	 * @throws ClasaException
	 */
	public static void main(String[] args) throws ClasaException {
		// TODO Auto-generated method stub
		NoteController ctrl = new NoteController();
		List<Medie> medii = new LinkedList<Medie>();
		List<Corigent> corigenti = new ArrayList<Corigent>();

		ctrl.readElevi("D:\\faculta\\laburie mele\\piir2171VVSS-master\\src\\data\\elevi.txt");
		ctrl.readNote("D:\\faculta\\laburie mele\\piir2171VVSS-master\\src\\data\\note.txt");

		ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
		boolean gasit = false;
		while(!gasit) {
			System.out.println("1. Adaugare Nota");
			System.out.println("2. Calculeaza medii");
			System.out.println("3. Elevi corigenti");
			System.out.println("4. Iesire");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
		    try {
				int option = Integer.parseInt(br.readLine());
				switch(option) {
					case 1:
						addNota(ctrl);
						break;
					case 2: medii = ctrl.calculeazaMedii();
							for(Medie medie:medii)
								System.out.println(medie);
							break;
					case 3: corigenti = ctrl.getCorigenti();
							for(Corigent corigent:corigenti)
								System.out.println(corigent);
							break;
					case 4: gasit = true;
							break;
				default: System.out.println("Introduceti o optiune valida!");
				}

	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	}

static void addNota(NoteController ctrl) throws ClasaException {
		Scanner scanner = new Scanner(System.in);

		int nr;
		String materie;
		double nota;

		System.out.print("Nr matricol: ");
		nr = scanner.nextInt();

		System.out.print("Materie: ");
		materie = scanner.nextLine();

		System.out.print("Nota: ");
		nota = scanner.nextDouble();

		ctrl.addNota(new Nota(nr, materie, nota));
	}
}