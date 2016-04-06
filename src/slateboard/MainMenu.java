package slateboard;

//package Test2;

import java.io.*;

class MainMenu
{
	public MainMenu() throws Exception
	{
		
		System.out.println("\t======================");
		System.out.println("\tFILE SHARING-MAIN MENU");
		System.out.println("\t======================");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Choose one of the following:");
		System.out.print("1-Connect as Server.\n2-Connect as Client.\n3-Exit.\n\n");

		System.out.print("Enter number: ");
		int i = Integer.parseInt(br.readLine());
		if (i>0 && i<4)
		{
		
		switch(i)
		{			
			case 1:
				System.out.println("\t===SERVER===");
                                Server server = new Server();
			break;
			case 2:
				System.out.println("\t===CLIENT===");
                                Client client = new Client();
			break;
			case 3:
				System.out.println("\t===SYSTEM EXIT===");
                                System.exit(1);
			break;                              			
			default:
				System.out.println("You have not entered correct choice.Program terminated!!!");
		}
		}else System.out.println("Wrong Choice.");
	}
}
