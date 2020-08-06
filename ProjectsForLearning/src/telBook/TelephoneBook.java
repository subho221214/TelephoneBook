package telBook;

import java.util.Scanner;

public class TelephoneBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char choiceyn = 'y';
		int optionChoice = 0;
		OperationOnTelBook operationObj = new OperationOnTelBook();
		Scanner s = new Scanner(System.in);
		
		do {
			//User option on run
			System.out.println("==============================================================");
			System.out.println("                    Telephone Book                            ");
			System.out.println("==============================================================");
			System.out.println("Choose the opertaion you want to perform on the Telephone Book");
			System.out.println("Press 1 : Enter Name and Phone Number.");
			System.out.println("Press 2 : Search Phone Number");
			System.out.println("Enter your Choice: ");
			optionChoice = s.nextInt();
			
			//switch case for defining the operations
			switch(optionChoice) {
			case 1:
				System.out.println("========You are performing Insert operation in the Telethone Book========");
				operationObj.storeNameAndNumber();
				break;
			case 2:
				System.out.println("========You are performing Search operation in the Telethone Book========");
				operationObj.searchDirectoryAndDisplay();
				break;
			default:System.out.println();
			}
			
			//option to user for continuing or discontinuing the operation
			System.out.println("Would you want to perform any other Operation? y//n");
			choiceyn = s.next().charAt(0);
			
		}while(choiceyn == 'y');
		
		System.out.println("Ended the operation !!!!! Rerun the code to perform any operations on Tel Book Map");
	}

}
