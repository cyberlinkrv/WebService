package ServiceWeb;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Cyber_Link_Recepcao
 */
@javax.ws.rs.ApplicationPath("web")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }



    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ServiceWeb.MobileWS.class);
    }
    
}
