package ar.edu.itba.it.paw.services;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import ar.edu.itba.it.paw.model.Action;

public class ActionService {
	private static ActionService instance;
	private static List<HashMap<String, List<Action>>> actionMaps;

	private ActionService() {
		initialize();
	}

	public static ActionService getInstance() {
		if (instance == null) {
			return new ActionService();
		}
		return instance;
	}

	public List<Action> getActions(int userLevel, String page) {
		List<Action> actions = new LinkedList<Action>();
		if (userLevel >= 0 && userLevel <= 2) {
			for (int i = userLevel; i <= 2; i++) {
				actions.addAll(actionMaps.get(i).get(page));
			}
			return actions;
		}
		return null;
	}

	public void initialize() {
		actionMaps = new LinkedList<HashMap<String, List<Action>>>();
		HashMap<String, List<Action>> levelCeroHashMap = new HashMap<String, List<Action>>();
		HashMap<String, List<Action>> levelOneHashMap = new HashMap<String, List<Action>>();
		HashMap<String, List<Action>> levelTwoHashMap = new HashMap<String, List<Action>>();
		
		/*RestaurantList actions*/
		List<Action> restaurantListActions = new LinkedList<Action>();
		restaurantListActions.add(new Action("/FoodNow/removeRestaurant?id=","delete"));
		restaurantListActions.add(new Action("/FoodNow/editRestaurant?id=","edit"));
		levelCeroHashMap.put("restaurantList", restaurantListActions);
		levelOneHashMap.put("restaurantList", new LinkedList<Action>());
		levelTwoHashMap.put("restaurantList", new LinkedList<Action>());
		actionMaps.add(0, levelCeroHashMap);
		actionMaps.add(1, levelOneHashMap);
		actionMaps.add(2, levelTwoHashMap);
	}
}
