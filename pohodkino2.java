 public class pohodkino{
	public static void main(String[] args){
		int vaniaMaxPrice = 500;
        int andreyMaxPrice = 400;
        int katyaMinPrice = 300;
        double sale = 0.85;
        int step3D = 35;
        int step2D = 27;
        boolean andreyStudent = false;
		boolean vaniaStudent = true;
        boolean katyaStudent = true;
        boolean vikaStudent = true;
		String movieType = "";
        int baseTicketPrice;
        int vaniaFinalPrice;
        int andreyFinalPrice;
        int katyaFinalPrice;
        int vikaFinalPrice;
		baseTicketPrice = 0;
        vaniaFinalPrice = 0;
        andreyFinalPrice = 0;
        katyaFinalPrice = 0;
        vikaFinalPrice = 0;
        boolean solutionFound = false;
		while (solutionFound == false) {
			for (int price3D = step3D; price3D <= vaniaMaxPrice; price3D += step3D) {
				boolean vaniaCondition = price3D <= vaniaMaxPrice;
				boolean katyaCondition = price3D > katyaMinPrice;
				boolean andreyCondition = price3D <= andreyMaxPrice;
            
				if (vaniaCondition && katyaCondition && andreyCondition) {         
					int vaniaPrice = (int) Math.round(price3D * sale);
					int katyaPrice = (int) Math.round(price3D * sale);
					int vikaPrice = (int) Math.round(price3D * sale);
					int andreyPrice = price3D; 
					System.out.println("3D фильм за " + price3D);
					System.out.println("Ваня=" + vaniaPrice + ", Катя=" + katyaPrice + ", Вика=" + vikaPrice);
					System.out.println("Андрей= " + andreyPrice);
                
					movieType = "3D";
					baseTicketPrice = price3D;
					vaniaFinalPrice = vaniaPrice;
					andreyFinalPrice = andreyPrice;
					katyaFinalPrice = katyaPrice;
					vikaFinalPrice = vikaPrice;
					solutionFound = true;
					break;
				}
			}
			
			if (solutionFound == true){
				break;
			}
			for (int price2D = step2D; price2D <= vaniaMaxPrice; price2D += step2D) {
				boolean vaniaCondition = price2D <= vaniaMaxPrice;
				boolean katyaCondition = price2D > katyaMinPrice;
				boolean andreyCondition = price2D <= andreyMaxPrice;
		
				if (vaniaCondition && katyaCondition && andreyCondition) {         
					int vaniaPrice = (int) Math.round(price2D * sale);
					int katyaPrice = (int) Math.round(price2D * sale);
					int vikaPrice = (int) Math.round(price2D * sale);
					int andreyPrice = price2D; 
					System.out.println("2D фильм за " + price2D);
					System.out.println("Ваня=" + vaniaPrice + ", Катя=" + katyaPrice + ", Вика=" + vikaPrice);
					System.out.println("Андрей= " + andreyPrice);
                
					movieType = "2D";
					baseTicketPrice = price2D;
					vaniaFinalPrice = vaniaPrice;
					andreyFinalPrice = andreyPrice;
					katyaFinalPrice = katyaPrice;
					vikaFinalPrice = vikaPrice;
					solutionFound = true;
					break;
				}
			}
		}
		
			
		
	}
}