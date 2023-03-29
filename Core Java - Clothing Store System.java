import java.io.*; 		//Importing java.io package
import java.util.*;		//Importing java.util package

//Class to handle the signing up process of the program
class SignUp 
{
	static int counter = 1;		//counter for user ID (static)

	public int userID;			//Variable to store user ID of the user
	public int signedIn; 		//Variable to make sure user has signed up
	
	public long phoneNumber;	//Variable to store phone number of user

	public String username;		//Variable to store the username of the user
	public String password;		//Variable to store password created by user
	public String emailID;		//Variable to store email ID of the user

	//function for signing up
	void signUpInterface()//no arguments
	{
		String confirmPass;		//Variable to store/check password confirmation

		signedIn = 1;			//turning value to 1 to tell program user has signed in

		//try block for exception handling
		try
		{
			userID = counter++; //Initializing user ID

			BufferedReader sc = new BufferedReader(new InputStreamReader(System.in)); 	//creating object of buffered reader to read user inputs

			System.out.println("Please Enter Valid Information for account creation:");

			//initializing username for user
			System.out.println("Enter Username: ");
			username = sc.readLine();

			//Initializing user Email ID
			while(true)
			{
				boolean at, dot, correct;
				at = false;			//variable to ensure use of @ symbol
				dot = false;		//Variable to ensure use of . symbol
				correct = false;	//Variable to ensure both above are correct

				System.out.println("Enter Email ID:");
				emailID = sc.readLine();
				int len = emailID.length();

				//Code to check whether user input is in correct format for email ID
				for(int i = 0; i < len; i++)
				{
					if(emailID.charAt(i) == '@' && i > 0)
					{	at = true;	}
					else if(at == true && emailID.charAt(i) == '.')
					{	dot = true;	 }

					if(dot == true && at == true)
					{	
						correct = true; 
						break;	
					}
				}

				//if user input is correct, if will go to next section, if incorrect it will repeat loop
				if(correct == true){	break;	 }
				else{	System.out.println("Invalid Email ID provided, please re-enter valid Email ID");	}
			}

			//initializing user's phone number
			while(true)
			{	
				System.out.println("Enter Phone Number: ");
				phoneNumber = Long.parseLong(sc.readLine());

				//if user input is more than 9 digits, it will go to next section, if incorrect, it will repeat loop
				if(phoneNumber > 999999999)
			 	{ 	break;	}
			 	else
			  	{	System.out.println("Invalid Phone Number Entered Please Enter Valid Phone Number:");	}
			}

			//code to initialize password
			while(true)
			{
				int i;
				boolean dig, sym, correct;
				dig = false;		//Variable to ensure a number is used
				sym = false;		//Variable to ensure a symbol is used
				correct = false;	//Variable to ensure both above are correct

				System.out.println("Enter Password: ");
				System.out.println("Requirements for password:\n1. Must have 8 or more characters\n2. Must have one symbol and digit");
				password = sc.readLine();
				int len = password.length();

				//Code to check length of password (whether is adequate or not)
				if(len < 8)
				{	
					System.out.println("Password is too short, please re-enter valid password");
					continue;
				}

				//Code to check validity of password
				for(i = 0; i < len; i++)
				{
					char ch = password.charAt(i);
					if(Character.isDigit(ch) == true)
					{	dig = true;	  }
					else if(Character.isLetter(ch) == true);
					else {	  sym = true;	}

				 	if(dig == true && sym == true)
				 	{	
				 		correct = true;
				 		break; 	 
				 	}
				}

				//if password is valid, it will go to next section, if invalid it will repeat loop
				if(correct == false){	System.out.println("Invalid password entered");	 }
				else {	break;	}
			}

			//Initializing confirmPass
			while(true)
			{
				System.out.println("Confirm your password: ");
				confirmPass = sc.readLine();

				//Code to check whether confirmPass matches password, if true it will go to next section, if not, it will repeat loop
				if(confirmPass.equals(password))
				{	break;	 }
				System.out.println("Password does not match, please re-enter password");
			}
		}
		catch (FileNotFoundException e){}		//catch statements to catch exceptions
		catch (IOException e){}
	}
}

//Class to handle the Cart processing of the program
class Cart
{
	//Using vectors to store list of information given by user
	public Vector<Integer> cost = new Vector<Integer>(2);		//List to store cost of each item
	public Vector<Integer> quantity = new Vector<Integer>(2);	//List to store quantity of each item

	public Vector<String> item = new Vector<String>(2);			//List to store names of each item
	
	//Function to display all information within the cart
	public void displayCart()
	{
		int i;

		//if statement to check whether cart is empty or not, if not empty it will run the code inside
		if(cost.size() != 0)
		{
			System.out.println("Sr No\tItem name\t\tCost\tQuantity\tTotal Cost");
			for(i = 0; i < cost.size(); i++)
			{
				System.out.print((i+1) + "\t");
				System.out.print(item.get(i) + "\t\t");
				System.out.print(cost.get(i) + "\t");
				System.out.print(quantity.get(i) + "\t\t");
				System.out.print((quantity.get(i)*cost.get(i)));
				System.out.println();
			}
		}
		else System.out.println("The cart is empty, please fill your cart with items from our store.");
	}
}

//Interface for store categories
interface Store
{
	void sectionSelect();
	void section1();
	void section2();
	void section3();
	void section4();
	void section5();
	void addToCart(String str, int c, int q);
}

//Class to handle category "MensClothing" of the clothing store
class MensClothing implements Store
{
	//function to select what section of store user wants to go to
	public void sectionSelect()
	{
		int choice;		//variable to store user input for choice
		while(true)
		{
			System.out.println("Please choose from the following options:");
			System.out.println("1. Shirts");
			System.out.println("2. Pants");
			System.out.println("3. Casual Wear");
			System.out.println("4. Formal Wear");
			System.out.println("5. Ethnic Wear");
			System.out.println("6. Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);

				switch(choice)
				{
					case 1: section1(); break;
					case 2: section2(); break;
					case 3: section3(); break;
					case 4: section4(); break;
					case 5: section5(); break;
					case 6: return;
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void section1()// shirts
	{
		int choice;
		int quantity;

		while(true)
		{
			System.out.println("Here is the range of shirts you can buy from our store");
			System.out.println("1.Black shirt 		(250 rupees)");
			System.out.println("2.White shirt 		(275 rupees)");
			System.out.println("3.Green shirt  		(300 rupees)");
			System.out.println("4.Yellow shirt 		(325 rupees)");
			System.out.println("5.Purple shirt 		(350 rupees)");
			System.out.println("6.Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);
				
				if (choice == 6) {  return;	 }
				System.out.println("Please enter the quantity of product you want to buy");
				quantity = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+quantity);

				switch(choice)
				{
					case 1: addToCart("Black shirt", 250, quantity); break;
					case 2: addToCart("White shirt", 275, quantity); break;
					case 3: addToCart("Green shirt", 300, quantity); break;
					case 4: addToCart("Yellow shirt", 325, quantity); break;
					case 5: addToCart("Purple shirt", 350, quantity); break;
					default: System.out.println("Wrong Input detected, please re-enter your value");
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void section2()// pants
	{
		int choice;
		int quantity;

		while(true)
		{
			System.out.println("Here is the range of pantss you can buy from our store");
			System.out.println("1.Black pants 		(250 rupees)");
			System.out.println("2.White pants 		(275 rupees)");
			System.out.println("3.Green pants  		(300 rupees)");
			System.out.println("4.Yellow pants 		(325 rupees)");
			System.out.println("5.Purple pants 		(350 rupees)");
			System.out.println("6.Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);
				
				if (choice == 6) {  return;	 }
				System.out.println("Please enter the quantity of product you want to buy");
				quantity = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+quantity);
				switch(choice)
				{
					case 1: addToCart("Black pants", 250, quantity); break;
					case 2: addToCart("White pants", 275, quantity); break;
					case 3: addToCart("Green pants", 300, quantity); break;
					case 4: addToCart("Yellow pants", 325, quantity); break;
					case 5: addToCart("Purple pants", 350, quantity); break;
					default: System.out.println("Wrong Input detected, please re-enter your value");
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void section3()// casual wear
	{
		int choice;
		int quantity;

		while(true)
		{
			System.out.println("Here is the range of casuals you can buy from our store");
			System.out.println("1.Black casual 			(250 rupees)");
			System.out.println("2.White casual 			(275 rupees)");
			System.out.println("3.Green casual  		(300 rupees)");
			System.out.println("4.Yellow casual 		(325 rupees)");
			System.out.println("5.Purple casual 		(350 rupees)");
			System.out.println("6.Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);
				
				if (choice == 6) {  return;	 }
				System.out.println("Please enter the quantity of product you want to buy");
				quantity = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+quantity);

				switch(choice)
				{
					case 1: addToCart("Black casual", 250, quantity); break;
					case 2: addToCart("White casual", 275, quantity); break;
					case 3: addToCart("Green casual", 300, quantity); break;
					case 4: addToCart("Yellow casual", 325, quantity); break;
					case 5: addToCart("Purple casual", 350, quantity); break;
					default: System.out.println("Wrong Input detected, please re-enter your value");
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void section4()// formal wear
	{
		int choice;
		int quantity;

		while(true)
		{
			System.out.println("Here is the range of formals you can buy from our store");
			System.out.println("1.Black formal 			(250 rupees)");
			System.out.println("2.White formal 			(275 rupees)");
			System.out.println("3.Green formal  		(300 rupees)");
			System.out.println("4.Yellow formal 		(325 rupees)");
			System.out.println("5.Purple formal 		(350 rupees)");
			System.out.println("6.Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);
				
				if (choice == 6) {  return;	 }
				System.out.println("Please enter the quantity of product you want to buy");
				quantity = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+quantity);

				switch(choice)
				{
					case 1: addToCart("Black formal", 250, quantity); break;
					case 2: addToCart("White formal", 275, quantity); break;
					case 3: addToCart("Green formal", 300, quantity); break;
					case 4: addToCart("Yellow formal", 325, quantity); break;
					case 5: addToCart("Purple formal", 350, quantity); break;
					default: System.out.println("Wrong Input detected, please re-enter your value");
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void section5()// ethnic wear
	{
		int choice;
		int quantity;

		while(true)
		{
			System.out.println("Here is the range of Ethnic Wear you can buy from our store");
			System.out.println("1.Black Ethnic Wear 		(250 rupees)");
			System.out.println("2.White Ethnic Wear 		(275 rupees)");
			System.out.println("3.Green Ethnic Wear  		(300 rupees)");
			System.out.println("4.Yellow Ethnic Wear 		(325 rupees)");
			System.out.println("5.Purple Ethnic Wear 		(350 rupees)");
			System.out.println("6.Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);
				
				if (choice == 6) {  return;	 }
				System.out.println("Please enter the quantity of product you want to buy");
				quantity = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+quantity);

				switch(choice)
				{
					case 1: addToCart("Black Ethnic Wear", 250, quantity); break;
					case 2: addToCart("White Ethnic Wear", 275, quantity); break;
					case 3: addToCart("Green Ethnic Wear", 300, quantity); break;
					case 4: addToCart("Yellow Ethnic Wear", 325, quantity); break;
					case 5: addToCart("Purple Ethnic Wear", 350, quantity); break;
					default: System.out.println("Wrong Input detected, please re-enter your value");
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void addToCart(String str, int c, int q)
	{
		MainInterface.CT.item.add(str);
		MainInterface.CT.cost.add(c);
		MainInterface.CT.quantity.add(q);
	}
}

//Class to handle category "WomensClothing" of the clothing store
class WomensClothing implements Store
{
	public void sectionSelect()
	{
		int choice;
		while(true)
		{
			System.out.println("Please choose from the following options:");
			System.out.println("1. Dresses");
			System.out.println("2. Pants");
			System.out.println("3. Hoodies");
			System.out.println("4. Skirts");
			System.out.println("5. Ethnic Wear");
			System.out.println("6. Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);

				switch(choice)
				{
					case 1: section1(); break;
					case 2: section2(); break;
					case 3: section3(); break;
					case 4: section4(); break;
					case 5: section5(); break;
					case 6: return;
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void section1()// dresses
	{
		int choice;
		int quantity;

		while(true)
		{
			System.out.println("Here is the range of dresss you can buy from our store");
			System.out.println("1.Black dress 		(250 rupees)");
			System.out.println("2.White dress 		(275 rupees)");
			System.out.println("3.Green dress  		(300 rupees)");
			System.out.println("4.Yellow dress 		(325 rupees)");
			System.out.println("5.Purple dress 		(350 rupees)");
			System.out.println("6.Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);
				
				if (choice == 6) {  return;	 }
				System.out.println("Please enter the quantity of product you want to buy");
				quantity = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+quantity);

				switch(choice)
				{
					case 1: addToCart("Black dress", 250, quantity); break;
					case 2: addToCart("White dress", 275, quantity); break;
					case 3: addToCart("Green dress", 300, quantity); break;
					case 4: addToCart("Yellow dress", 325, quantity); break;
					case 5: addToCart("Purple dress", 350, quantity); break;
					default: System.out.println("Wrong Input detected, please re-enter your value");
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void section2()// pants
	{
		int choice;
		int quantity;

		while(true)
		{
			System.out.println("Here is the range of pants you can buy from our store");
			System.out.println("1.Black pants 		(250 rupees)");
			System.out.println("2.White pants 		(275 rupees)");
			System.out.println("3.Green pants  		(300 rupees)");
			System.out.println("4.Yellow pants 		(325 rupees)");
			System.out.println("5.Purple pants 		(350 rupees)");
			System.out.println("6.Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);
				
				if (choice == 6) {  return;	 }
				System.out.println("Please enter the quantity of product you want to buy");
				quantity = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+quantity);
				switch(choice)
				{
					case 1: addToCart("Black pants", 250, quantity); break;
					case 2: addToCart("White pants", 275, quantity); break;
					case 3: addToCart("Green pants", 300, quantity); break;
					case 4: addToCart("Yellow pants", 325, quantity); break;
					case 5: addToCart("Purple pants", 350, quantity); break;
					default: System.out.println("Wrong Input detected, please re-enter your value");
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void section3()// hoodies
	{
		int choice;
		int quantity;

		while(true)
		{
			System.out.println("Here is the range of hoodies you can buy from our store");
			System.out.println("1.Black hoodie 			(250 rupees)");
			System.out.println("2.White hoodie 			(275 rupees)");
			System.out.println("3.Green hoodie  		(300 rupees)");
			System.out.println("4.Yellow hoodie 		(325 rupees)");
			System.out.println("5.Purple hoodie 		(350 rupees)");
			System.out.println("6.Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);
				
				if (choice == 6) {  return;	 }
				System.out.println("Please enter the quantity of product you want to buy");
				quantity = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+quantity);

				switch(choice)
				{
					case 1: addToCart("Black hoodie", 250, quantity); break;
					case 2: addToCart("White hoodie", 275, quantity); break;
					case 3: addToCart("Green hoodie", 300, quantity); break;
					case 4: addToCart("Yellow hoodie", 325, quantity); break;
					case 5: addToCart("Purple hoodie", 350, quantity); break;
					default: System.out.println("Wrong Input detected, please re-enter your value");
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void section4()// skirt
	{
		int choice;
		int quantity;

		while(true)
		{
			System.out.println("Here is the range of skirts you can buy from our store");
			System.out.println("1.Black skirt 		(250 rupees)");
			System.out.println("2.White skirt 		(275 rupees)");
			System.out.println("3.Green skirt  		(300 rupees)");
			System.out.println("4.Yellow skirt 		(325 rupees)");
			System.out.println("5.Purple skirt 		(350 rupees)");
			System.out.println("6.Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);
				
				if (choice == 6) {  return;	 }
				System.out.println("Please enter the quantity of product you want to buy");
				quantity = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+quantity);

				switch(choice)
				{
					case 1: addToCart("Black skirt", 250, quantity); break;
					case 2: addToCart("White skirt", 275, quantity); break;
					case 3: addToCart("Green skirt", 300, quantity); break;
					case 4: addToCart("Yellow skirt", 325, quantity); break;
					case 5: addToCart("Purple skirt", 350, quantity); break;
					default: System.out.println("Wrong Input detected, please re-enter your value");
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void section5()// ethnic wear
	{
		int choice;
		int quantity;

		while(true)
		{
			System.out.println("Here is the range of Ethnic Wear you can buy from our store");
			System.out.println("1.Black Ethnic Wear 		(250 rupees)");
			System.out.println("2.White Ethnic Wear 		(275 rupees)");
			System.out.println("3.Green Ethnic Wear  		(300 rupees)");
			System.out.println("4.Yellow Ethnic Wear 		(325 rupees)");
			System.out.println("5.Purple Ethnic Wear 		(350 rupees)");
			System.out.println("6.Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);
				
				if (choice == 6) {  return;	 }
				System.out.println("Please enter the quantity of product you want to buy");
				quantity = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+quantity);

				switch(choice)
				{
					case 1: addToCart("Black Ethnic Wear", 250, quantity); break;
					case 2: addToCart("White Ethnic Wear", 275, quantity); break;
					case 3: addToCart("Green Ethnic Wear", 300, quantity); break;
					case 4: addToCart("Yellow Ethnic Wear", 325, quantity); break;
					case 5: addToCart("Purple Ethnic Wear", 350, quantity); break;
					default: System.out.println("Wrong Input detected, please re-enter your value");
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void addToCart(String str, int c, int q)
	{
		MainInterface.CT.item.add(str);
		MainInterface.CT.cost.add(c);
		MainInterface.CT.quantity.add(q);
	}
}

//Class to handle category "childrensClothing" of the clothing store
class ChildrensClothing implements Store
{
	public void sectionSelect()
	{
		int choice;
		while(true)
		{
			System.out.println("Please choose from the following options:");
			System.out.println("1. Shirts");
			System.out.println("2. Pants");
			System.out.println("3. Casual Wear");
			System.out.println("4. Formal Wear");
			System.out.println("5. Ethnic Wear");
			System.out.println("6. Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);

				switch(choice)
				{
					case 1: section1(); break;
					case 2: section2(); break;
					case 3: section3(); break;
					case 4: section4(); break;
					case 5: section5(); break;
					case 6: return;
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void section1()// shirts
	{
		int choice;
		int quantity;

		while(true)
		{
			System.out.println("Here is the range of shirts you can buy from our store");
			System.out.println("1.Black shirt 		(250 rupees)");
			System.out.println("2.White shirt 		(275 rupees)");
			System.out.println("3.Green shirt  		(300 rupees)");
			System.out.println("4.Yellow shirt 		(325 rupees)");
			System.out.println("5.Purple shirt 		(350 rupees)");
			System.out.println("6.Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);
				
				if (choice == 6) {  return;	 }
				System.out.println("Please enter the quantity of product you want to buy");
				quantity = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+quantity);

				switch(choice)
				{
					case 1: addToCart("Black shirt", 250, quantity); break;
					case 2: addToCart("White shirt", 275, quantity); break;
					case 3: addToCart("Green shirt", 300, quantity); break;
					case 4: addToCart("Yellow shirt", 325, quantity); break;
					case 5: addToCart("Purple shirt", 350, quantity); break;
					default: System.out.println("Wrong Input detected, please re-enter your value");
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void section2()// pants
	{
		int choice;
		int quantity;

		while(true)
		{
			System.out.println("Here is the range of pantss you can buy from our store");
			System.out.println("1.Black pants 		(250 rupees)");
			System.out.println("2.White pants 		(275 rupees)");
			System.out.println("3.Green pants  		(300 rupees)");
			System.out.println("4.Yellow pants 		(325 rupees)");
			System.out.println("5.Purple pants 		(350 rupees)");
			System.out.println("6.Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);
				
				if (choice == 6) {  return;	 }
				System.out.println("Please enter the quantity of product you want to buy");
				quantity = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+quantity);
				switch(choice)
				{
					case 1: addToCart("Black pants", 250, quantity); break;
					case 2: addToCart("White pants", 275, quantity); break;
					case 3: addToCart("Green pants", 300, quantity); break;
					case 4: addToCart("Yellow pants", 325, quantity); break;
					case 5: addToCart("Purple pants", 350, quantity); break;
					default: System.out.println("Wrong Input detected, please re-enter your value");
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void section3()// casual wear
	{
		int choice;
		int quantity;

		while(true)
		{
			System.out.println("Here is the range of casuals you can buy from our store");
			System.out.println("1.Black casual 			(250 rupees)");
			System.out.println("2.White casual 			(275 rupees)");
			System.out.println("3.Green casual  		(300 rupees)");
			System.out.println("4.Yellow casual 		(325 rupees)");
			System.out.println("5.Purple casual 		(350 rupees)");
			System.out.println("6.Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);
				
				if (choice == 6) {  return;	 }
				System.out.println("Please enter the quantity of product you want to buy");
				quantity = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+quantity);

				switch(choice)
				{
					case 1: addToCart("Black casual", 250, quantity); break;
					case 2: addToCart("White casual", 275, quantity); break;
					case 3: addToCart("Green casual", 300, quantity); break;
					case 4: addToCart("Yellow casual", 325, quantity); break;
					case 5: addToCart("Purple casual", 350, quantity); break;
					default: System.out.println("Wrong Input detected, please re-enter your value");
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void section4()// formal wear
	{
		int choice;
		int quantity;

		while(true)
		{
			System.out.println("Here is the range of formals you can buy from our store");
			System.out.println("1.Black formal 		(250 rupees)");
			System.out.println("2.White formal 		(275 rupees)");
			System.out.println("3.Green formal  		(300 rupees)");
			System.out.println("4.Yellow formal 		(325 rupees)");
			System.out.println("5.Purple formal 		(350 rupees)");
			System.out.println("6.Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);
				
				if (choice == 6) {  return;	 }
				System.out.println("Please enter the quantity of product you want to buy");
				quantity = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+quantity);

				switch(choice)
				{
					case 1: addToCart("Black formal", 250, quantity); break;
					case 2: addToCart("White formal", 275, quantity); break;
					case 3: addToCart("Green formal", 300, quantity); break;
					case 4: addToCart("Yellow formal", 325, quantity); break;
					case 5: addToCart("Purple formal", 350, quantity); break;
					default: System.out.println("Wrong Input detected, please re-enter your value");
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void section5()// ethnic wear
	{
		int choice;
		int quantity;

		while(true)
		{
			System.out.println("Here is the range of Ethnic Wear you can buy from our store");
			System.out.println("1.Black Ethnic Wear 		(250 rupees)");
			System.out.println("2.White Ethnic Wear 		(275 rupees)");
			System.out.println("3.Green Ethnic Wear  		(300 rupees)");
			System.out.println("4.Yellow Ethnic Wear 		(325 rupees)");
			System.out.println("5.Purple Ethnic Wear 		(350 rupees)");
			System.out.println("6.Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);
				
				if (choice == 6) {  return;	 }
				System.out.println("Please enter the quantity of product you want to buy");
				quantity = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+quantity);

				switch(choice)
				{
					case 1: addToCart("Black Ethnic Wear", 250, quantity); break;
					case 2: addToCart("White Ethnic Wear", 275, quantity); break;
					case 3: addToCart("Green Ethnic Wear", 300, quantity); break;
					case 4: addToCart("Yellow Ethnic Wear", 325, quantity); break;
					case 5: addToCart("Purple Ethnic Wear", 350, quantity); break;
					default: System.out.println("Wrong Input detected, please re-enter your value");
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void addToCart(String str, int c, int q)
	{
		MainInterface.CT.item.add(str);
		MainInterface.CT.cost.add(c);
		MainInterface.CT.quantity.add(q);
	}
}

//Class to handle category "accessories" of the clothing store
class Acessories implements Store
{
	public void sectionSelect()
	{
		int choice;
		while(true)
		{
			System.out.println("Please choose from the following options:");
			System.out.println("1. Glasses");
			System.out.println("2. Shoes");
			System.out.println("3. Watches");
			System.out.println("4. Jewelry");
			System.out.println("5. wallets");
			System.out.println("6. Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);

				switch(choice)
				{
					case 1: section1(); break;
					case 2: section2(); break;
					case 3: section3(); break;
					case 4: section4(); break;
					case 5: section5(); break;
					case 6: return;
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void section1()// glassess
	{
		int choice;
		int quantity;

		while(true)
		{
			System.out.println("Here is the range of glassess you can buy from our store");
			System.out.println("1.Black glasses 		(250 rupees)");
			System.out.println("2.White glasses 		(275 rupees)");
			System.out.println("3.Green glasses  		(300 rupees)");
			System.out.println("4.Yellow glasses 		(325 rupees)");
			System.out.println("5.Purple glasses 		(350 rupees)");
			System.out.println("6.Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);
				
				if (choice == 6) {  return;	 }
				System.out.println("Please enter the quantity of product you want to buy");
				quantity = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+quantity);

				switch(choice)
				{
					case 1: addToCart("Black glasses", 250, quantity); break;
					case 2: addToCart("White glasses", 275, quantity); break;
					case 3: addToCart("Green glasses", 300, quantity); break;
					case 4: addToCart("Yellow glasses", 325, quantity); break;
					case 5: addToCart("Purple glasses", 350, quantity); break;
					default: System.out.println("Wrong Input detected, please re-enter your value");
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void section2()// shoes
	{
		int choice;
		int quantity;

		while(true)
		{
			System.out.println("Here is the range of shoes you can buy from our store");
			System.out.println("1.Black shoes 		(250 rupees)");
			System.out.println("2.White shoes 		(275 rupees)");
			System.out.println("3.Green shoes  		(300 rupees)");
			System.out.println("4.Yellow shoes 		(325 rupees)");
			System.out.println("5.Purple shoes 		(350 rupees)");
			System.out.println("6.Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);
				
				if (choice == 6) {  return;	 }
				System.out.println("Please enter the quantity of product you want to buy");
				quantity = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+quantity);
				switch(choice)
				{
					case 1: addToCart("Black shoes", 250, quantity); break;
					case 2: addToCart("White shoes", 275, quantity); break;
					case 3: addToCart("Green shoes", 300, quantity); break;
					case 4: addToCart("Yellow shoes", 325, quantity); break;
					case 5: addToCart("Purple shoes", 350, quantity); break;
					default: System.out.println("Wrong Input detected, please re-enter your value");
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void section3()// watches
	{
		int choice;
		int quantity;

		while(true)
		{
			System.out.println("Here is the range of watches you can buy from our store");
			System.out.println("1.Round watch 			(250 rupees)");
			System.out.println("2.Square watch 			(275 rupees)");
			System.out.println("3.Digital watch  		(300 rupees)");
			System.out.println("4.Kids watch 			(325 rupees)");
			System.out.println("5.Fitness band 			(350 rupees)");
			System.out.println("6.Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);
				
				if (choice == 6) {  return;	 }
				System.out.println("Please enter the quantity of product you want to buy");
				quantity = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+quantity);

				switch(choice)
				{
					case 1: addToCart("Round Watch", 250, quantity); break;
					case 2: addToCart("Square Watch", 275, quantity); break;
					case 3: addToCart("Digital Watch", 300, quantity); break;
					case 4: addToCart("Kids Watch", 325, quantity); break;
					case 5: addToCart("Fitness Band", 350, quantity); break;
					default: System.out.println("Wrong Input detected, please re-enter your value");
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void section4()// Jewelry
	{
		int choice;
		int quantity;

		while(true)
		{
			System.out.println("Here is the range of Jewelry you can buy from our store");
			System.out.println("1.Necklace 			(250 rupees)");
			System.out.println("2.Bracelet 			(275 rupees)");
			System.out.println("3.Ear rings 		(300 rupees)");
			System.out.println("4.Rings     		(325 rupees)");
			System.out.println("5.Anklets   		(350 rupees)");
			System.out.println("6.Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);
				
				if (choice == 6) {  return;	 }
				System.out.println("Please enter the quantity of product you want to buy");
				quantity = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+quantity);

				switch(choice)
				{
					case 1: addToCart("Necklace", 250, quantity); break;
					case 2: addToCart("Bracelet", 275, quantity); break;
					case 3: addToCart("Earrings", 300, quantity); break;
					case 4: addToCart("Rings", 325, quantity); break;
					case 5: addToCart("Anklets", 350, quantity); break;
					default: System.out.println("Wrong Input detected, please re-enter your value");
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void section5()// wallets
	{
		int choice;
		int quantity;

		while(true)
		{
			System.out.println("Here is the range of Wallet you can buy from our store");
			System.out.println("1.Black Wallet 			(250 rupees)");
			System.out.println("2.White Wallet 			(275 rupees)");
			System.out.println("3.Green Wallet  		(300 rupees)");
			System.out.println("4.Yellow Wallet 		(325 rupees)");
			System.out.println("5.Purple Wallet 		(350 rupees)");
			System.out.println("6.Go back");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+choice);
				
				if (choice == 6) {  return;	 }
				System.out.println("Please enter the quantity of product you want to buy");
				quantity = Integer.parseInt(sc.readLine());
				//System.out.println("Option Chosen: "+quantity);

				switch(choice)
				{
					case 1: addToCart("Black Wallet", 250, quantity); break;
					case 2: addToCart("White Wallet", 275, quantity); break;
					case 3: addToCart("Green Wallet", 300, quantity); break;
					case 4: addToCart("Yellow Wallet", 325, quantity); break;
					case 5: addToCart("Purple Wallet", 350, quantity); break;
					default: System.out.println("Wrong Input detected, please re-enter your value");
				}
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}
		}
	}

	public void addToCart(String str, int c, int q)
	{
		MainInterface.CT.item.add(str);
		MainInterface.CT.cost.add(c);
		MainInterface.CT.quantity.add(q);
	}
}

//Class to handle check out processing of the program
class CheckOut
{
	boolean invoicech = false; 	//Variable to check whether final check out process is going on
	int payment;				//Variable to check what method of payment user is using
	int pass;					//Variable to store payment detail (password)
	int i;						//Variable fo looping statements
	int total = 0;				//Variable to calculate total cost of items
	
	double tax;					//Variable to calculate tax on every item
	double finalTotal;			//Variable to store Total + tax

	String checkout;			//Variable to store information
	String address;				//Variable to store user address information
	String detail;				//Variable to store payment detail (identification)

	//Function to diplay bill
	void bill()
	{
		if(invoicech == false)
		{
			for(i = 0; i < MainInterface.CT.cost.size(); i++)
			{	total += MainInterface.CT.cost.get(i)*MainInterface.CT.quantity.get(i);	  }
			tax = total * 0.18;
			finalTotal = (double) total + tax;
		}

		if(i != 0)
		{
			MainInterface.CT.displayCart();
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Total Amount:\t\t\t\t\t\t"+total);
			System.out.println("Tax (18%):\t\t\t\t\t\t"+tax);
			System.out.println("Final Total:\t\t\t\t\t\t"+finalTotal);
		}
		else 	
		{
			System.out.println("There are no items in your cart, please fill cart to check out.");
			return;
		}

		if(invoicech == false)
		{
			System.out.println("If you want to proceed to check out, please enter \"Yes\", if you want to go back, enter \"No\"");
			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				checkout = sc.readLine();
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}

			if(checkout.equalsIgnoreCase("Yes")) proceedToCheckOut();
			else return;
		}
		invoicech = false;
	}

	//Function to ask user whether they want to giftwrap their order
	private int giftWrap()
	{
		int choice;

		System.out.println("If you want your order gift wrapped (extra 200 rupees), please press 1, if not, press any other number");
		try
		{
			BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
			choice = Integer.parseInt(sc.readLine());
			return choice;
		}
		catch (FileNotFoundException e){}
		catch (IOException e){}

		return 0;
	}

	//Function to take inputs from user about payment details, address, giftwrapping
	private void proceedToCheckOut()
	{
		int gift;

		if(MainInterface.SU.signedIn != 1)
		{
			System.out.println("You haven't signed in yet, please sign in to proceed to check out");
			return;
		}

		System.out.println("Please Enter Delivery Address:");
		try
		{
			BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
			address = sc.readLine();
		}
		catch (FileNotFoundException e){}
		catch (IOException e){}

		gift = giftWrap();
		if(gift == 1) finalTotal += 200;

		System.out.println("Please Enter the method by which you will be paying");
		System.out.println("1. Card Payment");
		System.out.println("2. UPI/Net banking");
		System.out.println("3. Cash On Delivery");
		try
		{
			BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please Select one of the following options:");
			payment = Integer.parseInt(sc.readLine());

			if(payment == 1) cardPayment();
			else if(payment == 2) netBanking();
		}
		catch (FileNotFoundException e){}
		catch (IOException e){}
		invoice();
	}

	//Function to take card payment information from user
	void cardPayment()
	{
		try
		{
			BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter your card number:");
			detail = sc.readLine();
			System.out.println("Enter the 3 digit CVV number on the back of your card:");
			pass = Integer.parseInt(sc.readLine());
		}
		catch (FileNotFoundException e){}
		catch (IOException e){}
	}

	//Function to take net banking information from user
	void netBanking()
	{
		try
		{
			BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter your account number:");
			detail = sc.readLine();
			System.out.println("Enter the 4 digit pin for your digital bank account:");
			pass = Integer.parseInt(sc.readLine());
		}
		catch (FileNotFoundException e){}
		catch (IOException e){}
	}

	//Function to display invoice of order
	void invoice()
	{
		invoicech = true;
		System.out.println("Thank you for buying from our store, we hope you had a great experience!");
		System.out.println("Here is your invoice for the transaction:");
		System.out.println("User ID: "+MainInterface.SU.userID);
		System.out.println("Username: "+MainInterface.SU.username);
		System.out.println("Email address: "+MainInterface.SU.emailID);
		System.out.println("Phone Number: "+MainInterface.SU.phoneNumber);
		System.out.println("Delivery Address: "+address);

		bill();

		System.out.print("Payment Option Chosen: ");
		if(payment == 1) System.out.println("Card Payment");
		else if(payment == 2) System.out.println("UPI/Net Banking");
		else if(payment == 3) System.out.println("Cash On Delivery");

		System.out.println("Information: "+detail+" "+pass);
	}
}

//Main interface class
class MainInterface
{
	int choice;

	public static SignUp SU = new SignUp();
	public static Cart CT = new Cart();

	//user interface function
	public void userInterface() throws IOException, InterruptedException
	{
		int choice;

		while(true)
		{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
			System.out.println("Welcome to the Group one Clothing Store!!!");
			System.out.println("Please choose from the following options:");
			System.out.println("1. Sign Up");
			System.out.println("2. Cart");
			System.out.println("3. Men's Clothing");
			System.out.println("4. Women's Clothing");
			System.out.println("5. Children's Clothing");
			System.out.println("6. Acessories");
			System.out.println("7. Check out");
			System.out.println("8. Exit");

			try
			{
				BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please Select one of the following options:");
				choice = Integer.parseInt(sc.readLine());
			
				//System.out.println("Option Chosen: "+choice);

				switch(choice)
				{
					case 1:
					SU.signUpInterface();
					break;
					case 2:
					CT.displayCart();
					break;
					case 3:
					MensClothing MC = new MensClothing();
					MC.sectionSelect();
					break;
					case 4:
					WomensClothing WC = new WomensClothing();
					WC.sectionSelect();
					break;
					case 5:
					ChildrensClothing CC = new ChildrensClothing();
					CC.sectionSelect();
					break;
					case 6:
					Acessories AC = new Acessories();
					AC.sectionSelect();
					break;
					case 7:
					CheckOut CO = new CheckOut();
					CO.bill();
					break;
					case 8:
					return;
				}

				System.out.println("Press the enter key to continue:");
				String garb = sc.readLine();
			}
			catch (FileNotFoundException e){}
			catch (IOException e){}

		}
	}
}

//main class, carries out all functions
public class Microproject
{
	public static void main(String args[])
	{
		try
		{
			MainInterface MI = new MainInterface();
			MI.userInterface();
		}
		catch(IOException e) {}
		catch(InterruptedException e) {}
	}
}