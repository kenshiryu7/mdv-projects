package com.lpuente.pack2;

public class InterfacCLASS implements J2Product {

	
	
	//setting name and price
		String name;
		double price;
		
		public InterfacCLASS(String name, double price)
		{
		//setting name and price as methods
			setName(name);
			setPrice(price);
		}

		//setting boolean methods
		@Override
		public boolean setName(String name) 
		{
			this.name = name;
			
			return true;
		}

		@Override
		public boolean setPrice(double price) 
		{
			this.price = price;
			
			return true;
		}

		@Override
		public String getName() 
		{
			//returns name string
			return this.name;
		}

		@Override
		public double getPrice() 
		{
			//returns price double
			return this.price;
		}

}

