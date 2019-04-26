package collectionDeep;

import java.util.Iterator;
import java.util.LinkedHashMap;
/**
 * MapÉú³ÉÆ÷
 * @author Administrator
 *
 * @param <K>
 * @param <V>
 */
@SuppressWarnings("serial")
public class MapData<K,V> extends LinkedHashMap<K,V> {
	public MapData(Iterator<Pair<K,V>> gen,int quantity) {
		for(int i=0;i<quantity;i++) {
			Pair<K,V> p = gen.next();
			put(p.key,p.value);
		}
	}
	public static <K,V> MapData<K,V> map(Iterator<Pair<K,V>> i,int q){
		return new MapData<K,V>(i,q);
	}
}
