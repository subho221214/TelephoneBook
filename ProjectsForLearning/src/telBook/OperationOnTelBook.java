package telBook;

import java.util.HashMap;
import java.util.Scanner;

public class OperationOnTelBook {
	
	HashMap<String,Long> telMap = new HashMap<String,Long>();
	
	//checking if a key exist in a map
	boolean checkNameExistenceInMap(String keyToBeChecked) {
		return telMap.containsKey(keyToBeChecked);
	}
	
	//validating the number of digits of mobile number
	boolean checkMobileNumber(long mobNumber) {
		boolean checkFlag = true;
		int length = (int)(Math.log10(mobNumber)+1);
		if(length == 10) {
			checkFlag = true;
		}else {
			checkFlag = false;
		}
		return checkFlag;
	}
	
	//store the person name and mobile number
	public void storeNameAndNumber() {
		String input_name = null;
		long input_number = 0;
		Scanner storeInputObj = new Scanner(System.in);
		boolean nameFlag = false;
		boolean telTotalDigitCountFlag = true;
		
		//the name is checked whether whatever input is given by the user exist in map and after validating the name the data is pushed to the Map
		do {
			input_name = null;
			if(nameFlag == true) {
				System.out.println("!!!Person already exist in the Map!!! '\n' Enter the name again with some additional characters or special character: ");
				input_name = storeInputObj.nextLine();
				nameFlag = this.checkNameExistenceInMap(input_name);
			}else {
				System.out.println("Enter the name of the Person Name: ");
				input_name = storeInputObj.nextLine();
				nameFlag = this.checkNameExistenceInMap(input_name);
			}
		}while(nameFlag == true);
		
		//The mobile number is checked if the input contain 10 digits for mobile
		do {
			input_number = 0;
			if(telTotalDigitCountFlag == false) {
				System.out.println("Mobile number invalid!!! Please enter the 10 digit obile number without extension");
				input_number = storeInputObj.nextLong();
				telTotalDigitCountFlag = this.checkMobileNumber(input_number);
			}else {
				System.out.println("Enter the 10 Digit mobile number without extension: ");
				input_number = storeInputObj.nextLong();
				telTotalDigitCountFlag = this.checkMobileNumber(input_number);
			}
			
		}while(telTotalDigitCountFlag == false);
		
		//storing the values
		try {
			telMap.put(input_name, input_number);
			System.out.println("Data uploaded successfully.");
		}catch(Exception e) {
			System.out.println("Some error occured!!! Data upload Failed.");
		}
	}
	
	//function to display number based on name input
	public void searchDirectoryAndDisplay() {
		String input_name = null;
		Scanner storeInputObj = new Scanner(System.in);
		System.out.println("Enter thr name of the person whose contact you want: ");
		input_name = storeInputObj.nextLine();
		if(this.checkNameExistenceInMap(input_name) == true) {
			System.out.println("===============User Found===============");
			System.out.println("Name: "+input_name);
			System.out.println("Phone umber: "+telMap.get(input_name));
		}else {
			System.out.println("!!!User not Found!!!");
		}
	}

}
