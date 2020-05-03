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

import static me.sashie.skdragon.emotes.SkullEffectsLib.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.util.Vector;

import me.sashie.skdragon.utils.MathUtils;
import me.sashie.skdragon.utils.ParticleEffect;
import me.sashie.skdragon.utils.ParticleEffect.BlockData;
import me.sashie.skdragon.utils.VectorUtils;

/**
 * Created by Sashie on 8/1/2016.
 */

public enum EmoteType {
	BLUSH(			1, "blush") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(18, BLUSH1);
			emote.addFrame(17, BLUSH2);
			emote.addFrame(5, BLUSH3);
			emote.addFrame(5, BLUSH4);
			emote.addFrame(5, BLUSH5);
			for (int i = 1; i <= 5; i++) {
				emote.addFrame(5, BLUSH4);
				emote.addFrame(5, BLUSH3);
				emote.addFrame(5, BLUSH4);
				emote.addFrame(5, BLUSH5);
			}
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	CHEEKY(			2, "cheeky") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(5, CHEEKY1);
			emote.addFrame(5, CHEEKY2);
			emote.addFrame(5, CHEEKY3);
			emote.addFrame(5, CHEEKY4);
			emote.addFrame(5, CHEEKY5);
			emote.addFrame(5, CHEEKY8);
			for (int i = 1; i <= 3; i++) {
				emote.addFrame(5, CHEEKY7);
				emote.addFrame(5, CHEEKY6);
				emote.addFrame(5, CHEEKY7);
				emote.addFrame(5, CHEEKY8);
			}
			emote.addFrame(5, CHEEKY5);
			emote.addFrame(5, CHEEKY4);
			emote.addFrame(5, CHEEKY3);
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	COOL(			3, "cool") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(10, COOL1);
			emote.addFrame(10, COOL2);
			emote.addFrame(80, COOL3);
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	CRY(			4, "cry") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(10, CRY1);
			emote.addFrame(10, CRY2);
			emote.addFrame(10, CRY3);
			emote.addFrame(5, CRY4);
			emote.addFrame(5, CRY5);
			emote.addFrame(5, CRY6);
			emote.addFrame(5, CRY7);
			int r;
			for (int i = 1; i <= 150; i++) {
	        	r = new Random().nextInt((200 - 16) + 1) + 16;
	        	if (r <= 50) 
	        		emote.addFrame(1, CRY8);
	        	if (r >= 51 && r <= 100) 
	        		emote.addFrame(1, CRY9);
	        	if (r >= 101 && r <= 150) 
	        		emote.addFrame(1, CRY10);
	        	if (r >= 151 && r <= 200) 
	        		emote.addFrame(1, CRY11);
			}
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			int r = new Random().nextInt((200 - 16) + 1) + 16;
			loc.add(0D, -0.1D, 0D);
			Vector v = new Vector(.2, 0, 0);
            VectorUtils.rotateAroundAxisY(v, -(loc.getYaw() + 90) * MathUtils.degreesToRadians);
			if ((time >= 50 && time < 200) && (r <= 100)) ParticleEffect.WATER_SPLASH.display(0.1f, 0.1f, 0.1f, 0, 1, loc.add(v), 32D);
		}
	},
	DIZZY(			5, "dizzy") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(5, DIZZY1);
			emote.addFrame(5, DIZZY2);
			emote.addFrame(5, DIZZY3);
			emote.addFrame(5, DIZZY4);
			emote.addFrame(5, DIZZY5);
			for (int i = 1; i <= 4; i++) {
				emote.addFrame(5, DIZZY2);
				emote.addFrame(5, DIZZY3);
				emote.addFrame(5, DIZZY4);
				emote.addFrame(5, DIZZY5);
			}
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	FROWN(			6, "frown") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(10, FROWN1);
			emote.addFrame(10, FROWN2);
			emote.addFrame(20, FROWN3);
			emote.addFrame(5, FROWN4);
			emote.addFrame(5, FROWN5);
			emote.addFrame(5, FROWN6);
			emote.addFrame(5, FROWN7);
			emote.addFrame(5, FROWN6);
			emote.addFrame(5, FROWN5);
			emote.addFrame(5, FROWN4);
			emote.addFrame(5, FROWN5);
			emote.addFrame(5, FROWN6);
			emote.addFrame(5, FROWN7);
			emote.addFrame(5, FROWN8);
			emote.addFrame(5, FROWN7);
			emote.addFrame(5, FROWN6);
			emote.addFrame(5, FROWN5);
			emote.addFrame(5, FROWN4);
			emote.addFrame(5, FROWN5);
			emote.addFrame(5, FROWN6);
			emote.addFrame(5, FROWN7);
			emote.addFrame(5, FROWN6);
			emote.addFrame(5, FROWN5);
			emote.addFrame(5, FROWN4);
			emote.addFrame(5, FROWN5);
			emote.addFrame(5, FROWN6);
			emote.addFrame(5, FROWN7);
			emote.addFrame(5, FROWN8);
			emote.addFrame(5, FROWN7);
			emote.addFrame(5, FROWN6);
			emote.addFrame(5, FROWN5);
			emote.addFrame(5, FROWN4);
			emote.addFrame(5, FROWN5);
			emote.addFrame(5, FROWN6);
			emote.addFrame(5, FROWN7);
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	GOOFY(			7, "goofy") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			for (int i = 1; i <= 3; i++) {
				emote.addFrame(5, GOOFY1);
				emote.addFrame(5, GOOFY2);
				emote.addFrame(5, GOOFY3);
				emote.addFrame(5, GOOFY4);
				emote.addFrame(5, GOOFY3);
				emote.addFrame(5, GOOFY2);
			}
			emote.addFrame(5, GOOFY1);
			emote.addFrame(5, GOOFY2);
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	GRIN(			8, "grin") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(10, GRIN1);
			emote.addFrame(10, GRIN2);
			emote.addFrame(10, GRIN3);
			emote.addFrame(70, GRIN4);
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	LOVE_STRUCK(	9, "love struck") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			for (int i = 1; i <= 5; i++) {
				emote.addFrame(10, LOVESTRUCK1);
				emote.addFrame(2, LOVESTRUCK2);
				emote.addFrame(2, LOVESTRUCK3);
				emote.addFrame(2, LOVESTRUCK4);
				emote.addFrame(2, LOVESTRUCK3);
				emote.addFrame(2, LOVESTRUCK2);
			}
			emote.addFrame(5, LOVESTRUCK1);
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	LOVEY(			10, "lovey") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(10, LOVE1);
			emote.addFrame(10, LOVE2);
			emote.addFrame(5, LOVE3);
			for (int i = 1; i <= 8; i++) {
				emote.addFrame(5, LOVE4);
				emote.addFrame(5, LOVE5);
				emote.addFrame(5, LOVE6);
				emote.addFrame(5, LOVE7);
			}
			emote.addFrame(5, LOVE4);
			emote.addFrame(5, LOVE5);
			emote.addFrame(5, LOVE6);
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	RAGE(			11, "rage") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(5, RAGE1);
			emote.addFrame(5, RAGE2);
			emote.addFrame(5, RAGE3);
			emote.addFrame(5, RAGE4);
			int r;
			for (int i = 1; i <= 180; i++) {
	        	r = new Random().nextInt((200) + 1);
	        	if (r <= 100) 
	        		emote.addFrame(1, RAGE5);
	        	if (r >= 101 && r <= 150) 
	        		emote.addFrame(1, RAGE6);
	        	if (r >= 151 && r <= 200) 
	        		emote.addFrame(1, RAGE7);
			}
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			int r = new Random().nextInt((200) + 1);
			loc.add(0D, 0.3D, 0D);
			if (r <= 50) ParticleEffect.VILLAGER_ANGRY.display(0.2f, 0.2f, 0.2f, 0, 1, loc, 32D);
		}
	},
	RELAX(			12, "relax") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(8, RELAX1);
			emote.addFrame(7, RELAX2);
			emote.addFrame(25, RELAX3);
			emote.addFrame(10, RELAX4);
			emote.addFrame(5, RELAX5);
			for (int i = 1; i <= 3; i++) {
				emote.addFrame(15, RELAX6);
				emote.addFrame(15, RELAX7);
			}
			emote.addFrame(10, RELAX1);
			emote.addFrame(10, RELAX2);
			emote.addFrame(10, RELAX3);
			emote.addFrame(10, RELAX4);
			emote.addFrame(20, RELAX5);
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	RIP(			13, "rip") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(5, RIP1);
			emote.addFrame(5, RIP2);
			emote.addFrame(5, RIP3);
			emote.addFrame(5, RIP4);
			emote.addFrame(5, RIP5);
			emote.addFrame(5, RIP6);
			emote.addFrame(70, RIP7);
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	SLEEPY(			14, "sleepy") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(8, SLEEPY1);
			emote.addFrame(8, SLEEPY2);
			emote.addFrame(4, SLEEPY3);
			emote.addFrame(10, SLEEPY4);
			emote.addFrame(5, SLEEPY5);
			emote.addFrame(10, SLEEPY6);
			emote.addFrame(10, SLEEPY7);
			emote.addFrame(25, SLEEPY8);
			emote.addFrame(20, SLEEPY9);
			for (int i = 1; i <= 4; i++) {
				emote.addFrame(30, SLEEPY8);
				emote.addFrame(20, SLEEPY9);
			}
			emote.addFrame(5, SLEEPY8);
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	SMILE(			15, "smile") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(20, SkullEffectsLib.SMILE1);
			emote.addFrame(20, SkullEffectsLib.SMILE2);
			emote.addFrame(20, SkullEffectsLib.SMILE3);
			emote.addFrame(40, SkullEffectsLib.SMILE);
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	SPICY(			16, "spicy") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(5, SPICY1);
			emote.addFrame(5, SPICY2);
			emote.addFrame(5, SPICY3);
			emote.addFrame(5, SPICY4);
			emote.addFrame(5, SPICY5);
			emote.addFrame(5, SPICY6);
			emote.addFrame(5, SPICY7);
			for (int i = 1; i <= 35; i++) {
				emote.addFrame(2, SPICY8);
				emote.addFrame(2, SPICY9);
			}
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	SURPRISED(		17, "surprised") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(10, SURPRISED1);
			emote.addFrame(10, SURPRISED2);
			emote.addFrame(10, SURPRISED3);
			emote.addFrame(70, SURPRISED4);
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	TAN(			18, "tan") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(5, TAN1);
			emote.addFrame(5, TAN2);
			emote.addFrame(10, TAN3);
			emote.addFrame(15, TAN4);
			emote.addFrame(5, TAN3);
			emote.addFrame(10, TAN2);
			emote.addFrame(15, TAN5);
			emote.addFrame(15, TAN6);
			emote.addFrame(10, TAN7);
			emote.addFrame(10, TAN8);
			emote.addFrame(15, TAN9);
			for (int i = 1; i <= 3; i++) {
				emote.addFrame(5, TAN10);
				emote.addFrame(10, TAN11);
			}
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	TOO_COOL(		19, "too cool") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(5, TOOCOOL1);
			emote.addFrame(5, TOOCOOL2);
			emote.addFrame(5, TOOCOOL3);
			emote.addFrame(5, TOOCOOL4);
			emote.addFrame(5, TOOCOOL5);
			emote.addFrame(5, TOOCOOL6);
			emote.addFrame(10, TOOCOOL7);
			emote.addFrame(5, TOOCOOL8);
			emote.addFrame(5, TOOCOOL9);
			emote.addFrame(50, TOOCOOL10);
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	WINK(			20, "wink") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(10, WINK1);
			emote.addFrame(10, WINK2);
			emote.addFrame(20, WINK3);
			emote.addFrame(5, WINK4);
			emote.addFrame(5, WINK3);
			emote.addFrame(5, WINK4);
			emote.addFrame(10, WINK3);
			emote.addFrame(5, WINK4);
			emote.addFrame(5, WINK3);
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	ORC_BLINK(		21, "orc blink") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(10, ORC_BLINK1);
			emote.addFrame(10, ORC_BLINK2);
			emote.addFrame(20, ORC_BLINK1);
			emote.addFrame(5, ORC_BLINK2);
			emote.addFrame(10, ORC_BLINK1);
			emote.addFrame(5, ORC_BLINK2);
			emote.addFrame(20, ORC_BLINK1);
			emote.addFrame(5, ORC_BLINK2);
			emote.addFrame(5, ORC_BLINK1);
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	SANTA_BLINK(	22, "santa blink") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(10, SANTA_BLINK1);
			emote.addFrame(10, SANTA_BLINK2);
			emote.addFrame(20, SANTA_BLINK1);
			emote.addFrame(5, SANTA_BLINK2);
			emote.addFrame(10, SANTA_BLINK1);
			emote.addFrame(5, SANTA_BLINK2);
			emote.addFrame(20, SANTA_BLINK1);
			emote.addFrame(5, SANTA_BLINK2);
			emote.addFrame(5, SANTA_BLINK1);
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	SANTA_LOOK(		23, "santa look") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			for (int i = 1; i <= 5; i++) {
				emote.addFrame(10, SANTA_LOOK1);
				emote.addFrame(10, SANTA_LOOK2);
				emote.addFrame(10, SANTA_LOOK1);
				emote.addFrame(10, SANTA_LOOK3);
			}
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	SANTA_WINK(		24, "santa wink") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			for (int i = 1; i <= 5; i++) {
				emote.addFrame(20, SANTA_WINK1);
				emote.addFrame(5, SANTA_WINK2);
			}
			emote.addFrame(5, SANTA_WINK1);
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	XMAS_TREE(		25, "xmas tree") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			for (int i = 1; i <= 5; i++) {
				emote.addFrame(10, XMAS_TREE1);
				emote.addFrame(10, XMAS_TREE2);
				emote.addFrame(10, XMAS_TREE3);
				emote.addFrame(10, XMAS_TREE4);
			}
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			// TODO Auto-generated method stub
			
		}
	},
	PUMPKIN_EXPLODE(		25, "pumpkin explode") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(15, PUMPKIN_EXPLODE1);
			emote.addFrame(13, PUMPKIN_EXPLODE2);
			emote.addFrame(13, PUMPKIN_EXPLODE3);
			emote.addFrame(12, PUMPKIN_EXPLODE4);
			emote.addFrame(20, PUMPKIN_EXPLODE5);
			emote.addFrame(10, PUMPKIN_EXPLODE6);
			for (int i = 1; i <= 3; i++) {
				emote.addFrame(5, PUMPKIN_EXPLODE7);
				emote.addFrame(5, PUMPKIN_EXPLODE8);
			}
			emote.addFrame(5, PUMPKIN_EXPLODE9);
			emote.addFrame(5, PUMPKIN_EXPLODE10);
			for (int i = 1; i <= 20; i++) {
				emote.addFrame(2, PUMPKIN_EXPLODE11);
				emote.addFrame(2, PUMPKIN_EXPLODE12);
			}
			emote.addFrame(20, PUMPKIN_EXPLODE13);
			
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			int r = new Random().nextInt((200 - 16) + 1) + 16;
			loc.add(0D, 0.7D, 0D);
			if ((frame >= 13 && frame <= 54) && (r <= 100)) ParticleEffect.SMOKE_LARGE.display(0.1f, 0.1f, 0.1f, 0, 1, loc, 32D);
			if ((frame >= 54) && (r <= 70)) ParticleEffect.EXPLOSION_NORMAL.display(0.3f, 0.2f, 0.3f, 0, 1, loc, 32D);
		}
	},
	PUMPKIN_PUKE(		25, "pumpkin puke") {
		public CustomEmote initEmote() {
			CustomEmote emote = new CustomEmote(getName());
			emote.addFrame(15, PUMPKIN_PUKE1);
			emote.addFrame(13, PUMPKIN_PUKE2);
			emote.addFrame(13, PUMPKIN_PUKE3);
			for (int i = 1; i <= 3; i++) {
				emote.addFrame(5, PUMPKIN_PUKE4);
				emote.addFrame(5, PUMPKIN_PUKE5);
			}
			emote.addFrame(10, PUMPKIN_PUKE4);
			emote.addFrame(10, PUMPKIN_PUKE6);
			emote.addFrame(12, PUMPKIN_PUKE7);
			emote.addFrame(20, PUMPKIN_PUKE8);
			emote.addFrame(5, PUMPKIN_PUKE9);
			emote.addFrame(5, PUMPKIN_PUKE10);
			for (int i = 1; i <= 20; i++) {
				emote.addFrame(2, PUMPKIN_PUKE10);
				emote.addFrame(2, PUMPKIN_PUKE11);
			}
			return emote;
		}

		@Override
		public void playParticle(int time, int frame, Location loc) {
			int r = new Random().nextInt((200 - 16) + 1) + 16;
			loc.add(0D, -0.2D, 0D);
			Vector v = new Vector(.3, 0, 0);
            VectorUtils.rotateAroundAxisY(v, -(loc.getYaw() + 90) * MathUtils.degreesToRadians);
			if ((frame >= 14) && (r <= 100)) ParticleEffect.FALLING_DUST.display(new BlockData(Material.SANDSTONE, (byte) 0), 0.02f, 0f, 0.02f, 0.005f, 1, loc.add(v), 32D);
			//Material.valueOf("WOOL") != null ? Material.valueOf("WOOL") : Material.valueOf("WOOL");
			
			if ((frame >= 14) && (r >= 100)) {
				BlockData data = null;
				try {
					data = new BlockData(Material.valueOf("WOOL"), (byte) 1);
		        } catch (IllegalArgumentException ex) {
		        	data = new BlockData(Material.valueOf("ORANGE_WOOL"));
		        }
				ParticleEffect.FALLING_DUST.display(data, 0.02f, 0f, 0.02f, 0.005f, 1, loc.add(v), 32D);
			}
		}
	};
	
	/**
	 * Returns a CustomEmote of said type
	 */
	public abstract CustomEmote initEmote();
	
	/**
	 * Plays particles if that emote has one
	 */
	public abstract void playParticle(int time, int frame, Location loc);
	
	public static final Map<Integer, EmoteType> ID_MAP = new HashMap<Integer, EmoteType>();
	public static final Map<String, EmoteType> NAME_MAP = new HashMap<String, EmoteType>();
	private final Integer id;
	private final String name;

	static {
		for (EmoteType effect : values()) {
			ID_MAP.put(effect.id, effect);
			NAME_MAP.put(effect.name, effect);
		}
	}
	
	private EmoteType(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * Returns the name of an effect type
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the id of an effect type
	 * 
	 * @return The id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Returns the effect type from a given id
	 * 
	 * @param id Id of the effect type
	 * @return The effect type
	 */
	public static EmoteType fromId(Integer id) {
		for (Entry<Integer, EmoteType> entry : ID_MAP.entrySet()) {
			if (entry.getKey() != id) {
				continue;
			}
			return entry.getValue();
		}
		return null;
	}
	
	/**
	 * Returns the effect type from a given name
	 * 
	 * @param name Name of the effect type
	 * @return The effect type
	 */
	public static EmoteType fromName(String name) {
		for (Entry<String, EmoteType> entry : NAME_MAP.entrySet()) {
			if (!entry.getKey().equalsIgnoreCase(name)) {
				continue;
			}
			return entry.getValue();
		}
		return null;
	}
}
