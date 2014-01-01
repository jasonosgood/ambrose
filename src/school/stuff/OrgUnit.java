package school.stuff;

import java.util.ArrayList;
import java.util.List;

public abstract class OrgUnit<C extends OrgUnit<?>> {

	private List<C> _children = new ArrayList<C>();
	
	public List<C> getChildren() {
		return _children;
	}
	
	public void setChildren( List<C> children ) {
		_children = children;
	}
	
}
