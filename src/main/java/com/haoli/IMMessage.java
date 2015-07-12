package com.haoli;

public class IMMessage {
	private long userid;
	private long msgid;
	private String msg;
	public IMMessage(){
		
	}
	
	public IMMessage(long uid,long mid,String message){
		this.userid = uid;
		this.msgid = mid;
		this.msg= message;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public long getMsgid() {
		return msgid;
	}

	public void setMsgid(long msgid) {
		this.msgid = msgid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
