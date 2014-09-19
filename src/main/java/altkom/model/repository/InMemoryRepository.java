package altkom.model.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PreDestroy;

import altkom.model.Entry;
import javax.annotation.PostConstruct;

public class InMemoryRepository implements PhoneBookRepository {

	private Map<Long, Entry> entries = null;
	
	public void init(){
                System.out.println("********Starting Repository");
		if(entries== null)
			throw new IllegalStateException();
	}
	
	@PreDestroy
	public void finish(){
		System.out.println("Finalize Repository");
	}
	
        @PostConstruct
	public void finish1(){
		System.out.println("************Postconstruct");
	}
        
	@Override
	public void save( Entry entry ) {
		final boolean notSavedYet = ( entry.getId() == null );
		if ( notSavedYet ) {
			entry.setId( determineId() );
		}
		
		entries.put( entry.getId(), entry );
	}
	
	@Override
	public void update( Entry entry ) {
		//mb: nothing to do
	}
	
	@Override
	public Entry findById( Long id ) {
		return (Entry) entries.get( id );
	}
	
	@Override
	public List<Entry> findAllEntries() {
		return new ArrayList<Entry>( entries.values() );
	}
	
	@Override
	public void logToSysout() {
		System.out.println("Aktualny stan bazy = " + entries );
	}
	
	private Long determineId() {
		return new Long( entries.keySet().size() + 1 );
	}

	public void setEntries(Map<Long, Entry> entries) {
		this.entries = entries;
	}

	public void setEntriesAsList(List<Entry> entries) {
		if(this.entries == null)
			this.entries = new HashMap<Long,Entry>();
		this.entries.clear();
		for(Entry entry : entries){
			this.entries.put(entry.getId(), entry);
		}
	}

}
