package com.sqli.taskboard.business;

import static com.sqli.taskboard.entities.Task.TODO;
import static com.sqli.taskboard.entities.Task.IN_PROGRESS;
import static com.sqli.taskboard.entities.Task.DONE;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.sqli.taskboard.entities.Task;


public class TaskboardService {

	// Singleton
	private static TaskboardService instance = null;
	private TaskboardService() {};
	public static TaskboardService get() {
		if (instance == null) instance = new TaskboardService();
		return instance;
	}
	
	/** The collection of tasks in database */
	private DBCollection taskboard;

	/**
	 * 
	 */
	public void initTaskboard() {
		try {
			DB db = new Mongo().getDB("taskboard-db");
			taskboard = db.getCollection("taskboard");
			taskboard.setObjectClass(Task.class);
			resetTaskboard();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void resetTaskboard() {
		taskboard.drop();
		taskboard.insert(new Task("Partir en vacances, passer du bon temps et revenir avec des souvenirs plein la tête !", TODO));
		taskboard.insert(new Task("Payer un coup à Barry", TODO));
		taskboard.insert(new Task("Payer un coup à Julien", TODO));
		taskboard.insert(new Task("Payer un coup à Antoine", TODO));
		taskboard.insert(new Task("Coder un petit peu pour le super concours HTML5", IN_PROGRESS));
		taskboard.insert(new Task("Assister au Kesako HTML5", DONE));
	}

	/**
	 * 
	 * @param status
	 * @return
	 */
	public List<Task> findTasksByStatus(int status) {
		Task query = new Task();
		query.setStatus(status);
		DBCursor cursor = taskboard.find(query);

		List<Task> tasks = new ArrayList<Task>();
		while (cursor.hasNext()) 
			tasks.add((Task) cursor.next());
		return tasks;
	}

	/**
	 * Create
	 * @param label 
	 */
	public void add(String label) {
		taskboard.save(new Task(label, TODO));
	}
	
	/**
	 * Update the status of a task
	 * @param id id of the task
	 * @param status the status to set
	 */	
	public void updateTaskStatus(String id, int status) {
		Task query = new Task("_id", new ObjectId(id));
		Task task = (Task) taskboard.findOne(query);
		task.setStatus(status);
		taskboard.update(query, task);
	}
	
	/**
	 * Remove the task identified by the given id
	 * @param id id of the task
	 */
	public void remove(String id) {
		taskboard.remove(new Task("_id", new ObjectId(id)));
	}
	
}
