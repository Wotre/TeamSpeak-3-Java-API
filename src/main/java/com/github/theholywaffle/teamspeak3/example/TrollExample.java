/*******************************************************************************
 * Copyright (c) 2013 Bert De Geyter (https://github.com/TheHolyWaffle).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Bert De Geyter (https://github.com/TheHolyWaffle) - initial API and implementation
 ******************************************************************************/
package com.github.theholywaffle.teamspeak3.example;

import java.util.ArrayList;
import java.util.Random;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.TS3Query.FloodRate;
import com.github.theholywaffle.teamspeak3.api.event.DefaultListener;
import com.github.theholywaffle.teamspeak3.api.wrapper.Channel;

public class TrollExample {

	public static void main(String[] args) {

		TS3Api api = new TS3Query("77.77.77.77", TS3Query.DEFAULT_PORT,
				FloodRate.DEFAULT).connect().getApi();

		api.login("serveradmin", "serveradminpassword");
		api.selectVirtualServerById(1);
		api.setNickname("PutPutBot");
		api.addTS3Listeners(new DefaultListener());

		api.registerAllEvents();
	}

	public static void troll(String name, TS3Api bot) {
		ArrayList<Channel> channels = new ArrayList<>();
		for (Channel c : bot.getChannels()) {
			if (c.getTotalClients() > 0) {
				channels.add(c);
			}
		}

		int clientId = bot.getClientByName(name).get(0).getId();

		Random r = new Random();
		while (true) {
			int channelId = channels.get(r.nextInt(channels.size())).getId();
			bot.moveClient(clientId, channelId);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void troll2(String name, TS3Api bot) {
		int clientId = bot.getClientByName(name).get(0).getId();

		int i = 0;
		Random r = new Random();
		while (true) {
			try {
				Thread.sleep(r.nextInt(30_000) + 30_000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			bot.pokeClient(clientId, i + "");
			i++;
		}
	}

}
