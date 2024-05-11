/*
 * Copyright (c) 2014-2024 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package com.terraformersmc.modmenu.wurstclient.other_features;

import com.terraformersmc.modmenu.wurstclient.DontBlock;
import com.terraformersmc.modmenu.wurstclient.SearchTags;
import com.terraformersmc.modmenu.wurstclient.other_feature.OtherFeature;

@SearchTags({"Server Finder"})
@DontBlock
public final class ServerFinderOtf extends OtherFeature
{
	public ServerFinderOtf()
	{
		super("ServerFinder",
			"Allows you to find easy-to-grief Minecraft servers quickly and easily. To use it, press the 'Server Finder' button on the server selection screen.");
	}
}
