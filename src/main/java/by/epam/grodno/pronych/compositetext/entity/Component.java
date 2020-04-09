package by.epam.grodno.pronych.compositetext.entity;

import java.util.List;

public interface Component {
	void add(Component obj);
	void remove(Component obj);
	Component get(int index);
	String getData();
	List<Component> getAllCompositeObjects();
	int getType();
}
