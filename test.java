 import java.util.Scanner;
 public class pohodkino{
	public static void main(String[] args){
		int vaniaMaxPrice = 500;
        int andreyMinPrice = 200;
        int katyaMinPrice = 300;
		int andreyMaxPrice = 400;
		boolean vikaAddMoney = false;
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
			for (int price2D = step2D; price2D <= vaniaMaxPrice; price2D += step2D) {
				boolean vaniaCondition = price2D <= vaniaMaxPrice;
				boolean katyaCondition = price2D > katyaMinPrice;
				boolean andreyCondition = price2D <= andreyMinPrice;
		
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
			
			if (solutionFound == true && vikaAddMoney == false){
				break;
			}
			else{
			
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
			}
		}
		int startSeat = 0;
		for (int i = 1; i <= 27; i++) {
			boolean found = true;
			for (int j = 0; j < 4; j++) {
				int currentSeat = i + j;
				if (currentSeat > 30 || 
					(currentSeat >= 1 && currentSeat <= 7) ||
					(currentSeat >= 11 && currentSeat <= 13) ||
					(currentSeat >= 15 && currentSeat <= 17) ||
					(currentSeat >= 22 && currentSeat <= 24) ||
					(currentSeat >= 26 && currentSeat <= 30)) {
					found = false;
					break;
				}
			}
			if (found) {
				startSeat = i;
				break;
			}
		}
		System.out.println ((startSeat + 3) + " " + (startSeat + 2) + " " + 
		(startSeat + 1) + " " + startSeat);
		
		int fullSum = 0;
		double richers = 1.05;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Какова изначальная цена билета?");
		String baseFilmPrice = scanner.nextLine();
		int intBaseFilmPrice = Integer.parseInt(baseFilmPrice);
		System.out.println("Какова цена со скидкой?");
		String saleFilmPrice = scanner.nextLine();
		int intSaleFilmPrice = Integer.parseInt(saleFilmPrice);
		System.out.println("Мы знаем какие у нас места, рассмотрим случай, в котором Андрей сидит на не дорогом месте");
		if (startSeat >= 10 && startSeat <=20){
			fullSum = fullSum + (int) (intSaleFilmPrice * richers);		
		}
		else{
			fullSum = fullSum + intBaseFilmPrice;
			}
		if (startSeat + 1 >= 10 && startSeat + 1 <=20){
			fullSum = fullSum + (int) (intSaleFilmPrice * richers);		
		}
		else{
			fullSum = fullSum + intBaseFilmPrice;
			}
		if (startSeat + 2 >= 10 && startSeat + 2 <=20){
			fullSum = fullSum + (int) (intSaleFilmPrice * richers);		
		}
		else{
			fullSum = fullSum + intBaseFilmPrice;
			}
		if (startSeat + 3 >= 10 && startSeat + 3 <=20){
			fullSum = fullSum + (int) (intSaleFilmPrice * richers);		
		}
		else{
			fullSum = fullSum + intBaseFilmPrice;
			}
		System.out.println(fullSum);
	}
 }