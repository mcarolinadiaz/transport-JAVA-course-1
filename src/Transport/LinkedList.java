package Transport;

import java.util.HashSet;
import java.util.Set;

public class LinkedList<T>{
    private final T propertie;
    private final Set<NodeGeneric<T>> nodeGroup = new HashSet<NodeGeneric<T>>();
    private static class NodeGeneric<T> {
        private T propertieNode;
        private int position;
        private NodeGeneric<T> following;
        public void linkedNode(NodeGeneric<T> following){
            this.following = following;
        }
        public NodeGeneric<T> getFollowing() {
            return this.following;
        }
    }
    // Constructor
    public LinkedList(T propertie) {
        this.propertie = propertie;
    }

    public void add(T element) {/*
        if (element.getClass() == this.propertie.getClass()) {

            this.nodeGroup.add((NodeGeneric<T>) element);
        }*/

    }
}
