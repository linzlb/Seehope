package com.linzlb.labuladong.datastructure.lfu;

/**
 * LinkedList
 * @author jiangwan.lin@tuya.com
 * @since 2022-04-06 1:46 下午 / V1.0
 */
public class LFUDoubleLinkedList {

    public LFUDoubleLinkedNode head;
    public LFUDoubleLinkedNode tail;

    public LFUDoubleLinkedList() {
        this.head = new LFUDoubleLinkedNode();
        this.tail = new LFUDoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 插入节点
     */
    public void addToHead(LFUDoubleLinkedNode node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    /**
     * 删除节点
     */
    public void remove(LFUDoubleLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 删除尾部节点
     */
    public LFUDoubleLinkedNode removeLast() {
        LFUDoubleLinkedNode node = tail.prev;
        remove(node);
        return node;
    }
}
