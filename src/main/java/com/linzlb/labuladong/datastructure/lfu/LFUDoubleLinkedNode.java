package com.linzlb.labuladong.datastructure.lfu;

/**
 * Link 节点
 * @author jiangwan.lin@tuya.com
 * @since 2022-04-06 1:45 下午 / V1.0
 */
public class LFUDoubleLinkedNode {

    public int val;
    public int key;
    public int freq;//频率
    public LFUDoubleLinkedNode prev;
    public LFUDoubleLinkedNode next;

    public LFUDoubleLinkedNode() {}

    public LFUDoubleLinkedNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
    }
}
