package rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/*
 * L'url "/toto" doit etre unique dans l'appli
 */
@ApplicationPath("/toto")
public class ConfigurationREST extends Application {

}
