package red.jad.jads.potions;

import net.minecraft.entity.EntityLivingBase;
import red.jad.jads.features.FeaturesDamageSources;

public class Potion5G extends PotionGeneric {

	public Potion5G() {
		super("5g", true, 12316189, 0, 0);
	}
    
    @Override
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
    	if ((entityLivingBaseIn.getActivePotionEffect(this).getDuration() / 20) % 10 == 0){
			entityLivingBaseIn.attackEntityFrom(FeaturesDamageSources.DAMAGE_5G, 0.5F);
		}
    	
    	super.performEffect(entityLivingBaseIn, amplifier);
    }
    
    @Override
    public boolean isReady(int duration, int amplifier) {
    	return true;
    }
    
    @Override
    public boolean isInstant(){
        return false;
    }
}
