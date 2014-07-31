package ambrose;

import martini.model.*;
import java.util.List;
import java.util.ArrayList;

public class 
	SearchPagesItem
extends 
	ListItem
{
	private Object _nth = null;
	public Object getNth() { return _nth; }
	public void setNth( Object nth ) { _nth = nth; }

	private Object _nthHref = null;
	public Object getNthHref() { return _nthHref; }
	public void setNthHref( Object nthHref ) { _nthHref = nthHref; }

}
