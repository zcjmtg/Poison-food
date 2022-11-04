
package com.hpnhcpn.poisonfood.village;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicTrade;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.block.Blocks;

import java.util.List;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

import com.hpnhcpn.poisonfood.item.PoisonitemItem;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PoisontradeTrade {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
		if (event.getType() == VillagerProfession.ARMORER) {
			trades.get(1).add(
					new BasicTrade(new ItemStack(Blocks.GRASS), new ItemStack(Items.SPIDER_EYE), new ItemStack(PoisonitemItem.block), 15, 5, 0f));
		}
	}
}
