/*
 * Decompiled with CFR 0_132.
 * 
 * Could not load the following classes:
 *  cn.nukkit.Server
 *  cn.nukkit.network.Network
 *  cn.nukkit.plugin.Plugin
 *  cn.nukkit.scheduler.PluginTask
 *  cn.nukkit.utils.Config
 *  cn.nukkit.utils.TextFormat
 */
package yourdynamicmotd.task;

import cn.nukkit.Server;
import cn.nukkit.network.Network;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.scheduler.PluginTask;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import java.util.ArrayList;
import java.util.Random;
import yourdynamicmotd.Main;

public class MotdTask
extends PluginTask<Main> {
    public MotdTask(Main owner) {
        super((Plugin)owner);
    }

    public void onRun(int ticks) {
        ArrayList name = (ArrayList)((Main)this.getOwner()).config.get("motd-type");
        int max = name.size();
        Random rand = new Random();
        int motd = rand.nextInt(max);
        ((Main)this.getOwner()).getServer().getNetwork().setName(TextFormat.colorize((String)((String)name.get(motd)).toString()));
    }
}

