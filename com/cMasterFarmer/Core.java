package cMasterFarmer;

import java.util.ArrayList;

import cMasterFarmer.strategies.Steal;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;

@ScriptManifest(author = "Capslock",
        category = Category.THIEVING,
        description = "Steals from master farmer",
        name = "cMasterFarmer",
        servers = { "OSPvP" },
        version = 1.0)
public class Core extends Script {
    private static ArrayList<Strategy> strategies;
    
    public Core(){
        strategies = new ArrayList<Strategy>();    
    }

    public boolean onExecute() {
        strategies.add(new Steal());
        provide(strategies);
        return true;
    }

    public void onFinish() {

    }
}
