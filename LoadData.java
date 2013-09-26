//This is the main loader class which accepts filename and its path as input and load the data in collection
//Once loaded, collection is stored using comparator defined and result is displayed to user

import java.io.*;
import java.util.*;

public class LoadData {

	public static void main(String[] args) {
		
		BufferedReader reader = null;
		String filename = "";
		String filedir = "";
		String filePath = "";
		String line = null;
		int noOfRows = 0;
		int totalComps = 0;
		int i = 0;
		
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter filename:");
		filename = in.nextLine();
		System.out.println("Enter filepath:");
		filedir = in.nextLine();
		filePath = filedir.trim()+filename.trim();
		System.out.println("file path is :" + filePath);
		
		//collection to save data and sort
		List<SharePrice> sharedata = new ArrayList<SharePrice>();
		
		try {
			 reader = new BufferedReader(new FileReader(filePath));
			 
			 System.out.println("File found!! Processing data");
			 //process the header to get company names in array
			 line=reader.readLine();
			 String compnames[] = line.split(",");
			 totalComps = compnames.length - 2;
			 
			 //read data and save it in collection
			 while((line=reader.readLine())!=null)
			 {
				noOfRows++;
				String cols[] = line.split(",");
				for(i = 2; i < cols.length; i++)
				{
					sharedata.add(new SharePrice(compnames[i].trim(),cols[0],cols[1],Integer.parseInt(cols[i].trim())));
				}
				
				//extra insertion in case any row have less no of records than "no of companies" + 2
				for(int j = i; j < totalComps+2; j++)
				{
					sharedata.add(new SharePrice(compnames[j].trim(),cols[0],cols[1],0));
				}
			 }
		} catch (FileNotFoundException e) {
			System.out.println("Input file not found!!! Please correct file name or path");
		} catch (IOException e) {
			System.out.println("Error occured during file processing. Aborting!!!");
		}
		
		//sort the data using comparator created
		Collections.sort(sharedata, new SortOnPrice());
		
		System.out.println("Following is the result");
		//display max share value for each company
		for(i = 0; i < totalComps*noOfRows; i=i+noOfRows)
		{
			SharePrice obj = sharedata.get(i);
			System.out.println(obj.getComp() + " had maximum share value of " + obj.getValue() + " on" + obj.getMonth() + "'" + obj.getYear());
		}
	}
}
