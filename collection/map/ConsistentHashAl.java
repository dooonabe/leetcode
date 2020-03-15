package com.dooonabe.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * use treemap instance consistent hash al
 * virtual nodes
 * Created on 2019/3/24.
 */
public class ConsistentHashAl {
    final long SIZE = Double.doubleToLongBits(Math.pow(2, 32) - 1);

    class Member {
        String key;

        public Member(String key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    class Node {
        String name;
        Map<Long, Member> node = new HashMap<>();

        public Node(String name) {
            this.name = name;
        }

        public void put(Member member) {
            node.put(member.hashCode() % SIZE, member);
        }

        public Member get(Member member) {
            return node.get(member);
        }

        /**
         * Returns a hash code value for the object. This method is
         * supported for the benefit of hash tables such as those provided by
         * {@link HashMap}.
         * <p>
         * The general contract of {@code hashCode} is:
         * <ul>
         * <li>Whenever it is invoked on the same object more than once during
         * an execution of a Java application, the {@code hashCode} method
         * must consistently return the same integer, provided no information
         * used in {@code equals} comparisons on the object is modified.
         * This integer need not remain consistent from one execution of an
         * application to another execution of the same application.
         * <li>If two objects are equal according to the {@code equals(Object)}
         * method, then calling the {@code hashCode} method on each of
         * the two objects must produce the same integer result.
         * <li>It is <em>not</em> required that if two objects are unequal
         * according to the {@link Object#equals(Object)}
         * method, then calling the {@code hashCode} method on each of the
         * two objects must produce distinct integer results.  However, the
         * programmer should be aware that producing distinct integer results
         * for unequal objects may improve the performance of hash tables.
         * </ul>
         * <p>
         * As much as is reasonably practical, the hashCode method defined by
         * class {@code Object} does return distinct integers for distinct
         * objects. (This is typically implemented by converting the internal
         * address of the object into an integer, but this implementation
         * technique is not required by the
         * Java&trade; programming language.)
         *
         * @return a hash code value for this object.
         * @see Object#equals(Object)
         * @see System#identityHashCode
         */
        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }

    class Nodes {
        TreeMap<Long, Node> nodes = new TreeMap<>();
        volatile long size = 0L;

        public void addNode(Node node) {
            nodes.put(node.hashCode() % SIZE, node);
        }

        /**
         * 删除节点，移除数据到顺时针方向的第一个节点
         *
         * @param node 节点对象
         */
        public void delNode(Node node) {
            long thisNodeIndex = node.hashCode() % SIZE;
            long nextNodeIndex = nodes.tailMap(thisNodeIndex).isEmpty() ? nodes.firstKey() : nodes.tailMap(thisNodeIndex).firstKey();
            nodes.get(nextNodeIndex).node.putAll(node.node);
            nodes.remove(thisNodeIndex);
        }

        public Member get(Member member) {
            // todo deal hash collision
            long index = member.hashCode() % SIZE;
            Node node = nodes.get(index);
            if (node != null) {
                return node.get(member);
            } else {
                long nodeIndex = nodeIndex = nodes.tailMap(index).isEmpty() ? nodes.firstKey() : nodes.tailMap(index).firstKey();
                return nodes.get(nodeIndex).get(member);
            }
        }

        public void put(Member member) {
            // todo deal hash collision
            long index = member.hashCode() % SIZE;
            Node node = nodes.get(index);
            if (node != null) {
                node.put(member);
            } else {
                long nodeIndex = nodeIndex = nodes.tailMap(index).isEmpty() ? nodes.firstKey() : nodes.tailMap(index).firstKey();
                nodes.get(nodeIndex).put(member);
            }
        }

        //todo make some virtual nodes
    }

}
