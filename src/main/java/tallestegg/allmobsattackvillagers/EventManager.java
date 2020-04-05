package tallestegg.allmobsattackvillagers;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventManager 
{
	@SubscribeEvent
	public static void onLivingSpawned(EntityJoinWorldEvent event) 
	{
		
	if (event.getEntity() instanceof IMob) 
	{
		MobEntity mob = (MobEntity)event.getEntity();
	    mob.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(mob, AbstractVillagerEntity.class, false));
	    mob.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(mob, IronGolemEntity.class, false));
	}
	
	   if(event.getEntity() instanceof AbstractVillagerEntity) 
	   {
		 AbstractVillagerEntity villager = (AbstractVillagerEntity)event.getEntity();
		 villager.targetSelector.addGoal(3, new AvoidEntityGoal<>(villager, MobEntity.class, 6.0F, 1.0D, 1.2D, (mob) ->
	  		{
	  			return mob instanceof IMob;
	  		}));
	   }
}

}