package ambrose;

import martini.model.*;

public class 
	LoginCredentialsForm
extends 
	Form<Login>
{
	private Object _username = null;
	public Object getUsername() { return _username; }
	public void setUsername( Object username ) { _username = username; }

	private Object _password = null;
	public Object getPassword() { return _password; }
	public void setPassword( Object password ) { _password = password; }

}
