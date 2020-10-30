package com.gmail.tjdoescode.glorp;

public enum LogLevel {
	ERROR(0), WARN(1), INFO(2), DEV(3);
	
	int lvl;
	LogLevel(int l) {
		lvl = l;
	}
}
