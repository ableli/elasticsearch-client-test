/**
 * 
 */
package com.haoli;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import com.google.gson.Gson;

/**
 * @author Administrator
 *
 */
public class ObjectPutInES {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Create Client
		Settings settings = ImmutableSettings.settingsBuilder().put("client.transport.sniff", true).put("cluster.name", "hao.li").build();  
		Client client = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress("localhost", 9300));  
		
		
		IMMessage msg = new IMMessage(100, 101, "实际应用中应该是下面一种更方便，可以把需要索引的对象直接扔过去了 ");  
		Gson gson = new Gson();
		IndexResponse  response = client.prepareIndex("msg_index", "msg_info", String.valueOf(msg.getMsgid())).setSource(gson.toJson(msg)).execute().actionGet();  
		System.out.println(gson.toJson(response));
		
		client.close();

	}

}
