package Transport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Linked list custom
public class CustomLinkedList<T>{
    private static final Logger LOGGER = LogManager.getLogger(CustomLinkedList.class);
    private NodeGeneric<T> node = null;
    private class NodeGeneric<T> {
        private T propertyNode;
        private NodeGeneric<T> following;
        public NodeGeneric() {
            this.following = null;
        }

        public NodeGeneric(NodeGeneric<T> node) {
            this.propertyNode = node.getPropertyNode();
            if (node.getFollowing() != null) {
                this.following = new NodeGeneric<T>(node.getFollowing());
            } else {
                this.following = null;
            }
        }

        public NodeGeneric(T propertyNode, NodeGeneric<T> following) {
            this.propertyNode = propertyNode;
            if (following != null) {
                this.following = new NodeGeneric<T>(following);
            } else {
                this.following = null;
            }
        }

        public NodeGeneric(T propertyNode) {
            this.propertyNode = propertyNode;
            this.following = null;
        }

        public void linkNode(NodeGeneric<T> following){
            this.following = following;
        }
        public NodeGeneric<T> getFollowing() {
            return this.following;
        }
        public void setPropertyNode(T propertyNode) {
            this.propertyNode = propertyNode;
        }
        public T getPropertyNode() {
            return this.propertyNode;
        }

        @Override
        public String toString() {
            return "NodeGeneric{" +
                    "propertyNode=" + propertyNode +
                    ", following=" + following +
                    '}';
        }
    }
    // Constructor
    public CustomLinkedList() {
        this.node = null;
    }
    // When you need add an element without specific position
    public void add(T element) {
        if (this.node == null) {
            this.node = new NodeGeneric<>(element);
            LOGGER.info("The element "+ element + "was added in the position " + 0 + "- Size list: " + this.size());
        } else {
            NodeGeneric<T> indexNode =  this.node;
            while (indexNode.getFollowing() != null) {
                indexNode = indexNode.getFollowing();
            }
            indexNode.linkNode(new NodeGeneric<T>(element));
            LOGGER.info("The element "+ element + " was added in the position - Size list: " + this.size());
        }
    }
    // Add element with specific position
    public void add(T element, int position) {
        if (this.node == null) {
            this.node = new NodeGeneric<T>(element);
            LOGGER.info("The element "+ element + "was added in the position " + 0 + "- Size list: " + this.size());
        } else if (position == 0) {
                NodeGeneric<T> newNode = new NodeGeneric<T>(element);
                newNode.linkNode(this.node);
                this.node = newNode;
            } else {
                int pos = 1;
                NodeGeneric<T> nodeIndex = this.node;
                NodeGeneric<T> newNode = new NodeGeneric<T>(element);
                while (nodeIndex.getFollowing() != null && pos < position) {
                    pos+=1;
                    nodeIndex = nodeIndex.getFollowing();
                }
                newNode.linkNode(nodeIndex.getFollowing());
                nodeIndex.linkNode(newNode);
                LOGGER.info("The element "+ element + " was added in the position " + position + "- Size list: " + this.size());
            }
    }
    // To check if list is empty or not.
    public boolean isEmpty() {
        return this.node == null;
    }
    // To get the number of elements in the list.
    public int size() {
        int result = 0;
        NodeGeneric<T> nodeIndex = this.node;
        while (nodeIndex != null) {
            result = result + 1;
            nodeIndex = nodeIndex.getFollowing();
        }
        return result;
    }
    // Returns true if this list contains the specified element.
    public boolean contains(T element) {
        NodeGeneric<T> nodeIndex = this.node;
        while (nodeIndex != null) {
            if (nodeIndex.getPropertyNode().equals(element)) {
                return true;
            }
            nodeIndex = nodeIndex.getFollowing();
        }
        return false;
    }
    // Removes the first occurrence of the specified element from this list.
    /*private void removeSpecificElement(NodeGeneric<T> delete) {
        if (delete != null && delete.getFollowing() != null) {
            NodeGeneric<T> nodeAux = delete;
            if (delete.getFollowing() != null) {
                nodeAux.linkedNode(delete.getFollowing());
            }
            nodeAux.linkedNode(delete.getFollowing());
        }
    }
    public boolean remove(T element) {/*
        NodeGeneric<T> nodeIndex = this.node;
        if (nodeIndex != null) {
            if (this.node.getFollowing() != null) {
                this.node = this.node.getFollowing();
            }
        }*//*
        while (nodeIndex != null) {
            if (nodeIndex.getPropertyNode().equals(element)) {

                return true;
            }
            nodeIndex = nodeIndex.getFollowing();
        }
        return false;
    }*/

    @Override
    public String toString() {
        return "CustomLinkedList{" +
                "node=" + node +
                '}';
    }
}
