package io.github.JustinBerke0406.morecommands;

import org.bukkit.plugin.java.JavaPlugin;
import io.github.JustinBerke0406.morecommands.Listeners;

public class MoreCommands extends JavaPlugin
{
	public CmdExecutor commandEx = new CmdExecutor();
	
	@Override
	public void onEnable()
	{
		getLogger().info("MoreCommands was enabled successfully!");
		
		//Events
		getServer().getPluginManager().registerEvents(new Listeners(), this);
		
		//Initializes commands
		commands();
	}
	
	@Override
	public void onDisable()
	{
		
	}
	
	public void commands()
	{
		this.getCommand("makesay").setExecutor(commandEx);
	}
}
