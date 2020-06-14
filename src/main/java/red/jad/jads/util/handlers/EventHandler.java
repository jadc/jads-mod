package red.jad.jads.util.handlers;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import red.jad.jads.features.FeaturesSounds;

public class EventHandler {
	
	/*
	 * Death noise
	 */
	@SubscribeEvent
	public void onPlayerDeath(LivingDeathEvent e) {
		if(e.getEntity() instanceof EntityPlayerMP) {
			e.getEntity().getEntityWorld().playSound(null, e.getEntity().getPosition(), FeaturesSounds.HEV_FLATLINE, SoundCategory.PLAYERS, 1.0F, 1.0F);
		}
	}
}
