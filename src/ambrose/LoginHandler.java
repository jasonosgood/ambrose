package ambrose;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import martini.model.Handler;
import martini.runtime.RedirectException;

public class 
	LoginHandler 
extends 
	Handler<Login> 
{
	@Override
	public void GET( Login page, HttpServletRequest request, HttpServletResponse response )
		throws Exception
	{
		HttpSession session = request.getSession( true );
		Object username = session.getAttribute( "username" );
		Object login = session.getAttribute( "login" );
		if( login == null )
		{
			page.setStatus( "Please login" );
		}
		else if( Boolean.TRUE.equals( login ))
		{
			page.setStatus( "Success!" );
		}
		else if( Boolean.FALSE.equals( login ))
		{
			page.setStatus( "Please try again" );
		}
		
		LoginCredentialsForm form = page.getCredentialsForm();
		form.setUsername( username != null ? username : "" );
	}
	
	@Override
	public void POST( Login page, HttpServletRequest request, HttpServletResponse response )
		throws Exception
	{
		LoginCredentialsForm form = page.getCredentialsForm();
		String username = form.getUsername().toString();
		String password = form.getPassword().toString();
		boolean nameOK = username.equalsIgnoreCase( "jason" );
		boolean secretOK = password.equals( "password" );
		
		HttpSession session = request.getSession( true );
		session.setAttribute( "username", username );
		
		boolean login = nameOK && secretOK;
		session.setAttribute( "login", Boolean.valueOf( login ));
		
		if( !login )
		{
			throw new RedirectException( page.getURI() );
		}
	}

}
