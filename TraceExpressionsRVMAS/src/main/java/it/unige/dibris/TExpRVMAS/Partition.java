package it.unige.dibris.TExpRVMAS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class representing a partition of agents used to obtain the decentralized runtime verification of a JADE MAS
 * @author angeloferrando
 *
 */
public class Partition<T> {
	private Set<Set<T>> constraints = new HashSet<>();
	
	public Partition(){}
	
	public Partition(List<List<? extends T>> partition){
		if(partition == null) return;
		for(List<? extends T> constraint : partition){
			if(constraint != null && constraint.size() > 0){
				HashSet<T> newConstraint = new HashSet<>();
				for(T elem: constraint){
					newConstraint.add(elem);
				}
				constraints.add(newConstraint);
			}
		}
	}
	
	public boolean areMonitoredTogether(Set<? extends T> elem1, Set<? extends T> elem2){
		for(Set<T> set : constraints){
			if(set.containsAll(elem1) && set.containsAll(elem2)){
				return true;
			}
		}
		return false;
	}
	
	public <E extends T> void addConstraint(E elem1, E elem2){
		Set<T> set1 = null;
		Set<T> set2 = null;
		for(Set<T> set : constraints){
			if(set1 != null && set2 != null){
				break;
			}
			if(set.contains(elem1)){
				set1 = set;
			}
			if(set.contains(elem2)){
				set2 = set;
			}
		}
		if(set1 != null){
			if(set2 != null){
				for(T elem : set2){
					set1.add(elem);
				}
				constraints.remove(set2);
			} else{
				set1.add(elem2);
			}
		} else{
			if(set2 != null){
				set2.add(elem1);
			}else{
				Set<T> newConstraint = new HashSet<>();
				newConstraint.add(elem1);
				newConstraint.add(elem2);
				constraints.add(newConstraint);
			}
		}
	}
	
	public <E extends T> void makeIndependent(E elem){
		for(Set<T> set : constraints){
			if(set.contains(elem)){
				if(set.size() > 1){
					set.remove(elem);
					Set<T> newConstraint = new HashSet<>();
					newConstraint.add(elem);
					constraints.add(newConstraint);
					break;
				}
			}
		}
	}
	
	@Override
	public String toString(){
		String res = "[";
		for(Set<T> constraint : constraints){
			res += "[";
			for(T elem : constraint){
				res += " " + elem + ",";
			}
			res = res.substring(0, res.length() - 1) + " ]";
		}
		return res + " ]";
	}
	
}
