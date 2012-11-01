package com.lpuente.pack2;

import java.util.HashMap;

//Enums are used to create a data type the has a specific functionality

public enum Data {

	//Creating enum data. Following video exactly. Hopefully to better understand
	PENNY(1),
	NICKEL(5),
	DIME(10),
	QUARTER(25),
	DOLLAR(100);
	
	public final int datavalue;
	
	Data(int value)
	{
		this.datavalue = value;
	}
	
//Hashmap. calling getData and passing (double amount). Passing key and value <HashMap <Key, Value>
	public static HashMap<Data, Integer> getData(double amount)
	{
	//declaring hash map
		HashMap<Data, Integer> returndata = new HashMap <Data, Integer>();
		
	//Creating array/ following video/ calling values first created in ENUM. wow tons of info
		Data[] mydata = {DOLLAR, QUARTER, DIME, NICKEL, PENNY};
		
	//variable to hold final outcome (change in video)
		double whatsleft = amount*100;
		
	//Looping through the array
		for(int i = 0; i< mydata.length; i++)
		{
			Data dta = mydata[i];
			int num = (int) Math.floor(whatsleft/dta.datavalue);
		//collects remainder
			whatsleft = whatsleft%dta.datavalue;
			
			returndata.put(dta, num);
		}
		
		return returndata;
	}
}
