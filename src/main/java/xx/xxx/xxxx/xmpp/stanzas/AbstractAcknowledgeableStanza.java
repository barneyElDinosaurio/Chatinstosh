package xx.xxx.xxxx.xmpp.stanzas;

import xx.xxx.xxxx.xml.Element;

abstract public class AbstractAcknowledgeableStanza extends AbstractStanza {

	protected AbstractAcknowledgeableStanza(String name) {
		super(name);
	}


	public String getId() {
		return this.getAttribute("id");
	}

	public void setId(final String id) {
		setAttribute("id", id);
	}

	public Element getError() {
		Element error = findChild("error");
		if (error != null) {
			for(Element element : error.getChildren()) {
				if (!element.getName().equals("text")) {
					return element;
				}
			}
		}
		return null;
	}
}
