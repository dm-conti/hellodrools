package it.qiuigroup.helloworld.scanner;

import it.qiuigroup.helloworld.model.Message;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class RunScanner {
	
	public static final void main(String[] args) {
        try {
        	
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
	        
	        String groupId = "it.quigroup.drools";
	        String artifactId = "helloworld-rules";
	        String version = "1.0.0-SNAPSHOT";
	        
	        String sessionName = "ksession-rules";
	        
	        ReleaseId releaseId = ks.newReleaseId(groupId, artifactId, version);
    	    KieContainer kContainer = ks.newKieContainer(releaseId);
    	    
    	    KieScanner kScanner = ks.newKieScanner( kContainer );
    	    kScanner.scanNow();
        	
    	    KieSession kSession = kContainer.newKieSession(sessionName);

            // go !
            Message message = new Message();
            message.setMessage("Hello World");
            message.setStatus(Message.HELLO);
            kSession.insert(message);
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}