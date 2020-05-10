/*
	This file is part of skDragon - A Skript addon
      
	Copyright (C) 2016 - 2020  Sashie

	This program is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.sashie.skdragon.emotes;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.sashie.skdragon.skDragonCore;

public class SkullConfig {
	private File skullConfig;
	private FileConfiguration skullData;
	final private static HashMap<String, CustomEmote> customEmoteList = new HashMap<String, CustomEmote>();
	final private static HashMap<String, String> customSkullList = new HashMap<String, String>();

	public SkullConfig() {
		initFile();
	}

	public static boolean emoteExists(String name) {
		return customEmoteList.containsKey(name);
	}
	
	public static CustomEmote getEmote(String name) {
		return customEmoteList.get(name);
	}

	public static String getSkull(String name) {
		return customSkullList.get(name);
	}

	private void initFile() {
		skullConfig = new File(skDragonCore.getFolder(), "CustomEmotes.yml");
		if (!skullConfig.exists()) {
			skullConfig.getParentFile().mkdirs();
			skDragonCore.error("CustomEmotes.yml not found, generating new one");
			skDragonCore.getInstance().saveResource("CustomEmotes.yml", false);
		}
		skullData = new YamlConfiguration();
		try {
			skullData.load(skullConfig);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}

	public void initData() {
		for (String name : skullData.getConfigurationSection("Skulls").getKeys(false)) {
			String data = skullData.getString("Skulls." + name);
			customSkullList.put(name, data);
		}
		for (String name : skullData.getConfigurationSection("Emotes").getKeys(false)) {
			CustomEmote emote = new CustomEmote(name);
			Map<String, Object> frames = skullData.getConfigurationSection("Emotes." + name + ".Frames").getValues(false);
			Map<String, Object> timings = skullData.getConfigurationSection("Emotes." + name + ".Timings").getValues(false);
			for (int i = 1; i < frames.size() + 1; i++) {
				String key = String.valueOf(i);
				boolean found = false;
				for (String skull : customSkullList.keySet()) {
					if (skullData.getString("Emotes." + name + ".Frames." + key).equals(skull)) {
						emote.addFrame((int) timings.get(key), customSkullList.get((String) frames.get(key)));
						found = true;
						break;
					}
				}
				if (!found) {
					emote.addFrame((int) timings.get(key), (String) frames.get(key));
				}
			}

			customEmoteList.put(name, emote);
			/*
			 * //Usage 
			 * for (int i = 0; i < emote.size(); i++) {
			 * System.out.println(emote.getFrameLength(i));
			 * System.out.println(emote.getFrameData(i));
			 * }
			 */
		}
	}

	public void reload() {
		//initFile();
		customSkullList.clear();
		customEmoteList.clear();
		initData();
	}
}