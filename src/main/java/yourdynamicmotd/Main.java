package yourdynamicmotd;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.scheduler.Task;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import yourdynamicmotd.task.MotdTask;

public class Main extends PluginBase {
  public List<String> list;
  public Config config;

  public void onEnable() {
    this.getLogger().info(TextFormat.colorize((String) "&aDynamic motd loaded :D"));
    if (!this.getDataFolder().exists()) {
      this.getDataFolder().mkdirs();
      this.config = new Config(new File(this.getDataFolder() + "/config.yml"), 2,
          (LinkedHashMap<String, Object>) new LinkedHashMap<String, Object>() {
            {
              this.put("motd-type", new ArrayList<String>() {
                {
                  this.add("Your dynamic motd 1");
                  this.add("Your dynamic motd 2");
                  this.add("Your dynamic motd 3");
                }
              });
              this.put("time-update", 3);
            }

          });
    } else {
      this.config = new Config(new File(this.getDataFolder() + "/config.yml"), 2,
          (LinkedHashMap<String, Object>) new LinkedHashMap<String, Object>() {
            {
              this.put("motd-type", new ArrayList<String>() {
                {
                  this.add("Your dynamic motd 1");
                  this.add("Your dynamic motd 2");
                  this.add("Your dynamic motd 3");
                }
              });
              this.put("time-update", 3);
            }

          });
    }
    int time = (Integer) this.config.getNestedAs("time-update", Integer.TYPE);
    this.getServer().getScheduler().scheduleRepeatingTask((Task) new MotdTask(this), time * 20);
  }

  /**
   * This method will change the server motd
   * 
   * @param String motd
   */
  public void setMotd(String motd) {
    this.getServer().getNetwork().setName(motd);
  }

}

