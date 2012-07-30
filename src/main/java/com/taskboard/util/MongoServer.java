package com.taskboard.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import de.flapdoodle.embedmongo.MongoDBRuntime;
import de.flapdoodle.embedmongo.MongodExecutable;
import de.flapdoodle.embedmongo.MongodProcess;
import de.flapdoodle.embedmongo.config.MongodConfig;
import de.flapdoodle.embedmongo.distribution.Version;
import de.flapdoodle.embedmongo.runtime.Network;

@WebListener
// @WebServlet(loadOnStartup = 0)
public class MongoServer implements ServletContextListener /*
															 * extends
															 * HttpServlet
															 */{

	private static final int PORT = 27017;

	private MongodProcess mongod = null;

	private MongodExecutable executable;

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		onStart();
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		onStop();
	}

	private void onStart() {
		MongoDBRuntime runtime = MongoDBRuntime.getDefaultInstance();

		try {
			executable = runtime.prepare(new MongodConfig(Version.V2_0_4, PORT,
					Network.localhostIsIPv6()));
			mongod = executable.start();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	private void onStop() {
		if (mongod != null) {
			mongod.stop();
			executable.cleanup();
		}
	}

	// @Override
	// public void init() throws ServletException {
	// super.init();
	//
	// onStart();
	// }
	//
	// @Override
	// public void destroy() {
	//
	// onStop();
	//
	// super.destroy();
	// }
}
