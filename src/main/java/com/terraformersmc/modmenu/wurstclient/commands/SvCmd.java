/*
 * Copyright (c) 2014-2024 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package com.terraformersmc.modmenu.wurstclient.commands;

import net.minecraft.client.network.ServerInfo;
import com.terraformersmc.modmenu.wurstclient.command.CmdError;
import com.terraformersmc.modmenu.wurstclient.command.CmdException;
import com.terraformersmc.modmenu.wurstclient.command.CmdSyntaxError;
import com.terraformersmc.modmenu.wurstclient.command.Command;
import com.terraformersmc.modmenu.wurstclient.util.ChatUtils;
import com.terraformersmc.modmenu.wurstclient.util.LastServerRememberer;

public final class SvCmd extends Command
{
	public SvCmd()
	{
		super("sv", "Shows the version of the server\n"
			+ "you are currently connected to.", ".sv");
	}
	
	@Override
	public void call(String[] args) throws CmdException
	{
		if(args.length != 0)
			throw new CmdSyntaxError();
		
		ChatUtils.message("Server version: " + getVersion());
	}
	
	private String getVersion() throws CmdError
	{
		if(MC.isIntegratedServerRunning())
			throw new CmdError("Can't check server version in singleplayer.");
		
		ServerInfo lastServer = LastServerRememberer.getLastServer();
		if(lastServer == null)
			throw new IllegalStateException(
				"LastServerRememberer doesn't remember the last server!");
		
		return lastServer.version.getString();
	}
	
	@Override
	public String getPrimaryAction()
	{
		return "Get Server Version";
	}
	
	@Override
	public void doPrimaryAction()
	{
		WURST.getCmdProcessor().process("sv");
	}
}
