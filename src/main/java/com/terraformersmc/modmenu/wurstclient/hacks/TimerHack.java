/*
 * Copyright (c) 2014-2024 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package com.terraformersmc.modmenu.wurstclient.hacks;

import com.terraformersmc.modmenu.wurstclient.Category;
import com.terraformersmc.modmenu.wurstclient.hack.Hack;
import com.terraformersmc.modmenu.wurstclient.settings.SliderSetting;
import com.terraformersmc.modmenu.wurstclient.settings.SliderSetting.ValueDisplay;

public final class TimerHack extends Hack
{
	private final SliderSetting speed =
		new SliderSetting("Speed", 2, 0.1, 20, 0.1, ValueDisplay.DECIMAL);
	
	public TimerHack()
	{
		super("Timer");
		setCategory(Category.OTHER);
		addSetting(speed);
	}
	
	@Override
	public String getRenderName()
	{
		return getName() + " [" + speed.getValueString() + "]";
	}
	
	public float getTimerSpeed()
	{
		return isEnabled() ? speed.getValueF() : 1;
	}
}
