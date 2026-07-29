import java.util.ArrayList;

class BST {
    Bus root;

    // Insert a bus
    public void insert(int id, String name, String destination, double fare) {
        root = insertRec(root, id, name, destination, fare);
    }

    private Bus insertRec(Bus root, int id, String name, String destination, double fare) {
        if (root == null) {
            return new Bus(id, name, destination, fare);
        }

        if (id < root.busID) {
            root.left = insertRec(root.left, id, name, destination, fare);
        } else if (id > root.busID) {
            root.right = insertRec(root.right, id, name, destination, fare);
        }

        return root;
    }

    // Search bus
    public Bus search(Bus root, int id) {
        if (root == null || root.busID == id)
            return root;

        if (id < root.busID)
            return search(root.left, id);

        return search(root.right, id);
    }

    // Display buses
    public void inorder(Bus root) {
        if (root != null) {
            inorder(root.left);
            System.out.println("Bus ID: " + root.busID +
                    " | Name: " + root.busName +
                    " | Destination: " + root.destination +
                    " | Fare: " + root.fare);
            inorder(root.right);
        }
    }

    // Store buses in ArrayList
    public void store(Bus root, ArrayList<Bus> list) {
        if (root != null) {
            store(root.left, list);
            list.add(root);
            store(root.right, list);
        }
    }
}