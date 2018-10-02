/*
 * Decompiled with CFR 0_132.
 * 
 * Could not load the following classes:
 *  cn.nukkit.Server
 *  cn.nukkit.plugin.PluginBase
 *  cn.nukkit.plugin.PluginLogger
 *  cn.nukkit.scheduler.ServerScheduler
 *  cn.nukkit.scheduler.Task
 *  cn.nukkit.scheduler.TaskHandler
 *  cn.nukkit.utils.Config
 *  cn.nukkit.utils.TextFormat
 */
package yourdynamicmotd;

import cn.nukkit.Server;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginLogger;
import cn.nukkit.scheduler.ServerScheduler;
import cn.nukkit.scheduler.Task;
import cn.nukkit.scheduler.TaskHandler;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import yourdynamicmotd.task.MotdTask;

public class Main
extends PluginBase {
    public List<String> list;
    public Config config;

    public void onEnable() {
        this.getLogger().info(TextFormat.colorize((String)"&aDynamic motd loaded :D"));
        if (!this.getDataFolder().exists()) {
            this.getDataFolder().mkdirs();
            this.config = new Config(new File(this.getDataFolder() + "/config.yml"), 2, (LinkedHashMap)new LinkedHashMap<String, Object>(){
                {
                    this.put("motd-type", new ArrayList<String>(){
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
            this.config = new Config(new File(this.getDataFolder() + "/config.yml"), 2, (LinkedHashMap)new LinkedHashMap<String, Object>(){
                {
                    this.put("motd-type", new ArrayList<String>(){
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
        int time = (Integer)this.config.getNestedAs("time-update", Integer.TYPE);
        this.getServer().getScheduler().scheduleRepeatingTask((Task)new MotdTask(this), time * 20);
    }

}

