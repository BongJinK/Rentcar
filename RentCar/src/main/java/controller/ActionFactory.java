package controller;

import controller.action.Action;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.RegistAction;
import controller.action.UpdateInformation;
import controller.action.UpdatePassword;

public class ActionFactory{

	private ActionFactory() {}
	
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if( command.equals("regist")) {
			action = new RegistAction();
		}else if( command.equals("login")) {
			action = new LoginAction();
		}else if( command.equals("logout")) {
			action = new LogoutAction();
		}else if( command.equals("updateInfo")) {
			action = new UpdateInformation();
		}else if( command.equals("updatePassword")) {
			action = new UpdatePassword();
		}
		
		return action;
	}

}
