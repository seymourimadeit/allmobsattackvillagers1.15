package tallestegg.allmobsattackvillagers;

import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventManager 
{
	@SubscribeEvent
	public static void onLivingSpawned(EntityJoinWorldEvent event) 
	{
		
	if(event.getEntity() instanceof MonsterEntity) 
	{
		MonsterEntity monster = (MonsterEntity)event.getEntity();
	    monster.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(monster, AbstractVillagerEntity.class, false));
	    
	}
}

}