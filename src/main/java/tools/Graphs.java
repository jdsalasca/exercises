package tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;
import java.util.stream.Collectors;
public class Graphs {
	
	private static Logger LOGGER = Logger.getLogger("Graphs");

	private HashMap<String, List<String>> graph = new HashMap<>();

	public Graphs() {
		this.graph = onBuildGraph();
	}

	private HashMap<String, List<String>> onBuildGraph() {
		List <String> emptyList = new ArrayList<>();


		graph.put("you", Arrays.asList("alice", "bob", "claire"));
		graph.put("bob", Arrays.asList("anuj", "peggy", "you"));
		graph.put("alice",Arrays.asList("peggy"));
		graph.put("claire", Arrays.asList("thom", "jonny"));
		graph.put("anuj", emptyList);
		graph.put("peggy",emptyList);
		graph.put("thom", emptyList);
		graph.put("jonny", emptyList);

		return graph;

	}

	public HashMap<String, List<String>> getGraphs() {
		return graph;
	}

	public void setGraphs(HashMap<String,  List<String>> graphs) {
		this.graph = graphs;
	}

	public boolean breath_first_search_algorithm(){
		//first step is to create a queue
        Queue<String> queue = new LinkedList<>();
        queue.addAll(this.graph.get("you"));
        
        //now we need to create list to keep the people that we have 
        //already checked to avoid an infine loop and to avoid infinite work
        LinkedList<String> peopleChecked = new LinkedList<>();

        
    //with this part of the algorithm we are looking for the 
    // mango seller though the list c:
	while (!queue.isEmpty()) {
		String person =  queue.poll();
		LOGGER.info(person);
		//in this process I could think about implement a hashmap instead of a
		// linkedList just if the amount of people is shot because
		//hashMap takes more memory but is faster.
		if (is_person_checked(peopleChecked, person)) {
			LOGGER.info(person + " WAS ALREADY CHECKED");
			
		}else if (is_person_mango_seller(person)) {
			LOGGER.info(person + " Is the mango seller");
			return true;
		}else {
			peopleChecked.add(person);
			queue.addAll(this.graph.get(person));
		}
	}
	return false;

	}
	
	private boolean is_person_checked(LinkedList<String> people, String person) {
		//return false;
		return people.stream().filter(personLL -> personLL.equals(person)).collect(Collectors.toList()).size()> 0;
	}
	
	

	
	
	private boolean is_person_mango_seller (String person) {
		
		return person.startsWith("k");
	}

}
