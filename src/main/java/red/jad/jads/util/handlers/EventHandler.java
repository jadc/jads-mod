package red.jad.jads.util.handlers;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import red.jad.jads.features.Features;
import red.jad.jads.util.Shorthands;

public class EventHandler {

	/*
	 * Foil Hat Functionality
	 */
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent e) {
		if(!e.player.world.isRemote) {
			if( e.player.inventory.armorItemInSlot(3) != null ) {
				if(e.player.inventory.armorItemInSlot(3).getItem() == Features.FOIL_HAT) {
					ItemStack foilhat = e.player.inventory.armorItemInSlot(3);
					for(PotionEffect p : e.player.getActivePotionEffects()) {
						if(p.getPotion().isBadEffect()) {
							e.player.removePotionEffect(p.getPotion());
							if(Shorthands.randomChance()) {
								foilhat.attemptDamageItem(1, new Random(), (EntityPlayerMP) e.player);
							}
						}
					}
				}
			}
			
			
		}
	}
	
	/*
	 * Death noise
	 */
	@SubscribeEvent
	public void onPlayerDeath(LivingDeathEvent e) {
		if(e.getEntity() instanceof EntityPlayerMP) {
			EntityPlayerMP p = (EntityPlayerMP) e.getEntity();
			if(!p.world.isRemote) {
				p.playSound(SoundsHandler.HEV_FLATLINE, 1.0F, 1.0F);
			}
		}
	}
}
