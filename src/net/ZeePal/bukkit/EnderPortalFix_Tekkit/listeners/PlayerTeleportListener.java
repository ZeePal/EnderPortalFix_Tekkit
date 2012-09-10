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

package net.ZeePal.bukkit.EnderPortalFix_Tekkit.listeners;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.World.Environment;

public class PlayerTeleportListener implements Listener {
	
	private final double x;
	private final double y;
	private final double z;
	
	public PlayerTeleportListener(final double x, final double y, final double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
	public void onPlayerTeleportEvent(PlayerTeleportEvent event) {
		if (event.getTo().getWorld().getEnvironment() == Environment.THE_END)
			event.setTo(new Location(event.getTo().getWorld(), x, y, z));
	}

}
