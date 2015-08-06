package com.ks.chat;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {

	private static final String FLAG_SELF = "self";
	private static final String FLAG_NEW = "new";
	private static final String FLAG_MESSAGE = "message";
	private static final String FLAG_EXIT = "exit";

	public String getClientDetails(String sessionID, String message) {

		String json = null;
		JSONObject jsonObject = new JSONObject();

		try {

			jsonObject.put("flag", FLAG_SELF);
			jsonObject.put("sessionID", sessionID);
			jsonObject.put("message", message);
			json = jsonObject.toString();

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return json;
	}

	public String getNewClient(String sessionID, String name, String message,
			int onlineCount) {

		String json = null;
		JSONObject jObj = new JSONObject();

		try {

			jObj.put("flag", FLAG_NEW);
			jObj.put("name", name);
			jObj.put("sessionId", sessionID);
			jObj.put("message", message);
			jObj.put("onlineCount", onlineCount);

			json = jObj.toString();

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return json;
	}

	public String getClientExitJson(String sessionId, String name,
			String message, int onlineCount) {

		String json = null;
		JSONObject jObj = new JSONObject();

		try {

			jObj.put("flag", FLAG_EXIT);
			jObj.put("name", name);
			jObj.put("sessionId", sessionId);
			jObj.put("message", message);
			jObj.put("onlineCount", onlineCount);

			json = jObj.toString();

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return json;
	}

	public String getSendAllMessageJson(String sessionId, String fromName,
			String message) {

		String json = null;
		JSONObject jObj = new JSONObject();

		try {

			jObj.put("flag", FLAG_MESSAGE);
			jObj.put("sessionId", sessionId);
			jObj.put("name", fromName);
			jObj.put("message", message);

			json = jObj.toString();

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return json;
	}
}
