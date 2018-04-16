package br.com.novaroma.Entity;

public class CardEntity {

	public static double credito;
	private static final double TARIFA = 3.20;
	
	public static boolean doCardDebit() {
		boolean isCardCredit = checkCardCredit();
		if(isCardCredit) {
			CardEntity.debita();
		}
		return isCardCredit;
	}
	
	private static boolean checkCardCredit() {
		return credito >= TARIFA;
	}
	
	private static void debita() {
		credito -= TARIFA;
	}

	
}
