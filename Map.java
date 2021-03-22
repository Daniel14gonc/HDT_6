public interface Map<K,V>{

  public int size();

  public boolean isEmpty();

  public boolean containsKey(K k);

  public boolean containsValue(V v);
  
  public V get(K k);

  public V put(K k, V v);

  public V remove(K k);
}