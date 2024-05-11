/*
 * Copyright (c) 2014-2024 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package com.terraformersmc.modmenu.wurstclient.hacks;

import java.util.Arrays;

import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import com.terraformersmc.modmenu.wurstclient.Category;
import com.terraformersmc.modmenu.wurstclient.SearchTags;
import com.terraformersmc.modmenu.wurstclient.events.UpdateListener;
import com.terraformersmc.modmenu.wurstclient.hack.Hack;
import com.terraformersmc.modmenu.wurstclient.util.BlockBreaker;

@SearchTags({"auto mine", "AutoBreak", "auto break"})
public final class AutoMineHack extends Hack implements UpdateListener
{
	private BlockPos currentBlock;
	
	public AutoMineHack()
	{
		super("AutoMine");
		setCategory(Category.BLOCKS);
	}
	
	@Override
	protected void onEnable()
	{
		WURST.getHax().excavatorHack.setEnabled(false);
		WURST.getHax().nukerHack.setEnabled(false);
		WURST.getHax().nukerLegitHack.setEnabled(false);
		WURST.getHax().speedNukerHack.setEnabled(false);
		WURST.getHax().tunnellerHack.setEnabled(false);
		
		EVENTS.add(UpdateListener.class, this);
	}
	
	@Override
	protected void onDisable()
	{
		EVENTS.remove(UpdateListener.class, this);
		stopMiningAndResetProgress();
	}
	
	@Override
	public void onUpdate()
	{
		setCurrentBlockFromHitResult();
		
		if(currentBlock != null)
			breakCurrentBlock();
	}
	
	private void setCurrentBlockFromHitResult()
	{
		if(MC.crosshairTarget == null || MC.crosshairTarget.getPos() == null
			|| MC.crosshairTarget.getType() != HitResult.Type.BLOCK
			|| !(MC.crosshairTarget instanceof BlockHitResult))
		{
			stopMiningAndResetProgress();
			return;
		}
		
		currentBlock = ((BlockHitResult)MC.crosshairTarget).getBlockPos();
	}
	
	private void breakCurrentBlock()
	{
		if(MC.player.getAbilities().creativeMode)
			BlockBreaker.breakBlocksWithPacketSpam(Arrays.asList(currentBlock));
		else
			BlockBreaker.breakOneBlock(currentBlock);
	}
	
	private void stopMiningAndResetProgress()
	{
		if(currentBlock == null)
			return;
		
		MC.interactionManager.breakingBlock = true;
		MC.interactionManager.cancelBlockBreaking();
		currentBlock = null;
	}
}
