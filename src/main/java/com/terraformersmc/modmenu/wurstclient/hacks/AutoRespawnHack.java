/*
 * Copyright (c) 2014-2024 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package com.terraformersmc.modmenu.wurstclient.hacks;

import com.terraformersmc.modmenu.wurstclient.Category;
import com.terraformersmc.modmenu.wurstclient.SearchTags;
import com.terraformersmc.modmenu.wurstclient.WurstClient;
import com.terraformersmc.modmenu.wurstclient.events.DeathListener;
import com.terraformersmc.modmenu.wurstclient.hack.Hack;
import com.terraformersmc.modmenu.wurstclient.settings.CheckboxSetting;

@SearchTags({"auto respawn", "AutoRevive", "auto revive"})
public final class AutoRespawnHack extends Hack implements DeathListener
{
	private final CheckboxSetting button =
		new CheckboxSetting("Death screen button", "Shows a button on the death"
			+ " screen that lets you quickly enable AutoRespawn.", true);
	
	public AutoRespawnHack()
	{
		super("AutoRespawn");
		setCategory(Category.COMBAT);
		addSetting(button);
	}
	
	@Override
	protected void onEnable()
	{
		EVENTS.add(DeathListener.class, this);
	}
	
	@Override
	protected void onDisable()
	{
		EVENTS.remove(DeathListener.class, this);
	}
	
	@Override
	public void onDeath()
	{
		MC.player.requestRespawn();
		MC.setScreen(null);
	}
	
	public boolean shouldShowButton()
	{
		return WurstClient.INSTANCE.isEnabled() && !isEnabled()
			&& button.isChecked();
	}
}
