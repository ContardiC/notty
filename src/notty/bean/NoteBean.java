package notty.bean;

import java.io.Serializable;

public class NoteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 569071561131432216L;
	String title="";
	String body="";
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
