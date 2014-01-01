package ambrose;
// Generated from null -- DO NOT MODIFY

import martini.model.Page;
import martini.model.*;
import static martini.util.Util.hasText;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends Page
{

	@Override
	public String getURI() { return "/login"; };

	@Override
	public void setUrlParams( Map<String,String> params ) {
	}

	private Object _status = null;
	public Object getStatus() { return _status; }
	public void setStatus( Object status ) {
		_status = status;
	}

	private LoginCredentialsForm _credentialsForm = null;
	public LoginCredentialsForm getCredentialsForm() { return _credentialsForm; }
	public void setCredentialsForm( LoginCredentialsForm credentialsForm ) {
		_credentialsForm = credentialsForm;
	}

	public void render( HttpServletResponse response )
		throws ServletException, IOException 
	{
		setXMLWriter( response.getWriter() );
		document();
		element( "html" );
		attribute( "xmlns", "http://www.w3.org/1999/xhtml" );
		element( "head" );
		element( "title" );
		text( " " );
		text( getTitle() );
		text( " " );
		pop();
		pop();
		element( "body" );
		text( "\n" );
		text( "\n\n\n\t" );
		element( "span" );
		attribute( "martini", "status" );
		text( " " );
		text( getStatus() );
		text( " " );
		pop();
		text( "\n\t\n\t" );
		element( "form" );
		attribute( "enctype", "application/x-www-form-urlencoded" );
		attribute( "method", "POST" );
		attribute( "martini", "credentials" );
		text( "\n\t\t" );
		element( "p" );
		text( "\n\t\t\t" );
		element( "b" );
		text( "User name:" );
		pop();
		element( "br" );
		attribute( "clear", "none" );
		pop();
		text( "\n\t\t\t" );
		element( "input" );
		attribute( "type", "text" );
		attribute( "name", "username" );
		attribute( "placeholder", "Username" );
		attribute( "value", getCredentialsForm().getUsername() );
		pop();
		text( "\n\t\t" );
		pop();
		text( "\n\t\t" );
		element( "p" );
		text( "\n\t\t\t" );
		element( "b" );
		text( "Password:" );
		pop();
		element( "br" );
		attribute( "clear", "none" );
		pop();
		text( "\n\t\t\t" );
		element( "input" );
		attribute( "type", "password" );
		attribute( "name", "password" );
		attribute( "placeholder", "Password" );
		attribute( "value", getCredentialsForm().getPassword() );
		pop();
		text( "\n\t\t" );
		pop();
		text( "\n\t\t" );
		element( "p" );
		text( "\n\t\t\t" );
		element( "input" );
		attribute( "type", "submit" );
		attribute( "value", "Login" );
		pop();
		text( "\n\t\t" );
		pop();
		text( "\n\t" );
		pop();
		text( "\n" );
		pop();
		pop();
		close();
	}
	@Override
	public void populateForm( Map<String,String[]> params )
	{
		getCredentialsForm().setUsername( getRequestParameter( params, "username" )); 
		getCredentialsForm().setPassword( getRequestParameter( params, "password" )); 
	}
}
