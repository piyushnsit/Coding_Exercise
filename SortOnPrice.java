//This creates a comparator to sort collection first on company name and then on max share price
//After collection has been sorted using this comparator, first record for each company will have max share price

import java.util.Comparator;

public class SortOnPrice implements Comparator<SharePrice> {
	public int compare(SharePrice o1, SharePrice o2) {
		//ascending order of company
		int comp = o1.getComp().compareTo(o2.getComp());
		if(comp!=0)
			return comp;
		else					
			//descending order of share value
			return o2.getValue() - o1.getValue();
	}
}
