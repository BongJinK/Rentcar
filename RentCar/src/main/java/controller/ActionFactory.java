package controller;

import controller.action.ADupdateInfomation;
import controller.action.Action;
import controller.action.ClientLeaveAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.RegistAction;
import controller.action.ReserveVehicleAction;
import controller.action.RegistVehicleAction;
import controller.action.RemoveNoticeAction;
import controller.action.RemoveReviewAction;
import controller.action.UpdateBoardAction;
import controller.action.UpdateInformation;
import controller.action.UpdatePassword;
import controller.action.WriteBoardAction;

public class ActionFactory {

	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		if (command.equals("regist")) {
			action = new RegistAction();
		} else if (command.equals("login")) {
			action = new LoginAction();
		} else if (command.equals("logout")) {
			action = new LogoutAction();
		} else if (command.equals("leave")) {
			action = new ClientLeaveAction();
		} else if (command.equals("updateInfo")) {
			action = new UpdateInformation();
		} else if (command.equals("updatePassword")) {
			action = new UpdatePassword();
		} else if (command.equals("ADupdateInfomation")) {
			action = new ADupdateInfomation();
		} else if (command.equals("WriteBoard")) {
			action = new WriteBoardAction();
		} else if (command.equals("UpdateBoard")) {
			action = new UpdateBoardAction();
		} else if (command.equals("RemoveNotice")) {
			action = new RemoveNoticeAction();
		} else if (command.equals("RemoveReview")) {
			action = new RemoveReviewAction();
		} else if (command.equals("registVehicle")) {
			action = new RegistVehicleAction();
		} else if (command.equals("registReservation")) {
			action = new ReserveVehicleAction();
		}

		return action;
	}

}
