package com.hsy.java.base.collection;

import java.util.*;

/**
 * 
 * @description <p>
 *              请输入属性描述
 *              </p>
 * @time 2016年3月17日 下午6:21:53
 */
class SimpleEntry<K, V> implements Map.Entry<K, V>, java.io.Serializable {
	private final K key;
	private V value;

	// 定义如下两个构造器
	public SimpleEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public SimpleEntry(Map.Entry<? extends K, ? extends V> entry) {
		this.key = entry.getKey();
		this.value = entry.getValue();
	}

	// 获取key
	public K getKey() {
		return key;
	}

	// 获取value
	public V getValue() {
		return value;
	}

	// 改变该key-value对的value值
	public V setValue(V value) {
		V oldValue = this.value;
		this.value = value;
		return oldValue;
	}

	// 根据key比较两个SimpleEntry是否相等。
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o.getClass() == SimpleEntry.class) {
			SimpleEntry se = (SimpleEntry) o;
			return se.getKey().equals(getKey());
		}
		return false;
	}

	// 根据key计算hashCode
	public int hashCode() {
		return key == null ? 0 : key.hashCode();
	}

	public String toString() {
		return key + "=" + value;
	}
}

// 继承HashSet实现一个Map
public class Set2Map<K, V> extends HashSet<SimpleEntry<K, V>> {
	// 实现清空所有key-value对的方法
	public void clear() {
		super.clear();
	}

	// 判断是否包含某个key
	public boolean containsKey(K key) {
		return super.contains(new SimpleEntry<K, V>(key, null));
	}

	// 判断是否包含某个value
	public boolean containsValue(Object value) {
		for (SimpleEntry<K, V> se : this) {
			if (se.getValue().equals(value)) {
				return true;
			}
		}
		return false;
	}

	// 根据指定key取出对应的value
	public V get(Object key) {
		for (SimpleEntry<K, V> se : this) {
			if (se.getKey().equals(key)) {
				return se.getValue();
			}
		}
		return null;
	}

	// 将指定key-value对放入集合中
	public V put(K key, V value) {
		add(new SimpleEntry<K, V>(key, value));
		return value;
	}

	// 将另一个Map的key-value对放入该Map中
	public void putAll(Map<? extends K, ? extends V> m) {
		for (K key : m.keySet()) {
			add(new SimpleEntry<K, V>(key, m.get(key)));
		}
	}

	// 根据指定key删除指定key-value对
	public V removeEntry(Object key) {
		for (Iterator<SimpleEntry<K, V>> it = this.iterator(); it.hasNext();) {
			SimpleEntry<K, V> en = (SimpleEntry<K, V>) it.next();
			if (en.getKey().equals(key)) {
				V v = en.getValue();
				it.remove();
				return v;
			}
		}
		return null;
	}

	// 获取该Map中包含多少个key-value对
	public int size() {
		return super.size();
	}
}
