package lubdan.nofish;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.plugin.java.JavaPlugin;



public final class NoFish extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(this,this);
    }

    @EventHandler
    private void onFish(PlayerFishEvent event){
        if(getConfig().getList("Disabled-Worlds").contains(event.getPlayer().getWorld().getName()) && !event.getPlayer().hasPermission("NoFish.bypass")){
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',getConfig().getString("Message")));
            event.setCancelled(true);
        }
    }


    @EventHandler
    private void onDeath(PlayerDeathEvent event){
        System.out.println(event.getDeathMessage());
    }

}
