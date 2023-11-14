package Transport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

// Linked list custom
public class CustomLinkedList<T extends Comparable<T>>{
    private static final Logger LOGGER = LogManager.getLogger(CustomLinkedList.class);
    private NodeGeneric<T> node = null;
    private class NodeGeneric<T extends Comparable<T>> implements Comparable<NodeGeneric<T>> {
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


        @Override
        public int hashCode() {
            return Objects.hash(getPropertyNode(), getFollowing());
        }

        @Override
        public int compareTo(NodeGeneric<T> node) {
            return this.getPropertyNode().compareTo(node.getPropertyNode());
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
    // Returns the element at the specified position in the list.
    public T getElement(int position) {
        NodeGeneric<T> nodeIndex = this.node;
        int pos = 0;
        T element = null;
        while (nodeIndex != null && pos < position) {
            nodeIndex = nodeIndex.getFollowing();
            pos += 1;
        }
        if (pos == position && nodeIndex != null) {
            element = nodeIndex.getPropertyNode();
        }
        return element;
    }

    // Removes the element at the specified position in the list.
    public void remove(int position) {
        if (this.size() > position) {
            if (position == 0) {
                this.node = this.node.getFollowing();
                LOGGER.info("The element was removed in the position 0 - Size list: " + this.size());
            }
            else {
                NodeGeneric<T> nodeIndex = this.node;
                int pos = 1;
                while (nodeIndex.getFollowing() != null && pos < position) {
                    nodeIndex = nodeIndex.getFollowing();
                    pos += 1;
                }
                if (pos == position && nodeIndex.getFollowing() != null) {
                    nodeIndex.linkNode(nodeIndex.getFollowing().getFollowing());
                    LOGGER.info("The element was removed in the position "+  position + "- Size list: " + this.size());
                } else {
                    LOGGER.warn("The element wasn't found");
                }
            }
        }
    }

    // Returns the position at the element in the list.
    public int getPosition(T element) {
        int position = 0;
        NodeGeneric<T> nodeIndex = this.node;
        while (nodeIndex != null && nodeIndex.getPropertyNode().compareTo(element) != 0) {
            nodeIndex = nodeIndex.getFollowing();
            position += 1;
        }
        if (nodeIndex != null) {
            return position;
        }
        position = -1;
        return position;
    }

    // Removes the specific element in the list.
    public void removeByElement(T element) {
        if (this.node != null) {
            if (this.node.getPropertyNode().compareTo(element) == 0) {
                this.node = this.node.getFollowing();
                LOGGER.info("The element was removed in the position 0 - Size list: " + this.size());
            }
            else {
                NodeGeneric<T> nodeIndex = this.node;
                while (nodeIndex.getFollowing() != null && nodeIndex.getFollowing().getPropertyNode().compareTo(element) != 0) {
                    nodeIndex = nodeIndex.getFollowing();
                }
                if (nodeIndex.getFollowing() != null) {
                    nodeIndex.linkNode(nodeIndex.getFollowing().getFollowing());
                    LOGGER.info("The element was removed "+  element + "- Size list: " + this.size());
                }
                else {
                    LOGGER.warn("The element wasn't found");
                }
            }
        }
    }

    @Override
    public String toString() {
        return "CustomLinkedList{" +
                "node=" + node +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(node);
    }
}
