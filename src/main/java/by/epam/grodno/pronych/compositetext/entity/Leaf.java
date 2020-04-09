package by.epam.grodno.pronych.compositetext.entity;

import java.util.LinkedList;
import java.util.List;

public class Leaf implements Component {
	String str;
	int type;
	

	public Leaf(String str, int type) {
		this.str = str;
		this.type = type;
	}

	public void add(Component obj) {
		throw new UnsupportedOperationException();		
	}

	public void remove(Component obj) {
		throw new UnsupportedOperationException();		
	}

	public Component get(int index) {
		return this;
	}

	public int getType() {
		return type;
	}

	public List<Component> getAllCompositeObjects(){
		List<Component> result = new LinkedList<Component>();
		result.add(this);
		return result;
	}
	
	public String getData() {
		return str;
	}

}
