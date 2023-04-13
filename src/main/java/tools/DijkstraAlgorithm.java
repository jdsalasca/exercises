package tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DijkstraAlgorithm {

	private HashMap<String, HashMap<String, Integer>> nodes = new HashMap<>();
	private HashMap<String, Integer> costs = new HashMap<>();
	private HashMap<String, String> parents = new HashMap<>();

	public DijkstraAlgorithm() {

		onSetUpHashMaps();
		
	}

//	@SuppressWarnings("serial")
//	private void onSetUpHashMaps() {
//		this.costs.put("Start", 0);
//		this.costs.put("A", 6);
//		this.costs.put("B", 2);
//		this.costs.put("FIN", Integer.MAX_VALUE);
//		this.parents.put("A", "Start");
//		this.parents.put("B", "Start");
//		this.parents.put("FIN", null);
//		this.nodes.put("Start", new HashMap<String, Integer>() {
//			{
//				put("A", 6);
//				put("B", 2);
//			}
//		});
//		this.nodes.put("A", new HashMap<String, Integer>() {
//			{
//				put("FIN", 1);
//			}
//		});
//		this.nodes.put("B", new HashMap<String, Integer>() {
//			{
//				put("A", 3);
//				put("FIN", 5);
//			}
//		});
//		this.nodes.put("FIN", new HashMap<String, Integer>() {
//			{
//
//			}
//		});
//	}

	@SuppressWarnings("serial")
	private void onSetUpHashMaps() {
		this.costs.put("Start", 0);
		this.costs.put("A", 5);
		this.costs.put("B", 2);
		this.costs.put("C", Integer.MAX_VALUE);
		this.costs.put("D", Integer.MAX_VALUE);
		this.costs.put("FIN", Integer.MAX_VALUE);
		this.parents.put("A", "Start");
		this.parents.put("B", "Start");
		this.parents.put("C", null);
		this.parents.put("D", null);
		this.parents.put("FIN", null);
		this.nodes.put("Start", new HashMap<String, Integer>() {
			{
				put("A", 5);
				put("B", 2);
			}
		});
		this.nodes.put("A", new HashMap<String, Integer>() {
			{
				put("C", 4);
				put("D", 2);
			}
		});
		this.nodes.put("B", new HashMap<String, Integer>() {
			{
				put("A", 8);
				put("D", 7);
			}
		});
			this.nodes.put("C", new HashMap<String, Integer>() {
				{
					put("D", 1);
					put("FIN", 3);
				}
			});
		this.nodes.put("D", new HashMap<String, Integer>() {
			{
				put("FIN", 1);
				
			}
		});
		this.nodes.put("FIN", new HashMap<String, Integer>() {
			{

			}
		});	
	}
	
	
	public void dijkstra_algorithm(Integer flag) {
		Set<String> keys = nodes.keySet();
		//List<String> keys = List.of("Start", "B","A", "FIN");
		for (String key : keys) {
			Integer costToKey = costs.get(key);
			HashMap<String, Integer> neighbors = nodes.get( key);
			Set<String> neighborKeys = neighbors.keySet();
			for (String neigbor: neighborKeys) { 
				Integer new_const = neighbors.get(neigbor)+ costToKey;
				if (costs.get(neigbor) > new_const) {
					costs.put(neigbor, new_const);
					parents.put(neigbor, key);
				}
			}
		}
		if (flag ==0) {
			flag = 4;
			dijkstra_algorithm(flag);
		}
		
		System.out.println("costs" + costs);
		System.out.println("parents" +parents);
		System.out.println(nodes);
		System.out.println("stop");
	}
	
	

}
