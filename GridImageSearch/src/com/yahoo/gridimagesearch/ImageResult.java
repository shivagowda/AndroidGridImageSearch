/**
 * 
 */
package com.yahoo.gridimagesearch;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author shivan
 *
 */
public class ImageResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4151892901001319605L;
	/**
	 * 
	 */
	private String fullUrl;
	private String thumbUrl;


	public ImageResult(JSONObject json) {
		try {
			this.fullUrl = json.getString("url");
			this.thumbUrl = json.getString("tbUrl");
		} catch (JSONException e) {
			this.fullUrl = null;
			this.thumbUrl = null;
		}
	}

	public String getFullUrl() {
		return fullUrl;
	}
	public void setFullUrl(String fullUrl) {
		this.fullUrl = fullUrl;
	}
	public String getThumbUrl() {
		return thumbUrl;
	}
	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}

	public String toString() {
		return this.thumbUrl;
	}

	public static ArrayList<ImageResult> fromJSONArray(
			JSONArray imageJsonResults) {

		ArrayList<ImageResult> results = new ArrayList<ImageResult>();
		for(int x = 0; x < imageJsonResults.length(); x++) {
			try {
				results.add(new ImageResult(imageJsonResults.getJSONObject(x)));
			} catch(JSONException e) {
				e.printStackTrace();
			}
		}
		return results;
	}
}
