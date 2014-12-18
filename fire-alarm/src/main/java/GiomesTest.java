import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import com.sample.domain.Applicant;
import com.sample.domain.Application;
import com.sample2.domain.Fire;
import com.sample2.domain.Room;
import com.sample2.domain.Sprinkler;

public class GiomesTest {

	@Test
	public void test1() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("giomes-rules-ks");

		Applicant applicant = new Applicant("Mr John Smith", 16);

		Application application = new Application();

		assertTrue(application.isValid());

		kSession.insert(applicant);
		kSession.insert(application);
		kSession.fireAllRules();

		assertFalse(application.isValid());

	}

	@Test
	public void test2() {
		KieServices kieServices = KieServices.Factory.get();
		KieContainer kContainer = kieServices.getKieClasspathContainer();
		KieSession ksession = kContainer.newKieSession("giomes-rules-ks2");
		String[] names = new String[]{"kitchen", "bedroom", "office", "livingroom"};

		Map<String,Room> name2room = new HashMap<String,Room>();
		for( String name: names ){
		    Room room = new Room( name );
		    name2room.put( name, room );
		    ksession.insert( room );
		    Sprinkler sprinkler = new Sprinkler( room );
		    ksession.insert( sprinkler );
		}
		ksession.fireAllRules();
		System.out.println("**** After 1 invocation");
		Fire kitchenFire = new Fire( name2room.get( "kitchen" ) );
		Fire officeFire = new Fire( name2room.get( "office" ) );
		FactHandle kitchenFireHandle = ksession.insert( kitchenFire );
		FactHandle officeFireHandle = ksession.insert( officeFire );
		ksession.fireAllRules();
		System.out.println("***** After 2 invocation");
		ksession.delete( kitchenFireHandle );
		ksession.delete( officeFireHandle );
		ksession.fireAllRules();
		System.out.println("***** After 3 invocation");
	}

}
