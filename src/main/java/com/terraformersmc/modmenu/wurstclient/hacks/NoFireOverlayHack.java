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
import com.terraformersmc.modmenu.wurstclient.hack.Hack;
import com.terraformersmc.modmenu.wurstclient.settings.SliderSetting;
import com.terraformersmc.modmenu.wurstclient.settings.SliderSetting.ValueDisplay;

@SearchTags({"no fire overlay"})
public final class NoFireOverlayHack extends Hack
{
	private final SliderSetting offset =
		new SliderSetting("Offset", "The amount to lower the fire overlay by.",
			0.6, 0.01, 0.6, 0.01, ValueDisplay.DECIMAL);
	
	public NoFireOverlayHack()
	{
		super("NoFireOverlay");
		setCategory(Category.RENDER);
		addSetting(offset);
	}
	
	public float getOverlayOffset()
	{
		return isEnabled() ? offset.getValueF() : 0;
	}
	
	// See InGameOverlayRendererMixin.getFireOffset()
}
