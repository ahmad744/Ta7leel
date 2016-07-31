package logsv3;

public class LinkedList {
    // reference to the head node.

    private Node head;
    private int listCount;
    //  public Object[] Info ;

    // LinkedList constructor
    public LinkedList() {
        // this is an empty list, so the reference to the head node
        // is set to a new node with no data
        head = new Node(null, null);
        listCount = 0;
        //  Info = new Object[5];

    }

    public void add(Object data, Object ser, Object Co, Object re, Object Cy, Object Time, Object lat, Object lon) // post: appends the specified element to the end of this list.
    {

        Node temp = new Node(data, ser, Co, re, Cy, Time, lat, lon);
        Node current = head;
        // starting at the head node, crawl to the end of the list
        while (current.getNext() != null) {
            current = current.getNext();

        }
        // the last node's "next" reference set to our new node
        current.setNext(temp);
        listCount++;// increment the number of elements variable
    }

    public void add(Object data, Object ser, Object Co, Object re, Object Cy, Object Time, Object lat, Object lon, int index) // post: inserts the specified element at the specified position in this list.
    {
        Node temp = new Node(data, ser, Co, re, Cy, Time, lat, lon);
        Node current = head;
        // crawl to the requested index or the last element in the list,
        // whichever comes first
        for (int i = 1; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        // set the new node's next-node reference to this node's next-node reference
        temp.setNext(current.getNext());
        // now set this node's next-node reference to the new node
        current.setNext(temp);
        listCount++;// increment the number of elements variable
    }

    public void addUser(Object data, int index) // post: inserts the specified element at the specified position in this list.
    {
        Node current = head.getNext();
        // crawl to the requested index or the last element in the list,
        // whichever comes first
        for (int i = 1; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        current.user.add(data);
    }

    public void addPort(Object data, int index) // post: inserts the specified element at the specified position in this list.
    {
        Node current = head.getNext();
        // crawl to the requested index or the last element in the list,
        // whichever comes first
        for (int i = 1; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        current.port.add(data);
    }

    public void addUTime(Object data, int index) // post: inserts the specified element at the specified position in this list.
    {
        Node current = head.getNext();
        // crawl to the requested index or the last element in the list,
        // whichever comes first
        for (int i = 1; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        current.time.add(data);
    }

    public void addDate(Object data, int index) // post: inserts the specified element at the specified position in this list.
    {
        Node current = head.getNext();
        // crawl to the requested index or the last element in the list,
        // whichever comes first
        for (int i = 1; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        current.date.add(data);
    }

    public Object[] getInfo(int index) // post: returns the element at the specified position in this list.
    {
        // index must be 1 or higher
        if (index <= 0) {
            return null;
        }

        Node current = head.getNext();
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) {
                return null;
            }

            current = current.getNext();
        }
        return current.getData();
    }

    public Object getCountry(int index) // post: returns the element at the specified position in this list.
    {
        // index must be 1 or higher
        if (index <= 0) {
            return null;
        }

        Node current = head.getNext();
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) {
                return null;
            }

            current = current.getNext();
        }
        return current.getCountry();
    }

    public int getSizeofPorts(int index) // post: returns the element at the specified position in this list.
    {
        // index must be 1 or higher
        if (index <= 0) {
            return 0;
        }

        Node current = head.getNext();
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) {
                return 0;
            }

            current = current.getNext();
        }
        return current.port.size();
    }

    public Object[] getUsers(int index) // post: returns the element at the specified position in this list.
    {
        // index must be 1 or higher

        if (index <= 0) {
            return null;
        }

        Node current = head.getNext();
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) {
                return null;
            }

            current = current.getNext();
        }
        Object[] User = new Object[(current.user.size()) + 1];
        for (int i = 1; i < (current.user.size() + 1); i++) {
            User[i] = current.user.get(i);
        }
        return User;
    }

    public Object[] getPorts(int index) // post: returns the element at the specified position in this list.
    {
        // index must be 1 or higher

        if (index <= 0) {
            return null;
        }

        Node current = head.getNext();
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) {
                return null;
            }

            current = current.getNext();
        }
        Object[] Port = new Object[(current.port.size()) + 1];
        for (int i = 1; i < (current.port.size() + 1); i++) {
            Port[i] = current.port.get(i);
        }
        return Port;
    }

    public Object[] gettime(int index) // post: returns the element at the specified position in this list.
    {
        // index must be 1 or higher

        if (index <= 0) {
            return null;
        }

        Node current = head.getNext();
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) {
                return null;
            }

            current = current.getNext();
        }
        Object[] time = new Object[(current.time.size()) + 1];
        for (int i = 1; i < (current.time.size() + 1); i++) {
            time[i] = current.time.get(i);
        }
        return time;
    }

    public Object[] getDate(int index) // post: returns the element at the specified position in this list.
    {
        // index must be 1 or higher

        if (index <= 0) {
            return null;
        }

        Node current = head.getNext();
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) {
                return null;
            }

            current = current.getNext();
        }
        Object[] date = new Object[(current.date.size() + 1)];
        for (int i = 1; i < (current.date.size() + 1); i++) {
            date[i] = current.date.get(i);
        }
        return date;
    }

    public boolean remove(int index) // post: removes the element at the specified position in this list.
    {
        // if the index is out of range, exit
        if (index < 1 || index > size()) {
            return false;
        }

        Node current = head;
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) {
                return false;
            }

            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        listCount--; // decrement the number of elements variable
        return true;
    }

    public int size() // post: returns the number of elements in this list.
    {
        return listCount;
    }

    public boolean empty() {
        return head == null;
    }

    public int Search(String data) {
        Object[] x;

        Node current = head.getNext();
        if (listCount == 0) {
            return 0;
        }

        for (int i = 1; i <= listCount; i++) {
            x = current.getData();
            if (x[0].equals(data)) {
                return i;
            } else {
                current = current.getNext();
            }
        }
        return 0;
    }

    public String toString() {
        Node current = head.getNext();
        String output = "";
        while (current != null) {
            output += "[" + current.getData().toString() + "]";
            current = current.getNext();
        }
        return output;
    }

    private class Node {

        Node next;
        Object data;
        Object ser_key;
        Object Country;
        Object region;
        Object City;
        Object Time_Zone;
        Object latitude;
        Object longitude;
        Object[] Info;
        LinkedList1 user;
        LinkedList1 port;
        LinkedList1 time;
        LinkedList1 date;

        // Node constructor
        public Node(Object _data, Object ser, Object Co, Object re, Object Cy, Object Time, Object lat, Object lon) {
            next = null;
            data = _data;
            ser_key = ser;
            Country = Co;
            region = re;
            City = Cy;
            Time_Zone = Time;
            latitude = lat;
            longitude = lon;
            Info = new Object[8];
            user = new LinkedList1();
            port = new LinkedList1();
            time = new LinkedList1();
            date = new LinkedList1();

        }

        // another Node constructor if we want to
        // specify the node to point to.
        public Node(Object _data, Node _next) {
            next = _next;
            data = _data;
        }

        // these methods should be self-explanatory
        public Object[] getData() {
            Info[0] = data;
            Info[1] = ser_key;
            Info[2] = Country;
            Info[3] = region;
            Info[4] = City;
            Info[5] = Time_Zone;
            Info[6] = latitude;
            Info[7] = longitude;
            return Info;
        }

        public Object getCountry() {
            return Country;
        }

        public void setData(Object _data) {
            data = _data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node _next) {
            next = _next;
        }
    }
}
