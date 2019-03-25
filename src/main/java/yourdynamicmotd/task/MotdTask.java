package yourdynamicmotd.task;

import cn.nukkit.scheduler.PluginTask;
import cn.nukkit.utils.TextFormat;
import yourdynamicmotd.Main;

import java.util.ArrayList;
import java.util.Random;

public class MotdTask
        extends PluginTask<Main> {
    public MotdTask(Main owner) {
        super((Main) owner);
    }

    public void onRun(int ticks) {
        ArrayList name = (ArrayList) ((Main) this.getOwner()).config.get("motd-type");
        int max = name.size();
        Random rand = new Random();
        int motd = rand.nextInt(max);
        ((Main) this.getOwner()).getServer().getNetwork().setName(TextFormat.colorize((String) ((String) name.get(motd)).toString()));
    }
}

