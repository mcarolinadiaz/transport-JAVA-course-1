package Transport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Linked list custom
public class CustomLinkedList<T>{
    private static final Logger LOGGER = LogManager.getLogger(CustomLinkedList.class);
    private T property;
    private NodeGeneric<T> node = null;
    private class NodeGeneric<T> {
        private T propertieNode;
        private int position;
        private NodeGeneric<T> following;
        public NodeGeneric() {
            this.position = 0;
            this.following = null;
        }

        public NodeGeneric(NodeGeneric<T> node) {
            this.propertieNode = node.getPropertyNode();
            this.position = node.getPosition();
            if (node.getFollowing() != null) {
                this.following = new NodeGeneric<T>(node.getFollowing());
            } else {
                this.following = null;
            }
        }

        public NodeGeneric(T propertieNode, int position, NodeGeneric<T> following) {
            this.propertieNode = propertieNode;
            this.position = position;
            if (following != null) {
                this.following = new NodeGeneric<T>(following);
            } else {
                this.following = null;
            }
        }

        public NodeGeneric(T propertieNode, int position) {
            this.propertieNode = propertieNode;
            this.position = position;
            this.following = null;
        }

        public NodeGeneric(T propertieNode) {
            this.propertieNode = propertieNode;
            this.position = 0;
            this.following = null;
        }

        public void linkNode(NodeGeneric<T> following){
            if (following != null) {
                this.following = new NodeGeneric<T>(following);
            }
            else {
                this.following = null;
            }
        }
        public NodeGeneric<T> getFollowing() {
            if (this.following != null) {
                return new NodeGeneric<T>(this.following);
            }
            return null;
        }
        public void setPosition(int position) {
            this.position = position;
        }
        public int getPosition() {
            return this.position;
        }
        public void setPropertyNode(T propertyNode) {
            this.propertieNode = propertyNode;
        }
        public T getPropertyNode() {
            return this.propertieNode;
        }
    }
    // Constructor
    public CustomLinkedList() {
        this.node = null;
    }
    // When you need add an element without specific position
    public void add(T element) {
        if (this.node == null) {
            this.node = new NodeGeneric<T>(element);
            this.node.setPosition(0);
            LOGGER.info("The element "+ element + "was added in the position " + 0 + "- Size list: " + this.size());
        } else {
            NodeGeneric<T> indexNode =  new NodeGeneric<T>(this.node);
            while (indexNode.getFollowing() != null) {
                indexNode = indexNode.getFollowing();
            }
            indexNode.linkNode(new NodeGeneric<T>(element, indexNode.getPosition() + 1));
            LOGGER.info("The element "+ element + " was added in the position " + indexNode.getFollowing().getPosition() + "- Size list: " + this.size());
        }
    }
    // Add element with specific position
    public void add(T element, int position) {
        if (this.node == null) {
            this.node = new NodeGeneric<T>(element);
            LOGGER.info("The element "+ element + "was added in the position " + 0 + "- Size list: " + this.size());
        } else {
            NodeGeneric<T> newNode = new NodeGeneric<T>(element);
            NodeGeneric<T> nodeIndex = new NodeGeneric<T>(this.node);
            while (nodeIndex.getFollowing() != null && nodeIndex.getFollowing().getPosition() < position) {
                nodeIndex = nodeIndex.getFollowing();
            }
            newNode.setPosition(position);
            if (nodeIndex.getFollowing() != null) {
                newNode.linkNode(nodeIndex.getFollowing());
            }
            nodeIndex.linkNode(newNode);
            LOGGER.info("The element "+ element + " was added in the position " + position + "- Size list: " + this.size());
        }
    }
    public T getPropertie() {
        return this.propertie;
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
            LOGGER.info("Result is: "+ result + "- NodeIndex: " + nodeIndex.getPropertyNode());
            nodeIndex = nodeIndex.getFollowing();
            LOGGER.info("NodeIndex is: "+ nodeIndex);
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
            if (nodeIndex.getPropertieNode().equals(element)) {

                return true;
            }
            nodeIndex = nodeIndex.getFollowing();
        }
        return false;
    }*/
}
