package ambrose;

import martini.model.*;

public class 
	SearchSearchForm
extends 
	Form<Search>
{
	private Object _q = null;
	public Object getQ() { return _q; }
	public void setQ( Object q ) { _q = q; }

	private Object _start = null;
	public Object getStart() { return _start; }
	public void setStart( Object start ) { _start = start; }

}
