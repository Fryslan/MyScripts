package com.cPlankMaker;

import java.util.ArrayList;

import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;

import com.cPlankMaker.strategies.Banking;
import com.cPlankMaker.strategies.Making;

@ScriptManifest(author = "Capslock", 
	category = Category.OTHER, 
	description = "Makes mahogany planks", 
	name = "cPlankMaker", 
	servers = { "PKHonor" }, 
	version = 1.0)
public class Core extends Script {
	private static ArrayList<Strategy> strategies = new ArrayList<Strategy>();
	
	public boolean onExecute() {
		strategies.add(new Making());
		strategies.add(new Banking());
		provide(strategies);
		return true;
	}
	
	public void onFinish() {
		
	}
}