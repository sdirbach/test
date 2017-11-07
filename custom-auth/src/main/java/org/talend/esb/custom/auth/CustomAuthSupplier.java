package org.talend.esb.custom.auth;

import java.net.URI;

import org.apache.cxf.common.util.Base64Utility;
import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.message.Message;
import org.apache.cxf.transport.http.auth.HttpAuthSupplier;
import org.apache.cxf.transport.http.auth.HttpAuthHeader;

public class CustomAuthSupplier implements HttpAuthSupplier {

    private String realm;
    private String user;
    private String pass;
    
    /**
     * This will loop from Cronus, to Andromeda, to Zorantius
     */
    public CustomAuthSupplier() {
    }
    
    public CustomAuthSupplier(String r, String u, String p) {
        realm = r;
        user  = u;
        pass  = p;
    }

    /**
     * If we don't have the realm set, then we loop
     * through the realms.
     */
    public String getAuthorization(
            AuthorizationPolicy authPolicy,
            URI     currentURI,
            Message message,
            String fullHeader
    ) {
        System.out.println("Create authorization info from custom AuthSupplier ...");
        String reqestedRealm = new HttpAuthHeader(fullHeader).getRealm();
        if (realm != null && realm.equals(reqestedRealm)) {
            return createUserPass(user, pass);
        }
        if ("Andromeda".equals(reqestedRealm)) {
            // This will get us another 401 to Zorantius
            return createUserPass("Edward", "password");
        }
        if ("Zorantius".equals(reqestedRealm)) {
            // George will get us another 401 to Cronus
            return createUserPass("George", "password");
        }
        if ("Cronus".equals(reqestedRealm)) {
            // Mary will get us another 401 to Andromeda
            return createUserPass("Mary", "password");
        }
        return null;
    }

    private String createUserPass(String usr, String pwd) {
        String userpass = usr + ":" + pwd;
        String token = Base64Utility.encode(userpass.getBytes());
        return "Basic " + token;
    }

    public boolean requiresRequestCaching() {
        return false;
    }

}