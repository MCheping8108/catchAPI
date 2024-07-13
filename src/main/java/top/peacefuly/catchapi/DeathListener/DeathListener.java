package top.peacefuly.catchapi.DeathListener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import top.peacefuly.catchapi.CatchAPI;

public class DeathListener implements Listener {
    private final CatchAPI catchAPI;
    public DeathListener(CatchAPI catchAPI) {
        this.catchAPI = catchAPI;
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player player = e.getEntity();
        e.setKeepInventory(true);
        e.setDeathMessage("§b "+ player.getName() + " died!");
    }
}
