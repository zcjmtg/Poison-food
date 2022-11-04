
package com.hpnhcpn.poisonfood.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import com.hpnhcpn.poisonfood.item.PoisonitemItem;
import com.hpnhcpn.poisonfood.PoisonFoodModElements;

@PoisonFoodModElements.ModElement.Tag
public class PosionfoodItemGroup extends PoisonFoodModElements.ModElement {
	public PosionfoodItemGroup(PoisonFoodModElements instance) {
		super(instance, 40);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabposionfood") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(PoisonitemItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;
}
