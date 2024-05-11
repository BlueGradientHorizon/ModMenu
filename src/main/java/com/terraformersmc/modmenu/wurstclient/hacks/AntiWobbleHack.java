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

@SearchTags({"anti wobble", "NoWobble", "no wobble", "AntiNausea",
	"anti nausea", "NoNausea", "no nausea"})
public final class AntiWobbleHack extends Hack
{
	public AntiWobbleHack()
	{
		super("AntiWobble");
		setCategory(Category.RENDER);
	}
	
	// See GameRendererMixin.wurstNauseaLerp()
}
