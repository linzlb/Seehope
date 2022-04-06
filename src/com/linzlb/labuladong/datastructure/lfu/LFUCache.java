package com.linzlb.labuladong.datastructure.lfu;

import java.util.HashMap;
import java.util.Map;

/**
 * LFU（least frequently used (LFU) page-replacement algorithm）,即最不经常使用页置换算法.
 * LFU根据数据的历史访问频率来淘汰数据，其核心思想是“如果数据过去被访问多次，那么将来被访问的频率也更高”。
 * LFU实现的难点同样在于要在O(1)的时间复杂度下完成置换，但LFU同LRU不同，最近最少使用这一条件使得调出的页面被限定在了空间的尾部，因此查找到这一调出页面的效率是O(1)，但LFU需要知道哪一个页面的历史使用次数最少，这个节点是不固定的。
 * 为了解决这一问题，本文采取 双HashMap+双向链表 的方案
 * 这一方案的核心在于：
 * 第一个HashMap的键值对为 key 和双向链表节点，第二个HashMap的键值对为频数和每个频数对应的双向链表（将所有相同频数的节点组成的链表），此外，再维护一个全局最小频数【即操作数】；
 * 每次插入一个新节点时，如果空间已满，此时查找最小频数对应的链表，并将该链表的尾部节点取出并删除（O(1)操作），同时维护最小频数【查看最小频数对应的链表是否为空】，最后再删除第一个HashMap中对应的节点，最后将新的节点插入；
 * 每次要获取一个已有节点时，则更新最小频数，并将对应的链表进行调整，由于操作了一次该节点，因此该节点需要移动至【频数+1】对应的链表头部
 *
 * @author jiangwan.lin@tuya.com
 * @since 2022-04-06 1:41 下午 / V1.0
 */
public class LFUCache {

    public int capacity; // 最大容量
    public int size; // 当前容量
    public Map<Integer, LFUDoubleLinkedList> freqMap; // 相同频次链表
    public Map<Integer, LFUDoubleLinkedNode> cache; // 节点存储
    public int minFreq; // 当前最小频次

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
        freqMap = new HashMap<>();
        cache = new HashMap<>();
    }

    /**
     * 获取页面
     */
    public int get(int key) {
        LFUDoubleLinkedNode node = cache.get(key);
        if (node == null) {
            throw new RuntimeException("PAGE_IS_NOT_EXIST");
        }
        updateFreq(node);
        return node.val;
    }

    /**
     * 插入页面
     */
    public void put(int key, int val) {
        if (capacity == 0) {
            throw new RuntimeException("CACHE_CAPACITY_ZERO");
        }
        LFUDoubleLinkedNode node = cache.get(key);
        if (node == null) {
            if (size == capacity) {
                LFUDoubleLinkedList minLfuDoubleLinkedList = freqMap.get(minFreq);
                LFUDoubleLinkedNode lfuDoubleLinkedNode = minLfuDoubleLinkedList.removeLast();
                cache.remove(lfuDoubleLinkedNode.key);
                size--;
            }
            node = new LFUDoubleLinkedNode(key, val);
            cache.put(key, node);
            LFUDoubleLinkedList lfuDoubleLinkedList = freqMap.get(node.freq);
            if (lfuDoubleLinkedList == null) {
                lfuDoubleLinkedList = new LFUDoubleLinkedList();
                freqMap.put(node.freq, lfuDoubleLinkedList);
            }
            lfuDoubleLinkedList.addToHead(node);
            size++;
            minFreq = 1;
        }else {
            node.val = val;
            updateFreq(node);
        }
    }

    /**
     * 更新频次
     */
    public void updateFreq(LFUDoubleLinkedNode node) {
        // 删除老频次链表中的节点
        int freq = node.freq;
        LFUDoubleLinkedList lfuDoubleLinkedListOld = freqMap.get(freq);
        lfuDoubleLinkedListOld.remove(node);

        // 更新当前最小频次
        if (freq == minFreq && lfuDoubleLinkedListOld.head.next == lfuDoubleLinkedListOld.tail) {
            minFreq = freq+1;
        }

        // 插入到新频次链表
        node.freq = freq + 1;
        LFUDoubleLinkedList lfuDoubleLinkedListNew = freqMap.get(node.freq);
        if (lfuDoubleLinkedListNew == null) {
            lfuDoubleLinkedListNew = new LFUDoubleLinkedList();
            freqMap.put(node.freq, lfuDoubleLinkedListNew);
        }
        lfuDoubleLinkedListNew.addToHead(node);
    }

    /**
     * 测试,详细测试前往 https://leetcode-cn.com/problems/lfu-cache/submissions/
     */
    public static void main(String[] args) {

        LFUCache lfuCache = new LFUCache(2);
        System.out.println("------------LFU测试------------");
        lfuCache.put(3, 1);
        lfuCache.put(2, 1);
        lfuCache.put(2, 2);
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(2));

    }
}
