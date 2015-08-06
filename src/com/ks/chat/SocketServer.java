package com.ks.chat;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.common.collect.Maps;

@ServerEndpoint("/chat")
public class SocketServer {

	private static final Set<Session> sessions = Collections
			.synchronizedSet(new HashSet<Session>());
	private static final Map<String, String> sessionClientPair = new HashMap<String, String>();
	private JSONUtils jsonUtils = new JSONUtils();

	public static Map<String, String> getQueryParams(String query) {

		Map<String, String> params = Maps.newHashMap();

		if (query != null) {

			String[] strParams = query.split("&");

			for (String param : strParams) {

				String[] paramPair = param.split("=");
				params.put(paramPair[0], paramPair[1]);
			}
		}

		return params;
	}

	@OnOpen
	public void onOpen(Session session) {

		Map<String, String> queryParams = getQueryParams(session
				.getQueryString());
		String clientName = "";

		if (queryParams.containsKey("name")) {

			clientName = queryParams.get("name");

			try {

				clientName = URLEncoder.encode(clientName, "UTF-8");

			} catch (UnsupportedEncodingException e) {

				e.printStackTrace();
			}

			sessionClientPair.put(session.getId(), clientName);
		}

		sessions.add(session);
	}
}
