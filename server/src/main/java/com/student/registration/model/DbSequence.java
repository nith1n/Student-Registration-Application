package com.student.registration.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="db_sequence")
public class DbSequence {

	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";

	@Id
	private String id;
	private int seqNo;


	public DbSequence() {
		super();
	}
	public DbSequence(String id, int seqNo) {
		super();
		this.id = id;
		this.seqNo = seqNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}


}
