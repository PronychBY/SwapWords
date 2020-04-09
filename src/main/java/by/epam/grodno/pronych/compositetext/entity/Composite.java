package by.epam.grodno.pronych.compositetext.entity;

import java.util.LinkedList;
import java.util.List;

public class Composite implements Component {
	List<Component> itext = new LinkedList<Component>();
	int type;
	
	public Composite(int type) {
		this.type = type;
	}

	public void add(Component obj) {
		itext.add(obj);
	}

	public void remove(Component obj) {
		itext.remove(obj);
	}

	public Component get(int index) {
		return itext.get(index);
	}
	
	public List<Component> getItext() {
		return itext;
	}

	public int getType() {
		return type;
	}

	public List<Component> getAllCompositeObjects(){
		List<Component> result = new LinkedList<Component>();
		result.add(this);
		
		for (Component s: itext) {
			List<Component> childObjects = s.getAllCompositeObjects();
			for (Component childObject: childObjects) {
				result.add(childObject);
			}
		}
		return result;
	}
	
	public String getData() {
		String result = "";
		for (Component s: itext) {
			result = result + s.getData();
		}
		return result;
	}
	
}
