package dev.matheus.discord;

import javax.security.auth.login.LoginException;

import dev.matheus.discord.listeners.Events;
import dev.matheus.discord.listeners.MessageListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Game.GameType;

public class Main {

	private static JDA jda;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		String token = "";

		/*
		 * JDA jda = new JDABuilder(token).addEventListener(new
		 * Events()).build();
		 * 
		 * jda.awaitReady();
		 */

		// jda = (JDA) new JDABuilder(AccountType.BOT);

		JDABuilder builder = new JDABuilder(AccountType.BOT);
		builder.setToken(token);

		try {
			jda = builder.buildBlocking();
		} catch (LoginException | InterruptedException e) {
			e.printStackTrace();
		}

		if (jda == null) {
			System.out.println("[BOT] Failed to log in api.");
			return;
		}

		builder.setAutoReconnect(true);
		builder.setGame(Game.of(GameType.DEFAULT, "-help"));

		builder.addEventListener(new Events());
		builder.addEventListener(new MessageListener());
	}
	
	public static JDA getJda() {
		return jda;
	}
}
