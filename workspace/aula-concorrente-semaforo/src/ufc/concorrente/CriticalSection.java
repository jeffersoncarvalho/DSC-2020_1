package ufc.concorrente;

import java.util.ArrayList;
import java.util.List;

public class CriticalSection {
	
	private List<String> myList;
	
	public CriticalSection() {
		this.myList = new ArrayList<String>();
	}
	
	public void add(String n) {
		this.myList.add(n);
	}
	
	public List<String> getMyList() {
		return this.myList;
	}

}
