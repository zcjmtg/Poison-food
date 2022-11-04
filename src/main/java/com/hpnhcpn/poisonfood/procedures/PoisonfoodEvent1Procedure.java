package com.hpnhcpn.poisonfood.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import com.hpnhcpn.poisonfood.PoisonFoodMod;

public class PoisonfoodEvent1Procedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			Entity entity = event.getPlayer();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", entity.getPosX());
			dependencies.put("y", entity.getPosY());
			dependencies.put("z", entity.getPosZ());
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PoisonFoodMod.LOGGER.warn("Failed to load dependency world for procedure PoisonfoodEvent1!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(new StringTextComponent(
						"\u6B22\u8FCE\u6E38\u73A9\u82B1\u76AE\u9E1F\u548C\u8349\u76AE\u9E1F\u5236\u4F5C\u7684\u6A21\u7EC4\uFF0C\u5FEB\u624B\u53F7\uFF1Ahpnhcpnmc\uFF01"),
						ChatType.SYSTEM, Util.DUMMY_UUID);
		}
	}
}
