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

import java.util.ArrayList;
import java.util.List;

public class CustomEmote {

	private String name;
	private EmoteType emoteType;

	private List<Integer> timings = new ArrayList<Integer>();
	private List<String> skulls = new ArrayList<String>();
	private int totalLength = 0;

	public CustomEmote(String name) {
		this.name = name;
	}

	public CustomEmote(EmoteType emoteType) {
		this.emoteType = emoteType;
	}
	
	public String getName() {
		return name != null ? name : emoteType.getName();
	}

	public EmoteType getEmoteType() {
		return emoteType;
	}

	public String getFrameData(int i) {
		return skulls.get(i);
	}

	public int getFrameLength(int i) {
		return timings.get(i);
	}

	public int getTotalFrameLength() {
		int total = 0;
		for (int i = 0; i < size(); i++) 
			total = total + getFrameLength(i);
		return total;
	}
	
	public int getTotalLength() {
		return totalLength;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmoteType(EmoteType emoteType) {
		this.emoteType = emoteType;
	}

	public void addFrame(int timing, String skull) {
		timings.add(timing);
		totalLength = totalLength + timing;
		skulls.add(skull);
	}

	public int size() {
		return timings.size();
	}
}
