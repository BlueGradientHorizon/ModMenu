/*
 * Copyright (c) 2014-2024 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package com.terraformersmc.modmenu.wurstclient.events;

import java.util.ArrayList;

import net.minecraft.block.entity.BlockEntity;
import com.terraformersmc.modmenu.wurstclient.event.CancellableEvent;
import com.terraformersmc.modmenu.wurstclient.event.Listener;

public interface RenderBlockEntityListener extends Listener
{
	public void onRenderBlockEntity(RenderBlockEntityEvent event);
	
	public static class RenderBlockEntityEvent
		extends CancellableEvent<RenderBlockEntityListener>
	{
		private final BlockEntity blockEntity;
		
		public RenderBlockEntityEvent(BlockEntity blockEntity)
		{
			this.blockEntity = blockEntity;
		}
		
		public BlockEntity getBlockEntity()
		{
			return blockEntity;
		}
		
		@Override
		public void fire(ArrayList<RenderBlockEntityListener> listeners)
		{
			for(RenderBlockEntityListener listener : listeners)
			{
				listener.onRenderBlockEntity(this);
				
				if(isCancelled())
					break;
			}
		}
		
		@Override
		public Class<RenderBlockEntityListener> getListenerType()
		{
			return RenderBlockEntityListener.class;
		}
	}
}
