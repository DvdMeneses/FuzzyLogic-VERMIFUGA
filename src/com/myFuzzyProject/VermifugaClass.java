package com.myFuzzyProject;

import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public class VermifugaClass {
	public static void main(String[] args) throws Exception {
		Scanner ler = new Scanner(System.in);
		float famacha, opg ;
		double situacaoAnimal;
		String motivo;
		
		
		
		String filename = "vermifuga.fcl"; //arquivo FCL
	
		FIS fis = FIS.load(filename, true); //carregamento
		
		if (fis == null) { //erro durante o carregamento do arquivo
			System.err.println("Can't load file: '" + filename + "'");
			System.exit(1);
		}

		// Get default function block
		FunctionBlock fb = fis.getFunctionBlock(null);

	
		
		// Defini��es de vari�veis de entrada FIS
		System.out.println("Como estava a cor  |1 -bege Claro | 2 - bege | 3 - laranja | 4 - laranja Escuro | 5 - vermelho|");
		famacha = ler.nextFloat();
		System.out.println("Qnt de Ovos por grama de Fezes (0 a 600 )? - Caso seja maior que 600 , informe 600. ");
		opg = ler.nextFloat();
		fb.setVariable("famacha", famacha);  //8,5
		fb.setVariable("opg", opg);  //7,5  tip=19.99999

		// Execuxao do sistema
		fb.evaluate();

		// Show output variable's chart
		fb.getVariable("situacaoAnimal").defuzzify();
		situacaoAnimal = fb.getVariable("situacaoAnimal").getValue();
		// Print ruleSet
		
		System.out.println("grau De Risco: " + fb.getVariable("situacaoAnimal").getValue());
		
		
		// LOGICA SIMPLES PARA COMUNICAÇÃO COM O USUARIO 
				 if(situacaoAnimal <= 14.9) {
					 if(famacha >= 2 && opg >= 450 ) {// cor dos olhos tranquilas e alto nivel parasitario
						 motivo = "A coloração dos olhos esta boa , mas o nivel parasitario por grama de fezes está alta , faca vermifucação urgente tambem é necessario reforco em sua alimentacao ";
						 System.out.println("O ANIMAL ESTA MUITO MAL\n-> "+motivo);
					 }else if(famacha <=  2 && opg >= 450) {// coloracao dos olhos ruins e nivel alto de parasitas
						 motivo = "A coloração dos olhos esta ruim e  o nivel parasitario por grama de fezes está alta , faca vermifucação urgente tambem é necessario reforco em sua alimentacao";
						 System.out.println("O ANIMAL ESTA MUITO MAL\n-> "+motivo);
					 }else if(famacha <= 2 && opg <= 399) {//coloracao ruim e baixo nivel parasitario
						 motivo = "A coloração dos olhos esta ruim , mas  nivel parasitario por grama de fezes está baixa, pode indicar anemia";
						 System.out.println("O ANIMAL ESTA MUITO MAL\n-> "+motivo);
					 }else if(famacha <= 2 && opg > 399 && opg < 450) {//coloracao ruim e MEDIO nivel parasitario
						 motivo = "A coloração dos olhos esta ruim e o nivel parasitario por grama de fezes está MEDIO,faca vermifucação urgente tambem é necessario reforco em sua alimentacao";
						 System.out.println("O ANIMAL ESTA ESTA MUIT MAL \n-> "+motivo);
					 }
				 }else if(situacaoAnimal > 14.9 && situacaoAnimal <= 24.9) {
					 
					 if(famacha >= 2 && opg >= 450 ) {// cor dos olhos tranquilas e alto nivel parasitario
						 motivo = "A coloração dos olhos esta boa , mas o nivel parasitario por grama de fezes está alta";
						 System.out.println("O ANIMAL ESTA MAL\n-> "+motivo);
					 }else if(famacha <=  2 && opg >= 450) {// coloracao dos olhos ruins e nivel alto de parasitas
						 motivo = "A coloração dos olhos esta ruim e o nivel parasitario por grama de fezes está alta";
						 System.out.println("O ANIMAL ESTA MAL\n-> "+motivo);
					 }else if(famacha <= 2 && opg <= 399) {//coloracao ruim e baixo nivel parasitario
						 motivo = "A coloração dos olhos esta ruim , mas  nivel parasitario por grama de fezes está baixa, pode indicar anemia";
						 System.out.println("O ANIMAL ESTA MAL\n-> "+motivo);
					 }else if(famacha <= 2 && opg > 399 && opg < 450) {//coloracao ruim e MEDIO nivel parasitario
						 motivo = "A coloração dos olhos esta ruim e o   nivel parasitario por grama de fezes está MEDIO, pode indicar anemia e fique atento a outros detalhes pos nivel medio pode ser indicativo de piora.";
						 System.out.println("O ANIMAL ESTA MAL\n-> "+motivo);
					 }
				
				 }else if(situacaoAnimal > 24.9 && situacaoAnimal <= 34.9) {
					 
					 if(famacha >= 2 && opg >= 450 ) {// cor dos olhos tranquilas e alto nivel parasitario
						 motivo = "A coloração dos olhos esta boa , mas o nivel parasitario por grama de fezes está alta";
						 System.out.println("O ANIMAL ESTA INDETERMINADO\n-> "+motivo);
					 }else if(famacha <=  2 && opg >= 450) {// coloracao dos olhos ruins e nivel alto de parasitas
						 motivo = "A coloração dos olhos esta ruim e o nivel parasitario por grama de fezes está alta";
						 System.out.println("O ANIMAL ESTA INDETERMINADO\n-> "+motivo);
					 }else if(famacha <= 2 && opg <= 399) {//coloracao ruim e baixo nivel parasitario
						 motivo = "A coloração dos olhos esta ruim , mas  nivel parasitario por grama de fezes está baixa, pode indicar anemia";
						 System.out.println("O ANIMAL ESTA INDETERMINADO\n-> "+motivo);
					 }else if(famacha >= 3 && opg > 399 && opg < 450) {//coloracao media boa  e MEDIO nivel parasitario
						 motivo = "A coloração dos olhos esta em situação mediana  e o   nivel parasitario por grama de fezes está MEDIO,  fique atento a outros detalhes pos nivel medio pode ser indicativo de piora.";
						 System.out.println("O ANIMAL ESTA indeterminado \n-> "+motivo);
					 }
				
					
				 }else if(situacaoAnimal >= 35 && situacaoAnimal <= 50) {
					 
					 if(famacha >= 2 && opg >= 450 ) {// cor dos olhos tranquilas e alto nivel parasitario
						 motivo = "A coloração dos olhos esta boa , mas o nivel parasitario por grama de fezes está alta";
						 System.out.println("O ANIMAL ESTA SAUDAVEL\n-> "+motivo);
					 }else if(famacha <  2 && opg >= 450) {// coloracao dos olhos ruins e nivel alto de parasitas
						 motivo = "A coloração dos olhos esta ruim e o nivel parasitario por grama de fezes está alta";
						 System.out.println("O ANIMAL ESTA SAUDAVEL\n-> "+motivo);
					 }
					 else if(famacha < 2 && opg <= 399) {//coloracao ruim e baixo nivel parasitario
						 motivo = "A coloração dos olhos esta ruim , mas  nivel parasitario por grama de fezes está baixa, pode indicar anemia";
						 System.out.println("O ANIMAL ESTA SAUDAVEL\n-> "+motivo);
					 }
					 else if(famacha >= 2 && opg == 400) {//coloracao boa e  nivel parasitario medio
						 motivo = "A coloração dos olhos esta boa e o  nivel parasitario por grama de fezes está Medio , caso o animal apresente mudanca de comportamento faca mais analises !";
						 System.out.println("O ANIMAL ESTA SAUDAVEL\n-> "+motivo);
					 }
					 
				 }
		
		
	}

}