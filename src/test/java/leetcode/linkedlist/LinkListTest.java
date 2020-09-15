package leetcode.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LinkListTest {
    private LinkList linkList = new LinkList();

    @Before
    public void setUp() {
        linkList.add(0, 1);
        linkList.add(1, 2);
    }

    @Test
    public void addFirstTest() {
        int val = 0;
        linkList.addFrist(val);
        assertThat(val, is(linkList.get(0)));
    }

    @Test
    public void addLastTest() {
        int lastVal = 3;
        linkList.addLast(lastVal);
        assertThat(lastVal, is(linkList.get(linkList.size() - 1)));
    }

    @Test
    public void addTest() {
        int val = 4;
        int k = 1;
        linkList.add(k, val);
        assertThat(val, is(linkList.get(k)));
    }

    @Test
    public void getSizeTest() {
        linkList.addLast(3);
        assertThat(linkList.size(), is(3));
    }

    @Test
    public void removeFirstTest() {
        linkList.removeFirst();
        assertThat(2, is(linkList.get(0)));
    }

    @Test
    public void removeTest() {
        // given
        linkList.addLast(3);

        //when
        linkList.remove(1);

        //then
        assertThat(3, is(linkList.get(1)));
        assertThat(linkList.size(), is(2));
    }

    @Test
    public void removeLastTest() {
        // given
        int lastVal = linkList.get(linkList.size() - 1);
        linkList.addLast(3);

        // when
        linkList.removeLast();

        // then
        assertThat(lastVal, is(linkList.get(linkList.size() - 1)));
    }

    @Test
    public void indexOfTest(){
        assertThat(linkList.indexOf(2), is(1));
        assertThat(linkList.indexOf(3), is(-1));
    }
}