package yourdynamicmotd.task;

import java.util.ArrayList;
import java.util.Random;
import cn.nukkit.scheduler.PluginTask;
import yourdynamicmotd.Main;

public class MotdTask extends PluginTask<Main> {

  public MotdTask(Main owner) {
    super(owner);
  }

  public void onRun(int ticks) {
    ArrayList<String> name = new ArrayList<String>();
    name = (ArrayList<String>) ((Main) this.getOwner()).config.get("motd-type");
    if (name == null) {
      name.add("This is a nukkit server.");
    }
    int max = name.size();
    Random rand = new Random();
    int motd = rand.nextInt(max);
    this.owner.setMotd(name.get(motd));
    this.owner.getLogger().debug(this.owner.getServer().getNetwork().getName()); // debug
  }
}

