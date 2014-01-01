package ambrose;

import martini.model.*;

public class 
	SearchResultsItem
extends 
	ListItem
{
	private Object _description = null;
	public Object getDescription() { return _description; }
	public void setDescription( Object description ) { _description = description; }

	private Object _course = null;
	public Object getCourse() { return _course; }
	public void setCourse( Object course ) { _course = course; }

	private Object _catalog = null;
	public Object getCatalog() { return _catalog; }
	public void setCatalog( Object catalog ) { _catalog = catalog; }

	private Object _link = null;
	public Object getLink() { return _link; }
	public void setLink( Object link ) { _link = link; }

	private Object _linkHref = null;
	public Object getLinkHref() { return _linkHref; }
	public void setLinkHref( Object linkHref ) { _linkHref = linkHref; }

}
