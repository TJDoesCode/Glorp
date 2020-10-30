package com.gmail.tjdoescode.glorp;

/**
 * Custom interpreter logging messages
 * Messages classified based on set logLevel
 * @author Trevor R
 */
public class Logger {
	private LogLevel logLvl;
	
	public Logger(LogLevel lvl) {
		this.logLvl = lvl;
	}
	
	public void error(String fmt, Object ... args) {
		if (!(this.logLvl.lvl >= LogLevel.ERROR.lvl)) return;
		System.out.printf("ERROR: " + fmt + "\n", args);
	}
	
	public void warn(String fmt, Object ... args) {
		if (!(this.logLvl.lvl >= LogLevel.ERROR.lvl)) return;
		System.out.printf("WARN: " + fmt + "\n", args);
	}
	
	public void info(String fmt, Object ...args) {
		if (!(this.logLvl.lvl >= LogLevel.DEV.lvl)) return;
		System.out.printf("INFO: " + fmt + "\n", args);
	}
	
	public void emit(String fmt, Object ...args) {
		if (!(this.logLvl.lvl >= LogLevel.DEV.lvl)) return;
		System.out.printf("DEV: " + fmt + "\n", args);
	}
}
