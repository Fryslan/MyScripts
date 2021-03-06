package com.cGildedBench.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.wrappers.Npc;

import com.cGildedBench.data.Constants;

public class Banking implements Strategy {

	@Override
	public boolean activate() {
		return Inventory.getCount(Constants.MAHOGANY_PLANKS) == 0 && Inventory.getCount(Constants.GOLD_LEAFS) == 0;
	}

	@Override
	public void execute() {
		if (Game.getOpenInterfaceId() == Constants.INTERFACE_ID) {
			Menu.sendAction(867, 8782, 0, 5382, 5);
			Menu.sendAction(867, 8784, 1, 5382, 5);
			Menu.sendAction(200, 311, 0, 5384, 1);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Game.getOpenInterfaceId() == Constants.INTERFACE_ID;
				}
			}, 500);
		} else {
			Npc[] butlerId = Npcs.getNearest(Constants.BANK_ID);
			if (butlerId.length > 0 && butlerId != null
					&& butlerId[0].distanceTo() > 0
					&& Players.getMyPlayer().getAnimation() == -1) {
				butlerId[0].interact(2);
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Players.getMyPlayer().getAnimation() != -1;
					}
				}, 500);
			}
		}
	}
}
