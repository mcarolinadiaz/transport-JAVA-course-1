package Transport;

public class LinkedList<T>{
    private final T propertie;
    private NodeGeneric<T> node = null;
    private static class NodeGeneric<T> {
        private T propertieNode;
        private int position;
        private NodeGeneric<T> following;
        public NodeGeneric() {
            this.position = 0;
            this.following = null;
        }

        public NodeGeneric(NodeGeneric<T> node) {
            this.propertieNode = node.getPropertieNode();
            this.following = node.getFollowing();
            this.position = node.getPosition();
        }

        public NodeGeneric(T propertieNode, int position, NodeGeneric<T> following) {
            this.propertieNode = propertieNode;
            this.following = new NodeGeneric<T>(following);
            this.position = position;
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

        public void linkedNode(NodeGeneric<T> following){
            this.following = new NodeGeneric<T>(following);
        }
        public NodeGeneric<T> getFollowing() {
            return new NodeGeneric<T>(this.following);
        }
        public void setPosition(int position) {
            this.position = position;
        }
        public int getPosition() {
            return this.position;
        }
        public void setPropertieNode(T propertieNode) {
            this.propertieNode = propertieNode;
        }
        public T getPropertieNode() {
            return this.propertieNode;
        }
    }
    // Constructor
    public LinkedList(T propertie) {
        this.propertie = propertie;
    }

    public void add(T element) {
        if (element.getClass() == this.propertie.getClass()) {
            NodeGeneric<T> newNode = new NodeGeneric<T>(element);
            if (this.node == null) {
                this.node = newNode;
                this.node.setPosition(0);
            } else {
                NodeGeneric<T> indexNode =  new NodeGeneric<T>(this.node);
                while (indexNode.getFollowing() != null) {
                    indexNode = indexNode.getFollowing();
                }
                newNode.setPosition(indexNode.getPosition() + 1);
                indexNode.linkedNode(newNode);
            }
        }
    }

    public void add(T element, int position) {
        if (element.getClass() == this.propertie.getClass()) {
            NodeGeneric<T> newNode = new NodeGeneric<T>(element);
            if (this.node == null) {
                this.node = newNode;
            } else {
                NodeGeneric<T> nodeIndex = new NodeGeneric<T>(this.node);
                while (nodeIndex.getFollowing() != null && nodeIndex.getFollowing().getPosition() < position) {
                    nodeIndex = nodeIndex.getFollowing();
                }
                newNode.setPosition(position);
                if (nodeIndex.getFollowing() != null) {
                    newNode.linkedNode(nodeIndex.getFollowing());
                }
                nodeIndex.linkedNode(newNode);
            }

        }

    }
    public T getPropertie() {
        return this.propertie;
    }
    public boolean isEmptly() {
        return this.node == null;
    }
}
