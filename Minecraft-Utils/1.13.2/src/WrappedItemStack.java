import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import eu.the5zig.mod.MinecraftFactory;
import eu.the5zig.mod.gui.ingame.ItemStack;
import eu.the5zig.mod.util.GLUtil;
import eu.the5zig.util.minecraft.ChatColor;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 5zig.
 * All rights reserved © 2015
 */
public class WrappedItemStack implements ItemStack {

	private static final UUID ITEM_MODIFIER_UUID = UUID.fromString("cb3f55d3-645c-4f38-a497-9c13a33db5cf");

	private ate item;

	public WrappedItemStack(ate item) {
		this.item = item;
	}

	@Override
	public int getAmount() {
		return item.C();
	}

	@Override
	public int getMaxDurability() {
		return item.h();
	}

	@Override
	public int getCurrentDurability() {
		return item.g();
	}

	@Override
	public String getKey() {
		return getResourceKey(item);
	}

	@Override
	public String getDisplayName() {
		return item.q().d();
	}

	@Override
	public List<String> getLore() {
		List<String> result = Lists.newArrayList();
		for (ij chatComponent : item.a(((Variables) MinecraftFactory.getVars()).getPlayer(), aum.a.a)) {
			result.add(chatComponent.getString());
		}
		return result;
	}

	@Override
	public int getHealAmount() {
		return item.b() instanceof asz ? ((asr) item.b()).c(item) : 0;
	}

	@Override
	public float getSaturationModifier() {
		return item.b() instanceof asr ? ((asr) item.b()).c(item) : 0;
	}

	@Override
	public void render(int x, int y, boolean withGenericAttributes) {
		if (item == null)
			return;
		((Variables) MinecraftFactory.getVars()).renderItem(item, x, y);

		if (withGenericAttributes) {
			for (aew modifier : aew.values()) {
				Multimap<String, afo> multimap = item.a(modifier);
				for (Map.Entry<String, afo> entry : multimap.entries()) {
					afo attribute = entry.getValue();
					double value = attribute.d();
					if (ITEM_MODIFIER_UUID.equals(attribute.a())) {
						if (((Variables) MinecraftFactory.getVars()).getPlayer() == null) {
							value += 1;
							value += (double) awg.a(item, afd.a);
						} else {
							//find the right method for ank.*
							value += ((Variables) MinecraftFactory.getVars()).getPlayer().a(ank.f).b();
							value += (double) awg.a(item, afd.a);
						}
					}
					if (entry.getKey().equals("generic.attackDamage") || entry.getKey().equals("generic.armor")) {
						GLUtil.disableDepth();
						GLUtil.pushMatrix();
						GLUtil.translate(x + 8, y + 10, 1);
						GLUtil.scale(0.7f, 0.7f, 0.7f);
						MinecraftFactory.getVars().drawString(ChatColor.BLUE + "+" + Math.round(value), 0, 0);
						GLUtil.popMatrix();
						GLUtil.enableDepth();
					}
				}
			}
		}
	}

	public static String getResourceKey(ate item) {
		pc resourceLocation = ata.f(item.b());
		return resourceLocation == null ? null : resourceLocation.toString();
	}
}
