package io.github.JustinBerke0406.morecommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdExecutor implements CommandExecutor
{
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	{
		//Makesay command
		if (cmd.getName().equalsIgnoreCase("makesay"))
		{
			//Declares say (not initialized to save memory)
			String say;
			
			//Is command long enough
			if (args.length < 2)
			{
				return false;
			}
			
			//Checks if sender has permissions
			if (!sender.isOp())
			{
				sender.sendMessage(ChatColor.RED + "You must be an operator to use this command!");
				
				return true;
			}
			
			//Gets victim
			Player vic = Bukkit.getPlayerExact(args[1]);
			
			//Checks if vic is online
			if (vic == null)
			{
				sender.sendMessage(ChatColor.GREEN + args[1] + ChatColor.GOLD + " is not online!");
				
				return true;
			}
			
			//Checks if vic is sender
			if (((Player)sender).equals(vic))
			{
				sender.sendMessage(ChatColor.RED + "You cannot use this command on yourself!");
			}
			
			//Initializes say
			say = "";
			
			//Gets string to say
			for (int i = 1; i < args.length; i++)
			{
				say += args[i] + " ";
			}
			
			//Makes vic say string
			vic.chat(say);
			
			return true;
		}
		
		return false;
	}
}
