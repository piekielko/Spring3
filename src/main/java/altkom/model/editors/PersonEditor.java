package altkom.model.editors;

import java.beans.PropertyEditorSupport;
import java.util.StringTokenizer;

import altkom.model.Person;

public class PersonEditor extends PropertyEditorSupport {

	@Override
	public void setAsText( String text ) throws IllegalArgumentException {

		StringTokenizer tokenizer = new StringTokenizer(text,";");
		Person person = new Person(	Long.valueOf(tokenizer.nextToken()),
									tokenizer.nextToken(),
									tokenizer.nextToken());
		setValue( person );
	}
	
}
