package com.taskboard.entities;

import java.util.Map;

import com.mongodb.BasicDBObject;


public class Task extends BasicDBObject {
	private static final long serialVersionUID = 1L;

	public final static int TODO  = -1;
	public final static int IN_PROGRESS =  0;
	public final static int DONE  =  1;
	
	public Task() {
		super();
	}

	public Task(int size) {
		super(size);
	}

	public Task(@SuppressWarnings("rawtypes") Map m) {
		super(m);
	}

	public Task(String key, Object value) {
		super(key, value);
	}

	public Task(String label, int status) {
		this.setLabel(label);
		this.setStatus(status);
	}

	public void setLabel(String label) {
		this.put("label", label);
	}

	public void setStatus(int status) {
		this.put("status", status);
	}

}
