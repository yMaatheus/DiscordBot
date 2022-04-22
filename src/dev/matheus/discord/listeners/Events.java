package dev.matheus.discord.listeners;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.EventListener;

public class Events implements EventListener { 
	
	@Override
	public void onEvent(Event event) {
		if (event instanceof ReadyEvent) {
			event.getJDA().getTextChannelById("605408371851657241").sendMessage("Olá, voltei").complete();
			System.out.println("INFO: API is ready!");
			
			String servers = "INFO: Este bot está sendo usado nos servidores:\n";
			
			for (Guild g : event.getJDA().getGuilds()) {
				servers += "\n" + g.getName() + " (" + g.getId() + ")";
			}
			System.out.println(servers);
		}
	}
}