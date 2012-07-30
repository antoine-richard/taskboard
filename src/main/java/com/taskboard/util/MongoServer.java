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
public class MongoServer implements ServletContextListener {

	private static final int PORT = 27017;

	private MongodProcess mongod;
	private MongodExecutable executable;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		onStart();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		onStop();
	}

	private void onStart() {
		MongoDBRuntime runtime = MongoDBRuntime.getDefaultInstance();
		try {
			executable = runtime.prepare(new MongodConfig(Version.V2_0_5, PORT, Network.localhostIsIPv6()));
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
	
}