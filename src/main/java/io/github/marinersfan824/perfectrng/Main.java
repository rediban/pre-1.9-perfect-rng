package io.github.marinersfan824.perfectrng;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main implements ModInitializer {
	public static int numConverted;
	public static Logger LOGGER = LogManager.getLogger();
	public static String MOD_NAME = "Perfect RNG";
	public static void log(Level level, String message) {
		LOGGER.log(level, "[" + MOD_NAME + "] " + message);
	}


	@Override
	public void onInitialize() {
		log(Level.INFO, "Initializing Perfect RNG Mod...");
	}
}
