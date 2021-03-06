public class ArrayList {

	private Object [] array;
	
	
	public ArrayList () {
		this.array = new Object [0];
	}
	
	
	public void add (Object content) {
		Object [] expanded = new Object[this.array.length+1];
		System.arraycopy(this.array,0,expanded,0,this.array.length);
		expanded[this.array.length] = content;
		this.array = expanded;
	}
	
	
	public void add (Object content, int position) {
	    if (position < this.array.length) {
	        this.array[position] = content;
	    } else {
	        this.array = auxAdd(content,position);
	    }
	}
	
	
	public int size () {
		return this.array.length;
	}
	
	
	public Object get (int position) {
		return this.array[position];
	}
	
	
	public boolean contains (Object content) {
		for (int i = 0; i < this.array.length; i++) {
			if ( this.array[i].equals(content) ) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public int indexOf (Object content) {
		for (int i = 0; i < this.array.length; i++) {
			if ( this.array[i].equals(content) ) {
			    return i;
			}
		}
		
		return -1;
	}
	
	
	public int lastIndexOf (Object content) {
		for (int i = this.array.length-1; i >= 0; i--) {
			if ( this.array[i].equals(content) ) {
				return i;
			}
		}
		
		return -1;
	}
	
	
	public void remove (int position) {
	    this.array = auxRemovePosition(position);
	}
	
	
	public void remove (Object content) {
	    for (int i = 0; i < this.array.length; i++) {
			if ( this.array[i].equals(content) ) {
				this.remove(i);
				break;
			}
		}
	}
	
	
	public void clear () {
		this.array = new Object [0];
	}
	
	
	public boolean isEmpty () {
		if (this.array.length == 0) {
		    return true;
		}
			
		return false;
	}
	
	
	public ArrayList clone () {
		ArrayList clone = new ArrayList();
		clone.array = this.array.clone();
		return clone;
	}
	
	
	public Object [] toArray () {
		return this.array;
	}
	
	
	@Override
	public String toString () {
		if ( this.isEmpty() ) {
		    return "The ArrayList is Empty";
		}
		
		return auxToString ();
	}
	
	
	private String auxToString () {
	    String vectorInChain = "";
	    
	    for (int i = 0; i < this.array.length; i++) {
	        vectorInChain += this.array[i] + ",";
	    }
	    
	    return '{' + vectorInChain.substring(0,vectorInChain.length()-1) + '}';
	}
	
	
	private Object [] auxRemovePosition (int position) {
	    int count = 0;
	    Object [] reduced = new Object[this.array.length-1];
	    
	    for (int i = 0; i < this.array.length; i++) {
	        if (i != position) {
	            reduced[count++] = this.array[i];
	        }
	    }
	    
	    return reduced;
	}
	
	
	private Object [] auxAdd (Object content, int position) {
	        Object [] expanded = new Object[position+1];
	        System.arraycopy(this.array,0,expanded,0,this.array.length);
	        expanded[position] = content;
	        return expanded;
	}
}
