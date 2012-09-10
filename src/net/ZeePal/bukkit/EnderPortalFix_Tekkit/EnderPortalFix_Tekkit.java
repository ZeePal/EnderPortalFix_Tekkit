/*********************************************************************************
 *  The EnderPortalFix_Tekkit plugin for Bukkit fixes a problem with teleporting to the End in Tekkit 3.1
 *	Copyright (C) 2012  ZeePal
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
*********************************************************************************/

package net.ZeePal.bukkit.EnderPortalFix_Tekkit;

import net.ZeePal.bukkit.EnderPortalFix_Tekkit.listeners.PlayerTeleportListener;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class EnderPortalFix_Tekkit extends JavaPlugin {
	
	public void onEnable() {
		getLogger().info("onEnabled has been invoked!");
		FileConfiguration config = getConfig();
		config.options().copyDefaults(true);
		saveConfig();
		getServer().getPluginManager().registerEvents(new PlayerTeleportListener(config.getDouble("x"), config.getDouble("y"), config.getDouble("z")), this);
	}
	
	public void onDisable() {
		getLogger().info("onDisable has been invoked!");
		HandlerList.unregisterAll(this);
	}

}
