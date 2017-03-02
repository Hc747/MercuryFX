package org.mercury.app.engine;

import com.linkedin.parseq.Engine;
import com.linkedin.parseq.EngineBuilder;
import lombok.Getter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author Harrison, Alias: Hc747, Contact: harrisoncole05@gmail.com
 * @version 1.0
 * @since 2/3/17
 */
@Getter
public final class TaskEngine {

	private final Engine engine;

	public TaskEngine() {
		final int cores = Math.max(2, Runtime.getRuntime().availableProcessors() / 2);
		final ScheduledExecutorService executor = Executors.newScheduledThreadPool(cores);
		final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
		engine = new EngineBuilder().setTaskExecutor(executor).setTimerScheduler(scheduler).build();
	}

	public void shutdown() throws Exception {
		engine.shutdown();
	}

}
