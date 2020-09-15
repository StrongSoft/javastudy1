package leetcode.linkedlist;

public class LinkList {
    private SinglyListNode head;
    private SinglyListNode tail;
    private int size = 0;

    public void addFrist(int val) {
        //노드를 생성한다.
        SinglyListNode newNode = new SinglyListNode(val);
        //새로운 노드의 다음 노드로 해더를 지정한다.
        newNode.next = head;

        //해드로 새로운 노드를 할당
        head = newNode;
        //사이즈 증가
        size++;
        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(int val) {
        //새로운 노드를 생성한다..
        SinglyListNode newNode = new SinglyListNode(val);

        //리스트에 노드가 존재여부
        if (size == 0) {
            addFrist(val);
        } else {
            // 기존 마지막 노드의 다음 노드로 생성한 노드를 할당
            tail.next = newNode;
            // 마지막 노드를 새로운 노드를 할당
            tail = newNode;
            //사이즈 증가
            size++;
        }
    }

    //현재 노드를 가져오기
    public SinglyListNode node(int index) {
        SinglyListNode x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public void add(int k, int val) {
        //만약 첫번째 위치에 저장하고 싶다면
        if (k == 0) {
            addFrist(val);
        } else { //특정 위치에 저장
            // 바로 앞에 노드를 가져온다.
            SinglyListNode beforeNode = node(k - 1);
            // 해당 노드의 next를 가져온다.
            SinglyListNode afterNode = beforeNode.next;
            // 새로운 노드를 생성한다.
            SinglyListNode newNode = new SinglyListNode(val);

            // 이전 노드의 다음 next에 생성된 노드를 할당
            beforeNode.next = newNode;
            // 신규 노드의 다음 next에 after노드를 할당
            newNode.next = afterNode;
            //사이즈 증가
            size++;

            //새로운 노드가 마지막인경우 tail 지정
            if (newNode.next == null) {
                tail = newNode;
            }

        }
    }

    public int size() {
        return size;
    }

    public String toString() {
        if (head == null) {
            return "[]";
        }

        //탐색을 시작
        SinglyListNode node = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        //다음 노드가 없을때까지 반복
        while (node.next != null) {
            sb.append(node.val);
            sb.append(",");
            node = node.next;
        }

        //마지막 노드를 출력 결과에 포함
        sb.append(node.val);
        sb.append("]");
        return sb.toString();
    }

    public int removeFirst() {
        //첫번째 노드를 지울 노드로 지정하고 head를 다음 노드로 지정
        SinglyListNode removeNode = head;
        head = removeNode.next;

        //노드를 지우기전에 데이터를 기록
        int resultVal = removeNode.val;
        removeNode = null;
        size--;

        return resultVal;
    }

    public int remove(int k) {

        if (k == 0) { // 첫번째 노드를 삭제하는 경우
            return removeFirst();
        } else {
            // 바로 앞에 노드를 가져온다.
            SinglyListNode beforeNode = node(k - 1);

            // 삭제할 노드의 next를 가져온다.
            SinglyListNode removeNode = beforeNode.next;

            beforeNode.next = beforeNode.next.next;

            int val = removeNode.val;

            if (removeNode == tail) {
                tail = beforeNode;
            }

            removeNode = null;
            size--;

            return val;
        }
    }

    public int removeLast() {
        return remove(size - 1);
    }

    public int get(int k) {
        SinglyListNode currentNode = node(k);
        return currentNode.val;
    }

    public int indexOf(int val) {
        // 탐색 대상이 되는 노드를 지정합니다.
        SinglyListNode searchNode = head;
        // 탐색 대상이 몇번째 엘리먼트에 있는지를 의미하는 변수로 index를 사용합니다.
        int index = 0;
        // 탐색 값과 탐색 대상의 값을 비교합니다.
        while (searchNode.val != val) {
            searchNode = searchNode.next;
            index++;
            // temp의 값이 null이라는 것은 더 이상 탐색 대상이 없다는 것을 의미합니다.이 때 -1을 리턴합니다.
            if (searchNode == null) {
                return -1;
            }
        }
        // 탐색 대상을 찾았다면 대상의 인덱스 값을 리턴합니다.
        return index;
    }

    // 반복자를 생성해서 리턴해줍니다.
    public ListIterator listIterator() {
        return new ListIterator();
    }

    class ListIterator {
        private SinglyListNode lastReturned;
        private SinglyListNode next;
        private int nextIndex;

        ListIterator() {
            next = head;
            nextIndex = 0;
        }

        // 본 메소드를 호출하면 next의 참조값이 기존 next.next로 변경됩니다.
        public Object next() {
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.val;
        }

        public boolean hasNext() {
            return nextIndex < size();
        }

        public void add(int input) {
            SinglyListNode newNode = new SinglyListNode(input);
            if (lastReturned == null) {
                head = newNode;
                newNode.next = next;
            } else {
                lastReturned.next = newNode;
                newNode.next = next;
            }
            lastReturned = newNode;
            nextIndex++;
            size++;
        }

        public void remove() {
            if (nextIndex == 0) {
                throw new IllegalStateException();
            }
            LinkList.this.remove(nextIndex - 1);
            nextIndex--;
        }

    }

}
