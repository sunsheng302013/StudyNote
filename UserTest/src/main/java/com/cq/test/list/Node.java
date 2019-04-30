/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.test.list;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年3月1日
 * @author chengq
 */
public class Node<E> {

    E item;
    Node<E> preNode;
    Node<E> nextNode;

    public Node(E item, Node<E> preNode, Node<E> nextNode) {
        this.item = item;
        this.preNode = preNode;
        this.nextNode = nextNode;
    }
}
