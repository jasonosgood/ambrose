package ambrose;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;


public class JettyAmbrose
{
	public static void main( String[] args ) 
		throws Exception
	{
		Server server = new Server( 8081 );
		WebAppContext ctx = new WebAppContext();
		ctx.setServer( server );
		ctx.setContextPath( "/" );
		ctx.setWar( "webapp" );
		server.setHandler( ctx );
		server.start();
		server.join();
	}
}
