package com.lpuente.pack2;

import java.util.HashMap;

//Enums are used to create a data type the has a specific functionality

public enum LiquidConv {

	//Creating enum data. Following video exactly. Hopefully to better understand
	//PENNY(1),
	//NICKEL(5),
	//DIME(10),
	//QUARTER(25),
	//DOLLAR(100);
	
	OUNCE(1),
	CUP(8),
	PINT(16),
	QUART(32),
	GALLON(128);
	
	public final int datavalue;
	
	LiquidConv(int value)
	{
		this.datavalue = value;
	}
	
//Hashmap. calling getData and passing (double amount). Passing key and value <HashMap <Key, Value>
	public static HashMap<LiquidConv, Integer> getData(double amount)
	{
	//declaring hash map
		HashMap<LiquidConv, Integer> returndata = new HashMap <LiquidConv, Integer>();
		
	//Creating array/ following video/ calling values first created in ENUM. wow tons of info
		//Data[] mydata = {DOLLAR, QUARTER, DIME, NICKEL, PENNY};
		LiquidConv[]mydata = {GALLON, QUART, PINT, CUP, OUNCE};
		
	//variable to hold final outcome (change in video)
		//double whatsleft = amount*100;
		double whatsleft = amount*128;
		
	//Looping through the array
		for(int i = 0; i< mydata.length; i++)
		{
			LiquidConv dta = mydata[i];
			int num = (int) Math.floor(whatsleft/dta.datavalue);
		//collects remainder
			whatsleft = whatsleft%dta.datavalue;
			
			returndata.put(dta, num);
		}
		
		return returndata;
	}
}
